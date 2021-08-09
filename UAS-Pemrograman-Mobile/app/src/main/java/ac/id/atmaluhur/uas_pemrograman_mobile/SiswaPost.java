package ac.id.atmaluhur.uas_pemrograman_mobile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SiswaPost {
    @SerializedName("nisn")
    @Expose
    private String nisn;
    @SerializedName("nama_siswa")
    @Expose
    private String nama_siswa;
    @SerializedName("alamat_siswa")
    @Expose
    private String alamat_siswa;

    public String getNisn(){
        return nisn;
    }

    public void setNisn(String nisn){
        this.nisn = nisn;
    }

    public String getNama_siswa(){
        return nama_siswa;
    }

    public void setNama_siswa(String nama_siswa){
        this.nama_siswa = nama_siswa;
    }

    public String getAlamat_siswa(){
        return alamat_siswa;
    }

    public void setAlamat_siswa(String alamat_siswa){
        this.alamat_siswa = alamat_siswa;
    }
}
