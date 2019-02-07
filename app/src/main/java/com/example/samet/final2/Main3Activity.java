package com.example.samet.final2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private ListView liststudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initComponents();
        bindData();
    }


    private void bindData() {
        bindListIslitimSistemiData();
    }

    private void bindListIslitimSistemiData() {

        String URL = "content://com.example.samet.final2.StudentContentProvider";

        Uri student = Uri.parse(URL);
        Cursor c = managedQuery(student, null, null, null, null);

        if (c.moveToFirst()) {
            do{
                Toast.makeText(Main3Activity.this,
                        c.getString(c.getColumnIndex(StudentContentProvider.sc._ID)) +
                                ", " +  c.getString(c.getColumnIndex( StudentContentProvider.sc.FIRST_NAME)) +
                                ", " + c.getString(c.getColumnIndex( StudentContentProvider.sc.LAST_NAME)),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
    }


    private void initComponents() {
        liststudent = findViewById(R.id.list);

    }
}
