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
public class HistoriTransaksi {
    private int id;
    private String tanggalTransaksi;
    private float jumlahBayar;
    private String statusPembayaran;

    public HistoriTransaksi(int id, String tanggalTransaksi, float jumlahBayar, String statusPembayaran) {
        this.id = id;
        this.tanggalTransaksi = tanggalTransaksi;
        this.jumlahBayar = jumlahBayar;
        this.statusPembayaran = statusPembayaran;
    }

    public int getId() {
        return id;
    }

    public String getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public float getJumlahBayar() {
        return jumlahBayar;
    }

    public String getStatusPembayaran() {
        return statusPembayaran;
    }
}
