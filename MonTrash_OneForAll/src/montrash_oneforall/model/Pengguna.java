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
public class Pengguna {
    private int idPengguna;
    String nama;
    String alamat;
    String email;
    String noHp;
    String status;

    public Pengguna(int idPengguna, String nama, String alamat, String email, String noHp, String status) {
        this.idPengguna = idPengguna;
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.noHp = noHp;
        this.status = status;
    }

    public int getIdPengguna() {
        return idPengguna;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getEmail() {
        return email;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getStatus() {
        return status;
    }
    
    
}
