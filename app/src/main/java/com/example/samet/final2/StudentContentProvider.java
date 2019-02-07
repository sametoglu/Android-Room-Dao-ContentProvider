package com.example.samet.final2;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by samet on 28.05.2018.
 */

public class StudentContentProvider extends ContentProvider {

    public static String AUTHORITY = "com.example.samet.final2.StudentContentProvider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    private SQLiteHelper sqLiteHelper;

    public static final class StudentContact{
        public static String _ID = "id";
        public static String FIRST_NAME = "first_name";
        public static String LAST_NAME = "last_name";
        public static String TERM = "term";
    }

    static StudentContact sc = new StudentContact();


    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder)
    {
        // select sorgusu
        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();
        Cursor cursor = db.query("student", projection, selection, selectionArgs, null, null, sortOrder);
        return cursor;
    }

    @Override
    public boolean onCreate() {

        sqLiteHelper = new SQLiteHelper(getContext(), "bm443", null, 1);

        return true;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return AUTHORITY;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();
        long id = db.insert("student", null, values);
        getContext().getContentResolver().notifyChange(uri, null);
        return Uri.parse(CONTENT_URI + "/" + id);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();
        int deleteCount = db.delete("student", selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return deleteCount;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();
        int updateCount = db.update("student", values, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return updateCount;
    }
}
