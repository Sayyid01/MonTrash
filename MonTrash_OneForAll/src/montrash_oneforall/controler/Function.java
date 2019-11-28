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
import montrash_oneforall.model.DataPengguna;
import montrash_oneforall.model.SharedData;
import montrash_oneforall.view.formPengguna;
/**
 *
 * @author Sayyid
 */
public class Function {
    private Connection conn=Koneksi.bukaKoneksi();
    public ArrayList<DataPengguna> arrDataPengguna = new ArrayList<>();
    
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
                    Logger.getLogger(formPengguna.class.getName()).log(Level.SEVERE, null, e);
                }
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
                    int status_sampah = rs.getInt("pengangkutan.status_angkut");
                    int status_pembayaran = rs.getInt("transaksi.status_pembayaran");
                    int id_transaksi = rs.getInt("pengangkutan.id_transaksi");
                    DataPengguna dataPengguna = new DataPengguna(nama, status_sampah, status_pembayaran);
                    arrDataPengguna.add(dataPengguna);
                    System.out.println(arrDataPengguna.size()+" ini total size array arrDataPengguna");
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
