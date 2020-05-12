package com.kelompok.sistempakar.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kelompok.sistempakar.R;

public class KeteranganPenyakitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keterangan_penyakit);

        String namaP = getIntent().getStringExtra("namaP");
        String penyebabP = getIntent().getStringExtra("penyebabP");
        String solusiP = getIntent().getStringExtra("solusiP");
        TextView namap = findViewById(R.id.tv_namaP);
        TextView penyebabp = findViewById(R.id.tv_penyebabP);
        TextView solusip = findViewById(R.id.tv_solusiP);

        namap.setText(namaP);
        penyebabp.setText(penyebabP);
        solusip.setText(solusiP);
    }
}
