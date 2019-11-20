/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montrash_user;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
/**
 *
 * @author Sayyid
 */
public class Koneksi {
    private static Connection conn;
    private static final String DB_DRIVER ="com.mysql.jdbc.driver";
    private static final String DB_NAME ="montrash_db";
    private static final String DB_URL ="jdbc:mysql://localhost/"+DB_NAME;
    private static final String DB_UNAME ="sayyid";
    private static final String DB_PASSWD ="";
    
    public static Connection openConnection(){
        if(conn==null){
            try{
                Class.forName(DB_DRIVER);
                conn = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASSWD);
                System.out.println("Koneksi berhasil");
            }catch(ClassNotFoundException | SQLException e){
                System.err.println(e.getMessage()+"Koneksi gagal");
            }
        }
        return conn;
    }
}
