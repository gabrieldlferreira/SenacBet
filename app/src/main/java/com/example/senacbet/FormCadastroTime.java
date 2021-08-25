package com.example.senacbet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormCadastroTime extends AppCompatActivity {

    private Button btn_cadastro_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro_time);

        IniciarComponentes();

        btn_cadastro_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormCadastroTime.this,FormCadastroApostador.class);
                startActivity(intent);
            }
        });
    }

    private void IniciarComponentes(){
        btn_cadastro_time = findViewById(R.id.buttonAvancar);
    }
}