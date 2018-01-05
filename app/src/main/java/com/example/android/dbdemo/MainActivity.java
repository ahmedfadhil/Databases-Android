package com.example.android.dbdemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        try {
//            SQLiteDatabase eventDB = this.openOrCreateDatabase("Events", MODE_PRIVATE, null);
//            eventDB.execSQL("CREATE TABLE IF NOT EXISTS events(eventname VARCHAR, year INT(4))");
//            eventDB.execSQL("INSERT INTO events(eventname, year) VALUES('End of WW2',1945)");
//            eventDB.execSQL("INSERT INTO events(eventname, year) VALUES('Begining of Gulf war',1990)");
//
//            Cursor cursor = eventDB.rawQuery("SELECT * FROM events", null);
//            int eventnameIndex = cursor.getColumnIndex("eventname");
//            int yearIndex = cursor.getColumnIndex("year");
//
//            cursor.moveToFirst();
//            while (cursor != null) {
//                Log.i("Event Name", cursor.getString(eventnameIndex));
//                Log.i("Event Name", String.valueOf(cursor.getInt(yearIndex)));
//                cursor.moveToNext();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        try {
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR, age INT(3))");
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS newusers(name VARCHAR, age INT(3), id INTEGER PRIMARY KEY)");
            myDatabase.execSQL("INSERT INTO users(name, age) VALUES ('James', 23)");
            myDatabase.execSQL("INSERT INTO users(name, age) VALUES ('Walter', 25)");
            myDatabase.execSQL("INSERT INTO users(name, age) VALUES ('Bet', 45)");
            myDatabase.execSQL("INSERT INTO users(name, age) VALUES ('ww', 90)");
            myDatabase.execSQL("INSERT INTO users(name, age) VALUES ('eet', 4)");
            myDatabase.execSQL("INSERT INTO users(name, age) VALUES ('reret', 35)");
            myDatabase.execSQL("INSERT INTO users(name, age) VALUES ('Berr', 55)");
            myDatabase.execSQL("INSERT INTO users(name, age) VALUES ('Btr', 65)");
            myDatabase.execSQL("INSERT INTO users(name, age) VALUES ('ad', 75)");
            myDatabase.execSQL("INSERT INTO users(name, age) VALUES ('ds', 85)");
            myDatabase.execSQL("INSERT INTO users(name, age) VALUES ('sddd', 95)");
            myDatabase.execSQL("INSERT INTO users(name, age) VALUES ('Beereret', 15)");
            myDatabase.execSQL("INSERT INTO users(name, age) VALUES ('addd', 25)");

            myDatabase.execSQL("INSERT INTO newusers(name, age) VALUES ('Beereret', 15)");
            myDatabase.execSQL("INSERT INTO newusers(name, age) VALUES ('addd', 25)");
            myDatabase.execSQL("DELETE FROM newusers WHERE id=1gi");
//            myDatabase.execSQL("UPDATE users SET age = 23 WHERE name = 'sddd'");
            Cursor cursor = myDatabase.rawQuery("SELECT * FROM newusers", null);
            int nameIndex = cursor.getColumnIndex("name");
            int ageIndex = cursor.getColumnIndex("age");
            int idIndex = cursor.getColumnIndex("id");
            cursor.moveToFirst();
            while (cursor != null) {
                Log.i("Name", cursor.getString(nameIndex));
                Log.i("Age", String.valueOf(cursor.getInt(ageIndex)));
                Log.i("Primary key", String.valueOf(cursor.getInt(idIndex)));
                cursor.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
