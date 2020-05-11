package com.kelompok.sistempakar.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kelompok.sistempakar.R;
import com.kelompok.sistempakar.helpers.SQLiteHelper;
import com.kelompok.sistempakar.models.Kelas_Penyakit;

public class TambahPenyakitActivity extends AppCompatActivity {
    String pidP,namaP,solusiP;
    EditText pid,nama,solusi;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_penyakit);

        pid = findViewById(R.id.et_PID);
        nama = findViewById(R.id.et_namaPenyakit);
        solusi = findViewById(R.id.et_solusiPenyakit);

        save = findViewById(R.id.btn_save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pidP = pid.getText().toString();
                namaP = nama.getText().toString();
                solusiP = solusi.getText().toString();

                if (pidP.isEmpty() || namaP.isEmpty() || solusiP.isEmpty()) {
                    Toast.makeText(TambahPenyakitActivity.this, "Data belum lengkap, Silihkan isi kembali", Toast.LENGTH_SHORT).show();
                    pid.setText("");
                    nama.setText("");
                    solusi.setText("");
                }else{
                    SQLiteHelper sqLiteHelper = new SQLiteHelper(TambahPenyakitActivity.this, null, null, 1);
                    Kelas_Penyakit penyakit = new Kelas_Penyakit(pidP,namaP,solusiP);
                    sqLiteHelper.addpenyakit(penyakit);
                    pid.setText("");
                    nama.setText("");
                    solusi.setText("");
                    Toast.makeText(TambahPenyakitActivity.this, "Data Pelanggan Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
