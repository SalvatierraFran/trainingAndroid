package com.melkor.training;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by franco.salvatierra on 15/02/2018.
 */

public class FechaHoraDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FechaHoraBoton.db";

    public FechaHoraDbHelper(Context context, String DATABASE_NAME, SQLiteDatabase.CursorFactory factory, int DATABASE_VERSION)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDataBase){
        /*sqLiteDataBase.execSQL("CREATE TABLE " + FechaHoraContract.FechaHoraEntry.TABLE_NAME + " ("
                                + FechaHoraContract.FechaHoraEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                                + FechaHoraContract.FechaHoraEntry.CAMPO_FECHAHORA + " TEXT NOT NULL)");*/

        sqLiteDataBase.execSQL(FechaHoraContract.FechaHoraEntry.CREAR_TABLA_FECHA);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

}
