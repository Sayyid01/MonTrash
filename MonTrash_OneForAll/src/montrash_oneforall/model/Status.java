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
public class Status {
    private String nama;
    private String statusPengguna;
    private int id_transaksi;
    private int status_angkut;
    private String keterangan;
    private int status_pembayaran;

    public Status(String nama, String statusPengguna, int id_transaksi, int status_angkut, String keterangan, int status_pembayaran) {
        this.nama = nama;
        this.statusPengguna = statusPengguna;
        this.id_transaksi = id_transaksi;
        this.status_angkut = status_angkut;
        this.keterangan = keterangan;
        this.status_pembayaran = status_pembayaran;
    }

    public Status() {
    }

    public String getNama() {
        return nama;
    }

    public String getStatusPengguna() {
        return statusPengguna;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public int getStatus_angkut() {
        return status_angkut;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public int getStatus_pembayaran() {
        return status_pembayaran;
    }

    
}
