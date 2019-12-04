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
public class Transaksi {
    private int id;
    private String tanggal;
    private float jumlahBayar;
    int statusPembayaran;
    int idPengguna;

    public Transaksi(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    
}


