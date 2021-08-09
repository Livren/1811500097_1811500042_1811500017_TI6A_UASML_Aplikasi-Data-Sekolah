package ac.id.atmaluhur.uas_pemrograman_mobile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuruPost {
    @SerializedName("nign")
    @Expose
    private String nign;

    @SerializedName("nama_guru")
    @Expose
    private String nama_guru;

    @SerializedName("alamat_guru")
    @Expose
    private String alamat_guru;

    public String getNign() {
        return nign;
    }

    public void setNign(String nign) {
        this.nign = nign;
    }

    public String getNama_guru() {
        return nama_guru;
    }

    public void setNama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    public String getAlamat_guru() {
        return alamat_guru;
    }

    public void setAlamat_guru(String alamat_guru) {
        this.alamat_guru = alamat_guru;
    }

}
