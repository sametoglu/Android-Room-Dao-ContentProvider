package com.example.samet.final2;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txt_adi,txt_soyadi;
    Spinner gunler;
    Button btn_kaydet,btn_provider_test;
    public static int id = 0;
    public static String gun = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        registeEventHandler();
    }





    private void registeEventHandler() {
        btn_kaydeton_Click();
        btn_provider_test_Click();
        spinnergun_OnitemSelect();
    }

    private void btn_provider_test_Click() {
        btn_provider_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues values = new ContentValues();
                values.put(StudentContentProvider.sc.FIRST_NAME,(txt_adi).getText().toString());

                values.put(StudentContentProvider.sc.LAST_NAME,(txt_soyadi).getText().toString());

                Uri uri = getContentResolver().insert(
                        StudentContentProvider.CONTENT_URI, values);

                Toast.makeText(getBaseContext(),uri.toString(), Toast.LENGTH_LONG).show();

                

                Intent i = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(i);
            }
        });
    }

    private void spinnergun_OnitemSelect() {
        gunler.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gun = gunler.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void btn_kaydeton_Click() {

        btn_kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id++;

                AppDatabase appDatabase = AppDatabase.getAppDatabase(MainActivity.this);

                Student student = new Student();
                student.setFirstname(txt_adi.getText().toString().trim().toLowerCase());
                student.setLastname(txt_soyadi.getText().toString().trim().toLowerCase());
                student.setGun(gun);
                student.setTerm(id);

                appDatabase.getStudentDAO().insertStudent(student);

                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });

    }


    private void initComponents() {
        txt_adi = findViewById(R.id.firstname);
        txt_soyadi = findViewById(R.id.lastname);
        gunler = findViewById(R.id.spinnergun);
        btn_kaydet = findViewById(R.id.btn_kaydet);
        btn_provider_test = findViewById(R.id.btn_provider_test);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.gunler,R.layout.layout_spinner);
        gunler.setAdapter(adapter);


    }
}
