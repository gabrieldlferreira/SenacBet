package com.example.senacbet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.senacbet.dao.ApostadorDAO;
import com.example.senacbet.model.Apostador;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.ParseException;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro_time);


    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView view  = findViewById(R.id.activity_form_cadastro_apostador);

        ApostadorDAO contatoDAO = new ApostadorDAO(MainActivity.this);

        try {
            view.setAdapter(new ArrayAdapter<Apostador>(MainActivity.this,
                    android.R.layout.simple_list_item_1,
                    ApostadorDAO.listar()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}