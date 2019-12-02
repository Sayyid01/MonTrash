/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montrash_oneforall.controler;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.xml.bind.DatatypeConverter;
import montrash_oneforall.model.HistoriPengangkutan;
import montrash_oneforall.model.HistoriTransaksi;
import montrash_oneforall.model.Status;
import montrash_oneforall.model.SharedData;
import montrash_oneforall.view.formLogin;
import montrash_oneforall.view.formPengguna;
import montrash_oneforall.view.formRegister;
/**
 *
 * @author Sayyid
 */
public class Function {
    private Connection conn=Koneksi.bukaKoneksi();
    public ArrayList<Status> arrStatus = new ArrayList<>();
    public ArrayList<HistoriTransaksi> arrHistori = new ArrayList<>();
    public ArrayList<HistoriPengangkutan> arrHistoriAngkut = new ArrayList<>();
    
    public Boolean login(String email, String password){
        boolean cek = false;
        if(conn!=null){
            if(email.equals("") || password.equals("")){
                JOptionPane.showMessageDialog(null,"Username/Password tidak boleh kosong", "WARNING", JOptionPane.ERROR_MESSAGE);
            }else{
                String query="SELECT id FROM pengguna WHERE email=? AND password=?";
                try{
                  PreparedStatement ps = conn.prepareStatement(query);
                  ps.setString(1, email);
                  ps.setString(2, password);
                    ResultSet rs = ps.executeQuery();
                    if(rs.next()){
                        cek = true;
                        int id_pengguna = rs.getInt("id");
                        System.out.println(id_pengguna+" in login");
                        SharedData.setId_pengguna(id_pengguna);
                    }else{
                        JOptionPane.showMessageDialog(null,"EMAIL/PASSWORD SALAH!", "Warning", JOptionPane.ERROR_MESSAGE);
                    }
                    rs.close();
                    ps.close();
                }catch(SQLException e){
                    Logger.getLogger(formLogin.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return cek;
    }
     
    public Boolean register(String nama, String alamat, String email, String noHp, String password){
        boolean cek=false;
        if(conn!=null){
            String query="INSERT INTO pengguna (nama, alamat, email, no_hp, password, level) VALUES (?,?,?,?,?,'user')";
            try {
                PreparedStatement ps  = conn.prepareStatement(query);
                ps.setString(1, nama);
                ps.setString(2, alamat);
                ps.setString(3, email);
                ps.setString(4, noHp);
                ps.setString(5, password);
                int hasil = ps.executeUpdate();
                if(hasil == 1){
                    cek = true;
                    JOptionPane.showMessageDialog(null, "Input Berhasil");
                }
            } catch (SQLException ex) {
                Logger.getLogger(formRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cek;
    }
   
    public void getUserData(int id_pengguna){
       if(conn!=null){           
            String query="SELECT pengguna.nama, transaksi.status_pembayaran, pengangkutan.status_angkut, pengangkutan.id_transaksi FROM pengguna JOIN transaksi "
                      + "ON pengguna.id = transaksi.id_pengguna JOIN pengangkutan ON transaksi.id = pengangkutan.id_transaksi WHERE pengguna.id=?";
            try{
              PreparedStatement ps = conn.prepareStatement(query);
              ps.setInt(1, id_pengguna);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String nama = rs.getString("nama");
                    int status_angkut = rs.getInt("pengangkutan.status_angkut");
                    int status_pembayaran = rs.getInt("transaksi.status_pembayaran");
                    int id_transaksi = rs.getInt("pengangkutan.id_transaksi");
                    Status status = new Status(nama, id_transaksi, status_angkut, status_pembayaran);
                    arrStatus.add(status);
//                    System.out.println(arrStatus.isEmpty()+" ini id_transaksi");
                }
                rs.close();
                ps.close();
            }catch(SQLException e){
              Logger.getLogger(formPengguna.class.getName()).log(Level.SEVERE, null, e);
          }
       }
   }
   
    public void kirimKeterangan(String keterangan, int id_pengangkutan, int id_transaksi){
        if(conn!=null){
            String query = "UPDATE pengangkutan SET keterangan=? WHERE id=? AND id_transaksi=?";
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, keterangan);
                ps.setInt(2, id_pengangkutan);
                ps.setInt(3, id_transaksi);
                int hasil = ps.executeUpdate();
                if(hasil==1){
                    JOptionPane.showMessageDialog(null, "Berhasil menambahkan keterangan");
                }
            }catch(SQLException e){
                Logger.getLogger(formPengguna.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    /*
     * Fungsi untuk Histori Transaksi
     */
    public void loadDataHistori(int id_pengguna){
        if(conn!=null){
            String query = "SELECT*FROM transaksi WHERE id_pengguna=?";
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, id_pengguna);
                ResultSet rs = ps.executeQuery();
                int nomorUrut = 0;
                while(rs.next()){
                    nomorUrut++;
                    String tanggalTransaksi = rs.getString("tanggal_transaksi");
                    float jumlahBayar = rs.getFloat("jumlah_bayar");
                    int statusPembayaran = rs.getInt("status_pembayaran");
                    if(statusPembayaran!=0){
                        String statusBayar = "Lunas";
                        HistoriTransaksi histori = new HistoriTransaksi(nomorUrut, tanggalTransaksi, jumlahBayar, statusBayar);
                        arrHistori.add(histori);
                    }else{
                        String statusBayar = "Belum Lunas";
                        HistoriTransaksi histori = new HistoriTransaksi(nomorUrut, tanggalTransaksi, jumlahBayar, statusBayar);
                        arrHistori.add(histori);
                    }
                }
                rs.close();
                ps.close();
            }catch(SQLException e){
                Logger.getLogger(formPengguna.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
        public void loadDataHistoriAngkut(int id_transaksi){
        if(conn!=null){
            String query = "SELECT*FROM pengangkutan WHERE id_transaksi=?";
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, id_transaksi);
                ResultSet rs = ps.executeQuery();
                int nomorUrut = 0;
                while(rs.next()){
                    nomorUrut++;
                    String tanggalTransaksi = rs.getString("tanggal_pengangkutan");
                    int statusAngkut = rs.getInt("status_angkut");
                    String keterangan = rs.getString("keterangan");
                    if(statusAngkut!=0){
                        String statusPengangkutan = "Sudah Diangkut";
                        HistoriPengangkutan historiAngkut = new HistoriPengangkutan(nomorUrut, tanggalTransaksi, statusPengangkutan, keterangan);
                        arrHistoriAngkut.add(historiAngkut);
                    }else{
                        String statusPengangkutan = "Belum Diangkut";
                        HistoriPengangkutan historiAngkut = new HistoriPengangkutan(nomorUrut, tanggalTransaksi, statusPengangkutan, keterangan);
                        arrHistoriAngkut.add(historiAngkut);
                    }
                }
                rs.close();
                ps.close();
            }catch(SQLException e){
                Logger.getLogger(formPengguna.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
   
 /**
 * Hashing with SHA1
 *
 * @param input String to hash
 * @return String hashed
 */
   public String sha1(String password){
       String sha1= null;
       try{
            MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
            msdDigest.update(password.getBytes("UTF-8"), 0, password.length());
            sha1 = DatatypeConverter.printHexBinary(msdDigest.digest());
       }catch(UnsupportedEncodingException | NoSuchAlgorithmException e){
           Logger.getLogger(Function.class.getName()).log(Level.SEVERE, null, e);
       }
       
       return sha1;
   }
    
}
