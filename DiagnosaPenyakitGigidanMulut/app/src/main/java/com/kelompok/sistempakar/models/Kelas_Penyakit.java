package com.kelompok.sistempakar.models;

public class Kelas_Penyakit {
    String pid,nama,penyebab,solusi;

    public Kelas_Penyakit() {

    }
    public Kelas_Penyakit(String pid, String nama, String penyebab, String solusi) {
        this.pid = pid;
        this.nama = nama;
        this.penyebab = penyebab;
        this.solusi = solusi;
    }


    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPenyebab() { return penyebab; }

    public void setPenyebab(String penyebab) { this.penyebab = penyebab; }

    public String getSolusi() {
        return solusi;
    }

    public void setSolusi(String solusi) {
        this.solusi = solusi;
    }
}
