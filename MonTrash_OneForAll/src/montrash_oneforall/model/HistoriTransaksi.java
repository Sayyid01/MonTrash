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
    private int nomorUrut;
    private int id;
    private String tanggalTransaksi;
    private float jumlahBayar;    
    private int id_pengguna;
    private String statusPembayaran;

    public HistoriTransaksi(int nomorUrut, int id, String tanggalTransaksi, float jumlahBayar, int id_pengguna, String statusPembayaran) {
        this.nomorUrut=nomorUrut;
        this.id = id;
        this.tanggalTransaksi = tanggalTransaksi;
        this.jumlahBayar = jumlahBayar;
        this.id_pengguna=id_pengguna;
        this.statusPembayaran = statusPembayaran;
    }

    public int getNomorUrut() {
        return nomorUrut;
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

    public int getId_pengguna() {
        return id_pengguna;
    }

    public String getStatusPembayaran() {
        return statusPembayaran;
    }
}
