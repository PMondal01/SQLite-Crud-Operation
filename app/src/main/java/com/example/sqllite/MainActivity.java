package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase sqLiteDatabase=this.openOrCreateDatabase("Users",MODE_PRIVATE,null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS  users(name VARCHAR,age INT(3))");

        //sqLiteDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Nick',24)");
        //sqLiteDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Niloy',27)");

        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM users",null);

        int nameIndex= cursor.getColumnIndex("name");
        int ageIndex= cursor.getColumnIndex("age");

        cursor.moveToFirst();

        while (cursor!=null)
        {
            Log.i("name", cursor.getString(nameIndex));
            Log.i("age", cursor.getString(ageIndex));

            cursor.moveToNext();


        }


    }
}
