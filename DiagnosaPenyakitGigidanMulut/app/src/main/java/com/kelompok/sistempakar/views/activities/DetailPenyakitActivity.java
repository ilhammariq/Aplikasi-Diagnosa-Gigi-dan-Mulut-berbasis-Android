package com.kelompok.sistempakar.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.kelompok.sistempakar.R;
import com.kelompok.sistempakar.helpers.SQLiteHelper;
import com.kelompok.sistempakar.models.Kelas_Penyakit;
import com.kelompok.sistempakar.views.adapters.PenyakitItemAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class DetailPenyakitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penyakit);

        SQLiteHelper db = new SQLiteHelper(this, null, null, 1);
        ArrayList<HashMap<String, String>> penyakitList = db.getAllpenyakit();
        ListView lv = findViewById(R.id.listNamaPenyakit);
        ListAdapter adapter = new SimpleAdapter(DetailPenyakitActivity.this, penyakitList, R.layout.nama_penyakit,
                new String[]{"nama_penyakit","nama_penyakit","solusi_penyakit"},
                new int[]{R.id.txtNamaPenyakit,R.id.txtPenyebabPenyakit,R.id.txtSolusiPenyakit});
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView nama_p = view.findViewById(R.id.txtNamaPenyakit);
                TextView penyebab_p = view.findViewById(R.id.txtPenyebabPenyakit);
                TextView solusi_p = view.findViewById(R.id.txtSolusiPenyakit);
                String namaP =  nama_p.getText().toString();
                String penyebabP =  penyebab_p.getText().toString();
                String solusiP =  solusi_p.getText().toString();
                Intent penyakit = new Intent(DetailPenyakitActivity.this, KeteranganPenyakitActivity.class);
                penyakit.putExtra("namaP",namaP);
                penyakit.putExtra("penyebabP",penyebabP);
                penyakit.putExtra("solusiP",solusiP);
                startActivity(penyakit);
            }
        });
    }
}
