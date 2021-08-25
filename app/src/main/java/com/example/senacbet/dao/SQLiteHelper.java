package com.example.senacbet.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class SQLiteHelper {
    private static final String NOME_BD = "com.example.senacbet";

    static final String CAMPO_NOME = "NOME";
    static final String CAMPO_SALDO = "SALDO";
    static final String CAMPO_EMAIL = "EMAIL";
    static final String CAMPO_ID = "ID";

    static final String TABELA_APOSTADOR = "APOSTADOR";

    private final String BD_CREATE_APOSTADOR = "CREATE TABLE "+TABELA_APOSTADOR+" (" +
            CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            CAMPO_NOME + " TEXT," +
            CAMPO_SALDO + " TEXT," +
            CAMPO_EMAIL + " TEXT," +
            ");";

    public SQLiteHelper(@Nullable Context context) {
        super(context, NOME_BD, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BD_CREATE_APOSTADOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLiteDatabase getReadableDatabase() {
    }

    public SQLiteDatabase getWritableDatabase() {
    }
}
}
