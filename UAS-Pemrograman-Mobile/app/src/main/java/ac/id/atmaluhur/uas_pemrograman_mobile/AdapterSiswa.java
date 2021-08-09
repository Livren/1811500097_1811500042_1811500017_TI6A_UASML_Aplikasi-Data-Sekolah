package ac.id.atmaluhur.uas_pemrograman_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterSiswa extends RecyclerView.Adapter<AdapterSiswa.SiswaHolder> {
    private Context context;
    private List<SiswaPost> listsiswa;
    public AdapterSiswa(Context context, List<SiswaPost> listsiswa){
        this.context  = context;
        this.listsiswa = listsiswa;
    }
    @NonNull
    @Override
    public AdapterSiswa.SiswaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_siswa, parent,false);
        AdapterSiswa.SiswaHolder holder = new AdapterSiswa.SiswaHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSiswa.SiswaHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(@NonNull  AdapterSiswa.SiswaHolder holder, int position, @NonNull  List<Object> payloads) {
        final SiswaPost SPost = listsiswa.get(position);
        String nisn = SPost.getNisn();
        String nama_siswa = SPost.getNama_siswa();
        String alamat_siswa = SPost.getAlamat_siswa();

        holder.textNisn.setText("NISN                 : " + nisn);
        holder.textNama_siswa.setText("Nama Siswa    : " + nama_siswa);
        holder.textAlamat_siswa.setText("Alamat Siswa  : " + alamat_siswa);
    }


    @Override
    public int getItemCount() {
        return listsiswa.size();
    }

    public class SiswaHolder extends RecyclerView.ViewHolder {

        TextView textNisn, textNama_siswa, textAlamat_siswa;

        public SiswaHolder(@NonNull View itemView) {
            super(itemView);

            textNisn = itemView.findViewById(R.id.text_nisn);
            textNama_siswa = itemView.findViewById(R.id.text_nama_siswa);
            textAlamat_siswa = itemView.findViewById(R.id.text_alamat_siswa);
        }
    }
}
