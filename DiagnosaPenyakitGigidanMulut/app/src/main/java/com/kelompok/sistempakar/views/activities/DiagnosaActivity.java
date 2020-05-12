package com.kelompok.sistempakar.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.kelompok.sistempakar.R;

import java.security.SecureRandom;
import java.util.ArrayList;

public class DiagnosaActivity extends AppCompatActivity {
    String cb1,cb2,cb3;
    CheckBox cb_1,cb_2,cb_3;
    Button hasil;
    TextView hasil1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosa);



    }

}
