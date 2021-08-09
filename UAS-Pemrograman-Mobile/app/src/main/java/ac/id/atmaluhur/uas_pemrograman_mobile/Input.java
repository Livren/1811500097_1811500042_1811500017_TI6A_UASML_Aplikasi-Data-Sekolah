package ac.id.atmaluhur.uas_pemrograman_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class Input extends AppCompatActivity implements View.OnClickListener {
    //Dibawah ini merupakan perintah untuk mendefinisikan View
    private EditText editTextNisn;
    private EditText editTextNamaSiswa;
    private EditText editTextAlamatSiswa;
    private EditText editTextNign;
    private EditText editTextNamaGuru;
    private EditText editTextAlamatGuru;
    private EditText editTextIdMapel;
    private EditText editTextNamaMapel;
    private EditText editTextKelas;

    private Button buttonAddSiswa;
    private Button buttonAddGuru;
    private Button buttonAddMapel;
    private Button buttonKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        //Inisialisasi dari View
        editTextNisn = (EditText) findViewById(R.id.editTextNisn);
        editTextNamaSiswa = (EditText) findViewById(R.id.editTextNamaSiswa);
        editTextAlamatSiswa = (EditText) findViewById(R.id.editTextAlamatSiswa);
        editTextNign = (EditText) findViewById(R.id.editTextNign);
        editTextNamaGuru = (EditText) findViewById(R.id.editTextNamaGuru);
        editTextAlamatGuru = (EditText) findViewById(R.id.editTextAlamatGuru);
        editTextIdMapel = (EditText) findViewById(R.id.editTextIdMapel);
        editTextNamaMapel = (EditText) findViewById(R.id.editTextNamaMapel);
        editTextKelas = (EditText) findViewById(R.id.editTextKelas);


        buttonAddSiswa = (Button) findViewById(R.id.buttonAddSiswa);
        buttonAddGuru = (Button) findViewById(R.id.buttonAddGuru);
        buttonAddMapel = (Button) findViewById(R.id.buttonAddMapel);
        buttonKembali = (Button) findViewById(R.id.buttonKembali);

        //Setting listeners to button
        buttonAddSiswa.setOnClickListener(this);
        buttonAddGuru.setOnClickListener(this);
        buttonAddMapel.setOnClickListener(this);
        buttonKembali.setOnClickListener(this);
    }


    //Dibawah ini merupakan perintah untuk Menambahkan(CREATE)
    private void addEmployee(){

        final String nisn = editTextNisn.getText().toString().trim();
        final String namaSiswa = editTextNamaSiswa.getText().toString().trim();
        final String alamatSiswa = editTextAlamatSiswa.getText().toString().trim();
        final String nign = editTextNign.getText().toString().trim();
        final String namaGuru = editTextNamaGuru.getText().toString().trim();
        final String alamatGuru = editTextAlamatGuru.getText().toString().trim();
        final String idMapel = editTextIdMapel.getText().toString().trim();
        final String namaMapel = editTextNamaMapel.getText().toString().trim();
        final String kelas = editTextKelas.getText().toString().trim();

        class AddEmployee extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Input.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Input.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Konfigurasi.KEY_EMP_NISN,nisn);
                params.put(Konfigurasi.KEY_EMP_NAMASISWA,namaSiswa);
                params.put(Konfigurasi.KEY_EMP_ALAMATSISWA,alamatSiswa);
                params.put(Konfigurasi.KEY_EMP_NIGN,nign);
                params.put(Konfigurasi.KEY_EMP_NAMAGURU,namaGuru);
                params.put(Konfigurasi.KEY_EMP_ALAMATGURU,alamatGuru);
                params.put(Konfigurasi.KEY_EMP_IDMAPEL,idMapel);
                params.put(Konfigurasi.KEY_EMP_NAMAMAPEL,namaMapel);
                params.put(Konfigurasi.KEY_EMP_KELAS,kelas);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Konfigurasi.URL_ADD, params);
                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonAddSiswa){
            addEmployee();
            reset();
        }

        if(v == buttonAddGuru){
            addEmployee();
            reset();
        }

        if(v == buttonAddMapel){
            addEmployee();
            reset();
        }
        if(v == buttonKembali){
            Intent i = new Intent(Input.this, MainActivity.class);
            startActivity(i);
        }
    }

    public void reset(){
        editTextNisn.setText("");
        editTextNamaSiswa.setText("");
        editTextAlamatSiswa.setText("");
        editTextNign.setText("");
        editTextNamaGuru.setText("");
        editTextAlamatGuru.setText("");
        editTextIdMapel.setText("");
        editTextNamaMapel.setText("");
        editTextKelas.setText("");
    }
}