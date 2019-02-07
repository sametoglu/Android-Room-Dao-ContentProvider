package com.example.samet.final2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by samet on 28.05.2018.
 */

@Dao
public interface IStudentDAO {

    @Insert
    void insertStudent(Student... student);

    @Update
    void updateStudent(Student... student);

    @Delete
    void deleteStudent(Student... student);

    @Query("Select * From student")
    List<Student> loadAllStudents();

    @Query("Select * from student where term between :minTerm and :maxTerm")
    List<Student> loadStudentBetweenTerms(int minTerm,int maxTerm);

}
