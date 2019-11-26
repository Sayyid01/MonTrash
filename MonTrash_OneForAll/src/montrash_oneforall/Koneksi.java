/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montrash_oneforall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sayyid
 */
public class Koneksi {
    public static Connection conn;
    public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_NAME = "montrash_db";
    public static final String DB_URL = "jdbc:mysql://localhost"+DB_NAME;
    public static final String DB_UNAME = "sayyid";
    public static final String DB_PASSWD="";
    
    public static Connection bukaKoneksi(){
        if(conn == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(DB_NAME, DB_UNAME, DB_PASSWD);
                System.out.println("Koneksi Berhasil");
            }catch(ClassNotFoundException | SQLException e){
                System.out.println("Koneksi Gagal");
                System.err.println(e.getMessage());
            }
        }
        return conn;
    }
}
