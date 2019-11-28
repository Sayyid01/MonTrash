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
public class DataPengguna {
    private String nama;
    private int id_pengguna;
    private int id_transaksi;
    private int status_angkut;
    private int status_pembayaran;

    public DataPengguna(String nama, int id_pengguna, int id_transaksi, int status_angkut, int status_pembayaran) {
        this.nama = nama;
        this.id_pengguna = id_pengguna;
        this.id_transaksi = id_transaksi;
        this.status_angkut = status_angkut;
        this.status_pembayaran = status_pembayaran;
    }

    public DataPengguna(String nama, int id_pengguna, int id_transaksi, int status_angkut) {
        this.nama = nama;
        this.id_pengguna = id_pengguna;
        this.id_transaksi = id_transaksi;
        this.status_angkut = status_angkut;
    }

    public DataPengguna(String nama, int id_pengguna, int id_transaksi) {
        this.nama = nama;
        this.id_pengguna = id_pengguna;
        this.id_transaksi = id_transaksi;
    }

    public DataPengguna(String nama, int id_pengguna) {
        this.nama = nama;
        this.id_pengguna = id_pengguna;
    }

    public DataPengguna(String nama) {
        this.nama = nama;
    }

    public DataPengguna() {
    }

    public String getNama() {
        return nama;
    }

    public int getId_pengguna() {
        return id_pengguna;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public int getStatus_angkut() {
        return status_angkut;
    }

    public int getStatus_pembayaran() {
        return status_pembayaran;
    }

    
}
