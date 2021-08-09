package ac.id.atmaluhur.uas_pemrograman_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class AdapterGuru extends RecyclerView.Adapter<AdapterGuru.GuruHolder> {
    private Context context;
    private List<GuruPost> listguru;
    public AdapterGuru(Context context, List<GuruPost> listguru){
        this.context  = context;
        this.listguru = listguru;
    }
    @NonNull
    @Override
    public AdapterGuru.GuruHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_guru, parent,false);
        GuruHolder holder = new GuruHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGuru.GuruHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(@NonNull  AdapterGuru.GuruHolder holder, int position, @NonNull  List<Object> payloads) {
        final GuruPost GPost = listguru.get(position);
        String nign = GPost.getNign();
        String nama_guru = GPost.getNama_guru();
        String alamat_guru = GPost.getAlamat_guru();

        holder.textNign.setText("NIGN              : " + nign);
        holder.textNama_guru.setText("Nama Guru    : " + nama_guru);
        holder.textAlamat_guru.setText("Alamat Guru  : " + alamat_guru);
    }


    @Override
    public int getItemCount() {
        return listguru.size();
    }

    public class GuruHolder extends RecyclerView.ViewHolder {

        TextView textNign, textNama_guru, textAlamat_guru;

        public GuruHolder(@NonNull View itemView) {
            super(itemView);

            textNign = itemView.findViewById(R.id.text_nign);
            textNama_guru = itemView.findViewById(R.id.text_nama_guru);
            textAlamat_guru = itemView.findViewById(R.id.text_alamat_guru);
        }
    }
}