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
public class HistoriPengangkutan {
    private int id;
    private String tanggalAngkut;
    private String statusAngkut;
    private String keterangan;

    public HistoriPengangkutan(int id, String tanggalAngkut, String statusAngkut, String keterangan) {
        this.id = id;
        this.tanggalAngkut = tanggalAngkut;
        this.statusAngkut = statusAngkut;
        this.keterangan = keterangan;
    }

    public int getId() {
        return id;
    }

    public String getTanggalAngkut() {
        return tanggalAngkut;
    }

    public String getStatusAngkut() {
        return statusAngkut;
    }

    public String getKeterangan() {
        return keterangan;
    }
}
