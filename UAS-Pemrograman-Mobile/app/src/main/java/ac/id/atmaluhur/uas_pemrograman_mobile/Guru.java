package ac.id.atmaluhur.uas_pemrograman_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Guru extends AppCompatActivity {
    private GuruJsonPlaceHolderApi jsonPlaceHolderApi;
    RecyclerView recyclerView;
    AdapterGuru adapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guru);

        recyclerView = findViewById(R.id.recycleview_guru);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.213/API_UAS-PEMROGRAMAN-MOBILE/restApiGuru.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(GuruJsonPlaceHolderApi.class);
        getDataGuru();

    }

    private void getDataGuru() {
        Map<String, String> parameters = new HashMap<>();
        Call<List<GuruPost>> call = jsonPlaceHolderApi.getGuru();
        call.enqueue(new Callback<List<GuruPost>>() {
            @Override
            public void onResponse(Call<List<GuruPost>> call, Response<List<GuruPost>> response) {
                List<GuruPost> posts = response.body();
                adapter = new AdapterGuru(Guru.this, posts);
                recyclerView.setAdapter(adapter);

                return;
            }

            @Override
            public void onFailure(Call<List<GuruPost>> call, Throwable t) {

            }
        });
    }


    public void kembali(View v){
        Intent i = new Intent(Guru.this, MainActivity.class);
        startActivity(i);
    }
}
