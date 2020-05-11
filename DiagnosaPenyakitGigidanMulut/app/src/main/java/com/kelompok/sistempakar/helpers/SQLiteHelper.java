package com.kelompok.sistempakar.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;

import androidx.annotation.Nullable;

import com.kelompok.sistempakar.models.Kelas_Login;
import com.kelompok.sistempakar.models.Kelas_Penyakit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "db_sistempakar";

    // Table Names
    private static final String TABLE_LOGIN = "login";
    private static final String TABLE_PENYAKIT = "penyakit";

    // TABEL LOGIN - Column
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    private static final String KEY_PID = "pid";
    private static final String KEY_NAMA_PENYAKIT = "nama_penyakit";
    private static final String KEY_SOLUSI_PENYAKIT = "solusi_penyakit";

    // Table Create Statements
    // LOGIN table create statement
    private static final String CREATE_TABLE_LOGIN = "CREATE TABLE "
            + TABLE_LOGIN + "("
            + KEY_USERNAME + " TEXT NOT NULL PRIMARY KEY,"
            + KEY_PASSWORD + " TEXT NOT NULL"
            + ")";

    private static final String CREATE_TABLE_PENYAKIT = "CREATE TABLE "
            + TABLE_PENYAKIT + "("
            + KEY_PID + " TEXT NOT NULL PRIMARY KEY,"
            + KEY_NAMA_PENYAKIT + " TEXT NOT NULL,"
            + KEY_SOLUSI_PENYAKIT + " TEXT NOT NULL"
            + ")";



    public SQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_LOGIN);
        db.execSQL(CREATE_TABLE_PENYAKIT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PENYAKIT);

        // create new tables
        onCreate(db);
    }

    public ArrayList<HashMap<String, String>> getAllpenyakit(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> penyakitList = new ArrayList<>();
        String query = "SELECT * FROM "+ TABLE_PENYAKIT;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> penyakit = new HashMap<>();
            penyakit.put("pid",cursor.getString(cursor.getColumnIndex(KEY_PID)));
            penyakit.put("nama_penyakit",cursor.getString(cursor.getColumnIndex(KEY_NAMA_PENYAKIT)));
            penyakit.put("solusi_penyakit",cursor.getString(cursor.getColumnIndex(KEY_SOLUSI_PENYAKIT)));
            penyakitList.add(penyakit);
        }
        return  penyakitList;
    }

    public void SignUp(Kelas_Login signup) {
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, signup.getUsername());
        values.put(KEY_PASSWORD, signup.getPassword());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_LOGIN, null, values);
        db.close();
    }

    public Boolean checkUser(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from login where username =? and password =?",new String[]{username,password  });
        if(cursor.getCount()>0) {
            return true;
        }else {
            return false;
        }
    }

    public void addpenyakit(Kelas_Penyakit penyakit){
        ContentValues values = new ContentValues();
        values.put(KEY_PID, penyakit.getPid());
        values.put(KEY_NAMA_PENYAKIT, penyakit.getNama());
        values.put(KEY_SOLUSI_PENYAKIT, penyakit.getSolusi());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_PENYAKIT, null, values);
        db.close();
    }


}
