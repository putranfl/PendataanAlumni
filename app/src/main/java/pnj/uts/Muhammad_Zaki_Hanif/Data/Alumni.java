package pnj.uts.Muhammad_Zaki_Hanif.Data;

import java.math.BigInteger;

public class Alumni {
    private String nama_alumni,tempat_lahir,tanggal_lahir,alamat,agama,pekerjaan,jabatan;
    private BigInteger nim,telp,tahun_masuk,tahun_lulus;

    public Alumni(String nama_alumni, String tempat_lahir, String tanggal_lahir, String alamat, String agama, String pekerjaan, String jabatan, BigInteger nim, BigInteger telp, BigInteger tahun_masuk, BigInteger tahun_lulus) {
        this.nama_alumni = nama_alumni;
        this.tempat_lahir = tempat_lahir;
        this.tanggal_lahir = tanggal_lahir;
        this.alamat = alamat;
        this.agama = agama;
        this.pekerjaan = pekerjaan;
        this.jabatan = jabatan;
        this.nim = nim;
        this.telp = telp;
        this.tahun_masuk = tahun_masuk;
        this.tahun_lulus = tahun_lulus;
    }

    public String getNama_alumni() {
        return nama_alumni;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getAgama() {
        return agama;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public BigInteger getNim() {
        return nim;
    }

    public BigInteger getTelp() {
        return telp;
    }

    public BigInteger getTahun_masuk() {
        return tahun_masuk;
    }

    public BigInteger getTahun_lulus() {
        return tahun_lulus;
    }
}
