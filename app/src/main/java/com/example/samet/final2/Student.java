package com.example.samet.final2;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by samet on 28.05.2018.
 */


@Entity(tableName = "student")
public class Student{


    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "first_name")
    public String firstname;

    @ColumnInfo(name = "last_name")
    public String lastname;

    @ColumnInfo(name = "gun")
    public String gun;


    @Ignore
    public String fullname;

    @NonNull
    public int term;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFullname() {

        this.fullname = this.firstname+ "" + this.lastname;

        return this.fullname;
    }

    public String getGun() {
        return gun;
    }

    public void setGun(String gun) {
        this.gun = gun;
    }


    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }
}
