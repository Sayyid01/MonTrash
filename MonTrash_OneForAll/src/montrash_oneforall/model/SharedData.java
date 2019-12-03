/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montrash_oneforall.model;

/**
 *
 * @author Sayyid
 */
public class SharedData {
    public  static int id_pengguna;
    public static int id_transaksi;
    public static String level;

    public static void setId_pengguna(int id_pengguna) {
       SharedData.id_pengguna = id_pengguna;       
    }
    
    public static void setId_transaksi(int id_transaksi){
        SharedData.id_transaksi = id_transaksi;
    }
    
    public static void setLevel(String level){
        SharedData.level = level;
    }

    public static int getId_pengguna() {
        System.out.println(id_pengguna+" in Shared Data");
       return id_pengguna;
    }
    
    public static int getId_transaksi(){
        System.out.println(id_transaksi+" in Shared Data");
        return id_transaksi;
    }
    
    public static String getLevel(){
        System.out.println(level+" in Shared Data");
        return level;
    }
}
