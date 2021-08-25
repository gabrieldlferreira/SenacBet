package com.example.senacbet.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.senacbet.model.Apostador;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ApostadorDAO {
    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase db;

    public ApostadorDAO(Context context) {
        this.sqLiteHelper = new SQLiteHelper(context);
    }

    public void salvar(Apostador apostador){
        db = sqLiteHelper.getWritableDatabase();

        ContentValues values =new ContentValues();
        values.put(SQLiteHelper.CAMPO_NOME, apostador.getNome());
        values.put(SQLiteHelper.CAMPO_SALDO, apostador.getSaldo());
        values.put(SQLiteHelper.CAMPO_EMAIL, apostador.getEmail());

        db.insert(SQLiteHelper.TABELA_CONTATO, null, values);

        db.close();
    }

    public void listar() throws ParseException {
        db = sqLiteHelper.getReadableDatabase();

        String sql = "SELECT * FROM " + SQLiteHelper.TABELA_CONTATO + ";";

        Cursor c = db.rawQuery(sql, null);

        List<Apostador> apostador = new ArrayList<>();

        while(c.moveToNext()){
            Apostador apostador1 = new Apostador();
            apostador1.setNome(c.getString(c.getColumnIndex(SQLiteHelper.CAMPO_NOME)));
            apostador1.setSaldo(c.getString(c.getColumnIndex(SQLiteHelper.CAMPO_SALDO)));
            apostador1.setEmail(c.getString(c.getColumnIndex(SQLiteHelper.CAMPO_EMAIL)));
            }

            apostador.add(apostador);
        }

        c.close();
        db.close();

        return apostador;
    }
}
