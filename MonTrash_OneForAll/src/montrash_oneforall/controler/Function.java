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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.xml.bind.DatatypeConverter;
import montrash_oneforall.model.HistoriPengangkutan;
import montrash_oneforall.model.HistoriTransaksi;
import montrash_oneforall.model.Pengguna;
import montrash_oneforall.model.Status;
import montrash_oneforall.model.SharedData;
import montrash_oneforall.view.formAdmin;
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
    
    /*
    Function for Login
    */
    public Boolean login(String email, String password){
        boolean cek = false;
        if(conn!=null){
            if(email.equals("") || password.equals("")){
                JOptionPane.showMessageDialog(null,"Username/Password tidak boleh kosong", "WARNING", JOptionPane.ERROR_MESSAGE);
            }else{
                String query="SELECT id, level, nama FROM pengguna WHERE email=? AND password=?";
                try{
                  PreparedStatement ps = conn.prepareStatement(query);
                  ps.setString(1, email);
                  ps.setString(2, password);
                    ResultSet rs = ps.executeQuery();
                    if(rs.next()){
                        cek = true;
                        int id_pengguna = rs.getInt("id");
                        String nama = rs.getString("nama");
                        String level = rs.getString("level");
                        System.out.println(id_pengguna+" in login");
                        SharedData.setId_pengguna(id_pengguna);
                        SharedData.setLevel(level);
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
    public Boolean cekSudoLevel(){
     boolean cekSudoLevel=false;
     String level = SharedData.getLevel();
        if(level.equalsIgnoreCase("admin")){
            cekSudoLevel=true;
        }
     return cekSudoLevel;
    }
     
    /*
    Function for add new user
    */
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
                    JOptionPane.showMessageDialog(null, "User berhasil ditambahkan");
                }
            } catch (SQLException ex) {
                Logger.getLogger(formRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cek;
    }
   
    /*
    Function for Status tab in user side and some data for admin side
    */
    public void getStatusUserData(int id_pengguna){
       if(conn!=null){           
            String query="SELECT pengguna.nama, pengguna.status, transaksi.tanggal_transaksi, "
                    + "transaksi.status_pembayaran, pengangkutan.tanggal_pengangkutan, "
                    + "pengangkutan.status_angkut, pengangkutan.keterangan, pengangkutan.id_transaksi "
                    + "FROM pengguna JOIN transaksi ON pengguna.id = transaksi.id_pengguna "
                    + "JOIN pengangkutan ON transaksi.id = pengangkutan.id_transaksi WHERE pengguna.id=?";
            try{
              PreparedStatement ps = conn.prepareStatement(query);
              ps.setInt(1, id_pengguna);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String nama = rs.getString("nama");
                    String statusPengguna = rs.getString("status");
                    String keterangan = rs.getString("keterangan");
                    int status_angkut = rs.getInt("pengangkutan.status_angkut");
                    int status_pembayaran = rs.getInt("transaksi.status_pembayaran");
                    int id_transaksi = rs.getInt("pengangkutan.id_transaksi");
                    Status status = new Status(nama, statusPengguna, id_transaksi, status_angkut, keterangan, status_pembayaran);
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
    public ArrayList<HistoriTransaksi> arrHistori = new ArrayList<>();
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
    
    //Histori pengangkutan
    public ArrayList<HistoriPengangkutan> arrHistoriAngkut = new ArrayList<>();
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
        
    /*
    Function for admin    
    */    
   //Get all user data in pengguna table
    public ArrayList<Pengguna> arrPengguna = new ArrayList<>();
    public void getUserData(){
        if(conn!=null){
            String query="SELECT*FROM pengguna WHERE level='user'";
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int id_pengguna =rs.getInt("id");
                    String nama = rs.getString("nama");
                    String alamat = rs.getString("alamat");
                    String email = rs.getString("email");
                    String noHp = rs.getString("no_hp");
                    String status = rs.getString("status");
                    Pengguna pengguna = new Pengguna(id_pengguna, nama, alamat, email, noHp, status);
                    arrPengguna.add(pengguna);
                }
                rs.close();
                ps.close();
            }catch(SQLException e){
            }
        }
    }
    public void cariPenggunaKeyword(String keyword){
        if(conn!=null){
            String query="SELECT*FROM pengguna WHERE nama LIKE? AND level='user'";
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, "%"+keyword+"%");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int id_pengguna =rs.getInt("id");
                    String nama = rs.getString("nama");
                    String alamat = rs.getString("alamat");
                    String email = rs.getString("email");
                    String noHp = rs.getString("no_hp");
                    String status = rs.getString("status");
                    Pengguna pengguna = new Pengguna(id_pengguna, nama, alamat, email, noHp, status);
                    arrPengguna.add(pengguna);
                }
                rs.close();
                ps.close();
            }catch(SQLException e){
            }
        }
    }
    
    public void updateDataAngkut(int idPengguna, Date tanggalPengangkutan, int statusAngkut){
        if(conn!=null){
            String query="UPDATE pengangkutan JOIN transaksi ON pengangkutan.id_transaksi=transaksi.id"
                    + "JOIN pengguna ON transaksi.id_pengguna=? SET pengangkutan.tanggal_pengangkutan=?,"
                    + "pengangkutan.status_angkut=?";
            try{
                PreparedStatement ps = conn.prepareStatement(query);                
                ps.setInt(1, idPengguna);
                ps.setDate(2, tanggalPengangkutan);
                ps.setInt(3, statusAngkut);
                int hasil = ps.executeUpdate();
                if(hasil==1){
                    JOptionPane.showMessageDialog(null, "Berhasil update data pengangkutan");
                }
            }catch(SQLException e){
                Logger.getLogger(formAdmin.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
 /**
 * Hashing with SHA1
 *
 * @param password
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
