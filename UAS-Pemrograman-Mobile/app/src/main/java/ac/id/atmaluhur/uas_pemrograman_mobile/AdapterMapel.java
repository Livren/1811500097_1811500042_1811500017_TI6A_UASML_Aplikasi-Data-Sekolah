package ac.id.atmaluhur.uas_pemrograman_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterMapel extends RecyclerView.Adapter<AdapterMapel.MapelHolder> {
    private Context context;
    private List<MapelPost> listmapel;
    public AdapterMapel(Context context, List<MapelPost> listmapel){
        this.context  = context;
        this.listmapel = listmapel;
    }
    @NonNull
    @Override
    public AdapterMapel.MapelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_mapel, parent,false);
        AdapterMapel.MapelHolder holder = new AdapterMapel.MapelHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMapel.MapelHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(@NonNull  AdapterMapel.MapelHolder holder, int position, @NonNull  List<Object> payloads) {
        final MapelPost MPost = listmapel.get(position);
        String id_mapel = MPost.getId_mapel();
        String nama_mapel = MPost.getNama_mapel();
        String kelas = MPost.getKelas();

        holder.textId_mapel.setText("ID Mata Pelajaran        : " + id_mapel);
        holder.textNama_mapel.setText("Nama Mata Pelajaran : " + nama_mapel);
        holder.textKelas.setText("Kelas                               : " + kelas);
    }


    @Override
    public int getItemCount() {
        return listmapel.size();
    }

    public class MapelHolder extends RecyclerView.ViewHolder {

        TextView textId_mapel, textNama_mapel, textKelas;

        public MapelHolder(@NonNull View itemView) {
            super(itemView);

            textId_mapel = itemView.findViewById(R.id.text_idMapel);
            textNama_mapel = itemView.findViewById(R.id.text_nama_mapel);
            textKelas = itemView.findViewById(R.id.text_kelas);
        }
    }
}
