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

public class LoginActivity extends AppCompatActivity {
    EditText usrname,pass;
    String username,password;
    Button login,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usrname = findViewById(R.id.etL_username);
        pass = findViewById(R.id.etL_password);

        login = findViewById(R.id.btnL_login);
        signup = findViewById(R.id.btnL_signup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteHelper sqLiteHelper = new SQLiteHelper(LoginActivity.this, null, null, 1);
                username = usrname.getText().toString();
                password = pass.getText().toString();
                Boolean ceklogin = sqLiteHelper.checkUser(username,password);
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Masukan Username Password ", Toast.LENGTH_SHORT).show();
                } else {
                    if(ceklogin == true && username.equals("admin")){
                        Toast.makeText(LoginActivity.this, "Login Berhasil ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                        startActivity(intent);
                    }else if(ceklogin == true){
                        Toast.makeText(LoginActivity.this, "Login Berhasil ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Username atau Password Salah ", Toast.LENGTH_SHORT).show();
                        usrname.setText("");
                        pass.setText("");
                    }
                }
            }
        });

            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent signup = new Intent(LoginActivity.this, SignUpActivity.class);
                    startActivity(signup);
                }
            });
    }
}
