package com.example.samet.final2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ListView liststudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initComponents();
        bindData();
        registeEventHandler();
    }

    private void registeEventHandler() {
        listisletimsistemi_onItemClick();
    }

    private void listisletimsistemi_onItemClick() {

        liststudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Student student = (Student) liststudent.getItemAtPosition(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);

                builder.setTitle("Ogrenci sil");
                builder.setIcon(android.R.drawable.ic_dialog_info);

                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        AppDatabase appDatabase = AppDatabase.getAppDatabase(Main2Activity.this);

                        appDatabase.getStudentDAO().deleteStudent(student);

                        bindListIslitimSistemiData();

                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    private void bindData() {
        bindListIslitimSistemiData();
    }

    private void bindListIslitimSistemiData() {

        AppDatabase appDatabase = AppDatabase.getAppDatabase(Main2Activity.this);

        List<Student> students = appDatabase.getStudentDAO().loadAllStudents();

        IsletimSistemiAdapter ısletimSistemiAdapter = new IsletimSistemiAdapter(this,students);
        liststudent.setAdapter(ısletimSistemiAdapter);

    }

    private void initComponents() {
        liststudent = findViewById(R.id.list);

    }
}
