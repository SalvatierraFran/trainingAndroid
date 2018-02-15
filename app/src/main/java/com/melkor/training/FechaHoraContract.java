package com.melkor.training;

import android.provider.BaseColumns;

import java.sql.Timestamp;

/**
 * Created by franco.salvatierra on 15/02/2018.
 */

public class FechaHoraContract {

    public static abstract class FechaHoraEntry implements BaseColumns{
        public static final String TABLE_NAME = "FechayHora";

        public static final String CAMPO_FECHAHORA = "fechahora";

        public static final String CREAR_TABLA_FECHA = "CREATE TABLE " + TABLE_NAME + " ("
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + CAMPO_FECHAHORA + " TEXT NOT NULL)";
    }
}
