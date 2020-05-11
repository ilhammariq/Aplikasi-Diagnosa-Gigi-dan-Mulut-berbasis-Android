package com.kelompok.sistempakar.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.kelompok.sistempakar.R;
import com.kelompok.sistempakar.helpers.SQLiteHelper;
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
                new String[]{"nama_penyakit", "solusi_penyakit"},
                new int[]{R.id.txtNamaPenyakit, R.id.txtSolusiPenyakit});
        lv.setAdapter(adapter);
    }
}
