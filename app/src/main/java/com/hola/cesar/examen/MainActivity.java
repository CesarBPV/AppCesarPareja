package com.hola.cesar.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView welcome;
    CardView mensajes,contactos,enc,cursos;
    String nombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcome=findViewById(R.id.welcome);
        nombres=getIntent().getStringExtra("nombres");
        welcome.setText("Bienvenido "+nombres+"!");
        mensajes=findViewById(R.id.message_card);
        contactos=findViewById(R.id.contacts_card);
        enc=findViewById(R.id.encuestas_card);
        cursos=findViewById(R.id.courses_card);

        mensajes.setOnClickListener(this);
        contactos.setOnClickListener(this);
        enc.setOnClickListener(this);
        cursos.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent=null;
        switch(view.getId()){
            case R.id.message_card:
                intent=new Intent(this,ListMessageActivity.class);
                break;
            case R.id.contacts_card:
                intent=new Intent(this,ListContactsActivity.class);
                break;
            case R.id.encuestas_card:
                intent=new Intent(this,PollActivity.class);
                break;
            case R.id.courses_card:
                intent=new Intent(this,CourseActivity.class);
                break;
        }
        intent.putExtra("nombres",nombres);
        startActivity(intent);
    }
}
