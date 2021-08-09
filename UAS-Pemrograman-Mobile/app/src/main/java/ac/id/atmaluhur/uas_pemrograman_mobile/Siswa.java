package ac.id.atmaluhur.uas_pemrograman_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Siswa extends AppCompatActivity{
    private SiswaJsonPlaceHolderApi jsonPlaceHolderApi;
    RecyclerView recyclerView;
    AdapterSiswa adapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siswa);

        recyclerView = findViewById(R.id.recycleview_siswa);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.213/API_UAS-PEMROGRAMAN-MOBILE/restApiSiswa.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(SiswaJsonPlaceHolderApi.class);
        getDataSiswa();

    }

    private void getDataSiswa() {
        Map<String, String> parameters = new HashMap<>();
        Call<List<SiswaPost>> call = jsonPlaceHolderApi.getSiswa();
        call.enqueue(new Callback<List<SiswaPost>>() {
            @Override
            public void onResponse(Call<List<SiswaPost>> call, Response<List<SiswaPost>> response) {
                List<SiswaPost> post = response.body();
                adapter = new AdapterSiswa(Siswa.this, post);
                recyclerView.setAdapter(adapter);

                return;
            }

            @Override
            public void onFailure(Call<List<SiswaPost>> call, Throwable t) {

            }
        });
    }


    public void kembali(View v){
        Intent i = new Intent(Siswa.this, MainActivity.class);
        startActivity(i);
    }
}
