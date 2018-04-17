package com.hola.cesar.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hola.cesar.interfaces.ExamenInterface;
import com.hola.cesar.presentator.ExamenPresentator;

public class MensajeActivity extends AppCompatActivity implements ExamenInterface.FormView{
    EditText des,mes;
    private ExamenInterface.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);
        des=findViewById(R.id.to);
        mes=findViewById(R.id.textmessage);
        presenter=new ExamenPresentator(this);

    }

    public void enviar(View view) {

        presenter.mensaje(getApplicationContext(),
                des.getText().toString(),
                mes.getText().toString());
    }

    @Override
    public void mostrarResultado() {
        Toast.makeText(this,"Mensaje enviado!",
                Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,ListMessageActivity.class));
    }
}
