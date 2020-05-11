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
import com.kelompok.sistempakar.models.Kelas_Login;

public class SignUpActivity extends AppCompatActivity {
    EditText usrname,pass;
    String username,password;
    Button signup,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        usrname = findViewById(R.id.etR_username);
        pass = findViewById(R.id.etR_password);
        signup = findViewById(R.id.btnS_signup);
        login = findViewById(R.id.btnS_login);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usrname.getText().toString();
                password = pass.getText().toString();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Data belum lengkap, Silihkan isi kembali", Toast.LENGTH_SHORT).show();
                    usrname.setText("");
                    pass.setText("");
                }else{
                    SQLiteHelper sqLiteHelper = new SQLiteHelper(SignUpActivity.this, null, null, 1);
                    Kelas_Login signup = new Kelas_Login(username, password);
                    sqLiteHelper.SignUp(signup);
                    usrname.setText("");
                    pass.setText("");
                    Toast.makeText(SignUpActivity.this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(login);
            }
        });
    }
}
