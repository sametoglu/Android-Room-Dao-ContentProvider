package com.example.samet.final2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samet on 27.05.2018.
 */

public class IsletimSistemiAdapter extends BaseAdapter {

    private Context context;
    private List<Student> liststudents;


    public IsletimSistemiAdapter(Context context,List<Student> liststudents){
        this.context = context;
        this.liststudents = liststudents;
    }

    @Override
    public int getCount() {
        return liststudents.size();
    }

    @Override
    public Object getItem(int position) {
        return liststudents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Student student = (Student) getItem(position);

        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        LinearLayout layout = (LinearLayout)layoutInflater.inflate(R.layout.element,null);

        TextView lbladi = layout.findViewById(R.id.txt_adi);
        lbladi.setText(student.getFirstname());
        TextView lblsoyadi = layout.findViewById(R.id.txt_soyadi);
        lblsoyadi.setText(student.getLastname());
        TextView lblgun = layout.findViewById(R.id.txt_gun);
        lblgun.setText(student.getGun());

        return layout;
    }
}
