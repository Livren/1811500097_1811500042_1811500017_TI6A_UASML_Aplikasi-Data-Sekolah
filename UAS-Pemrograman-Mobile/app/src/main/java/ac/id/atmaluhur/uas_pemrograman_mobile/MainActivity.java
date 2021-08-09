package ac.id.atmaluhur.uas_pemrograman_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void input(View v){
        Intent i = new Intent(MainActivity.this, Input.class);
        startActivity(i);
    }
    public void siswa(View v){
        Intent i = new Intent(MainActivity.this, Siswa.class);
        startActivity(i);
    }
    public void mapel(View v){
        Intent i = new Intent(MainActivity.this, Mapel.class);
        startActivity(i);
    }
    public void guru(View v){
        Intent i = new Intent(MainActivity.this, Guru.class);
        startActivity(i);
    }
}