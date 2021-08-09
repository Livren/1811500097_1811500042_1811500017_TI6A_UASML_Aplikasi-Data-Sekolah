package ac.id.atmaluhur.uas_pemrograman_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Mapel extends AppCompatActivity {
    private MapelJsonPlaceHolderApi jsonPlaceHolderApi;
    RecyclerView recyclerView;
    AdapterMapel adapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapel);

        recyclerView = findViewById(R.id.recycleview_mapel);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.213/API_UAS-PEMROGRAMAN-MOBILE/restApiMapel.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(MapelJsonPlaceHolderApi.class);
        getDataMapel();

    }

    private void getDataMapel() {
        Map<String, String> parameters = new HashMap<>();
        Call<List<MapelPost>> call = jsonPlaceHolderApi.getMapel();
        call.enqueue(new Callback<List<MapelPost>>() {
            @Override
            public void onResponse(Call<List<MapelPost>> call, Response<List<MapelPost>> response) {
                List<MapelPost> post = response.body();
                adapter = new AdapterMapel(Mapel.this, post);
                recyclerView.setAdapter(adapter);

                return;
            }

            @Override
            public void onFailure(Call<List<MapelPost>> call, Throwable t) {

            }
        });
    }


    public void kembali(View v){
        Intent i = new Intent(Mapel.this, MainActivity.class);
        startActivity(i);
    }
}