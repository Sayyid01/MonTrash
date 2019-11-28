/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montrash_oneforall.controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sayyid
 */
public class Koneksi {
    private static Connection conn;
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_NAME = "montrash_db";
    private static final String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;
    private static final String DB_UNAME = "sayyid";
    private static final String DB_PASSWD="";
    
    public static Connection bukaKoneksi(){
        if(conn == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASSWD);
                System.out.println("Koneksi Berhasil");
            }catch(ClassNotFoundException | SQLException e){
                System.out.println("Koneksi Gagal");
                System.err.println(e.getMessage());
            }
        }
        return conn;
    }
}
