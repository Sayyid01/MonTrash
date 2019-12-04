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
    private String email;
    private String noHp;
    private String alamat;
    private String keterangan;
    private String statusPengguna;
    private int id_transaksi;
    private int id_pengangkutan;
    private int realIdTransaksi;
    private int status_angkut;
    private int status_pembayaran;

    public Status(String nama, String email, String noHp, String alamat, String keterangan, String statusPengguna, int id_transaksi, int id_pengangkutan, int realIdTransaksi, int status_angkut, int status_pembayaran) {
        this.nama = nama;
        this.email = email;
        this.noHp = noHp;
        this.alamat = alamat;
        this.keterangan = keterangan;
        this.statusPengguna = statusPengguna;
        this.id_transaksi = id_transaksi;
        this.id_pengangkutan = id_pengangkutan;
        this.realIdTransaksi = realIdTransaksi;
        this.status_angkut = status_angkut;
        this.status_pembayaran = status_pembayaran;
    }
    

    public Status(String nama, String statusPengguna, int id_transaksi, int id_pengangkutan, int realIdTransaksi, int status_angkut, String keterangan, int status_pembayaran) {
        this.nama = nama;
        this.statusPengguna = statusPengguna;
        this.id_transaksi = id_transaksi;
        this.id_pengangkutan = id_pengangkutan;
        this.realIdTransaksi = realIdTransaksi;
        this.status_angkut = status_angkut;
        this.keterangan = keterangan;
        this.status_pembayaran = status_pembayaran;
    }
    

    public Status(String nama, String statusPengguna, int id_transaksi, int id_pengangkutan, int status_angkut, String keterangan, int status_pembayaran) {
        this.nama = nama;
        this.statusPengguna = statusPengguna;
        this.id_transaksi = id_transaksi;
        this.id_pengangkutan = id_pengangkutan;
        this.status_angkut = status_angkut;
        this.keterangan = keterangan;
        this.status_pembayaran = status_pembayaran;
    }

    
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

    public String getEmail() {
        return email;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getStatusPengguna() {
        return statusPengguna;
    }

    public int getRealIdTransaksi() {
        return realIdTransaksi;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public int getId_pengangkutan() {
        return id_pengangkutan;
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
