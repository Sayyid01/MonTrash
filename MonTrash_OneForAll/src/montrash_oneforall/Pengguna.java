/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montrash_oneforall;

/**
 *
 * @author Sayyid
 */
public class Pengguna {
    private String nama;
    private int status_sampah;
    private int status_pembayaran;

    public Pengguna(String nama, int status_sampah, int status_pembayaran) {
        this.nama = nama;
        this.status_sampah = status_sampah;
        this.status_pembayaran = status_pembayaran;
    }
    
    public Pengguna(int status_sampah, int status_pembayaran) {
        this.status_sampah = status_sampah;
        this.status_pembayaran = status_pembayaran;
    }
    
    public Pengguna(){}

    public String getNama() {
        return nama;
    }

    public int isStatus_sampah() {
        return status_sampah;
    }

    public int isStatus_pembayaran() {
        return status_pembayaran;
    }
    
    
    
}
