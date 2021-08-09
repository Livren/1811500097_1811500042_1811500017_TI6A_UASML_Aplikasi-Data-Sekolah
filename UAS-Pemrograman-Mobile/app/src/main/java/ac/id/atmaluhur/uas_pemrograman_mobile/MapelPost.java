package ac.id.atmaluhur.uas_pemrograman_mobile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MapelPost {
    @SerializedName("id_mapel")
    @Expose
    private String id_mapel;
    @SerializedName("nama_mapel")
    @Expose
    private String nama_mapel;
    @SerializedName("kelas")
    @Expose
    private String kelas;

    public String getId_mapel(){
        return id_mapel;
    }

    public void setId_mapel(String id_mapel){
        this.id_mapel = id_mapel;
    }

    public String getNama_mapel(){
        return nama_mapel;
    }

    public void setNama_mapel(String nama_mapel){
        this.nama_mapel = nama_mapel;
    }

    public String getKelas(){
        return kelas;
    }

    public void setKelas(String kelas){
        this.kelas = kelas;
    }
}
