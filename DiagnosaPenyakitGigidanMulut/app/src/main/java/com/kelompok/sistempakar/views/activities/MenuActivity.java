package com.kelompok.sistempakar.views.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kelompok.sistempakar.R;

public class MenuActivity extends AppCompatActivity {
    Button diagnosa,detail,tentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        diagnosa = findViewById(R.id.btn_diagnosa);
        detail = findViewById(R.id.btn_detail);
        tentang = findViewById(R.id.btn_tentang);

        diagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diagnosa = new Intent(MenuActivity.this, DiagnosaActivity.class);
                startActivity(diagnosa);
            }
        });

        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(MenuActivity.this, DetailPenyakitActivity.class);
                startActivity(detail);
            }
        });

        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tentang = new Intent(MenuActivity.this, TentangActivity.class);
                startActivity(tentang);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId()==R.id.detailPenyakit){
            startActivity(new Intent(this, TambahPenyakitActivity.class));
            Toast.makeText(this, "Anda Berada Pada Tambah Penyakit Activity",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
