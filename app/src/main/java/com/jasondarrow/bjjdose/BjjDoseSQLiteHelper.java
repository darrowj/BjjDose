package com.jasondarrow.bjjdose;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by darrowj on 2/11/18.
 */

public class BjjDoseSQLiteHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "BjjDose.db";
    public static final int DATABASE_VERSION = 1;


    public BjjDoseSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BjjDoseDOA.DoseEntity.SQL_CREATE_TABLE);
        db.execSQL(BjjDoseDOA.LookupEntity.SQL_CREATE_TABLE);

        DatabaseDataWorker worker = new DatabaseDataWorker(db);
        worker.insertDoses();
        worker.insertLookup();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
