package com.hola.cesar.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hola.cesar.interfaces.ExamenInterface;
import com.hola.cesar.presentator.ExamenPresentator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactsActivity extends AppCompatActivity implements ExamenInterface.FormView{
    EditText nom,num;
    private ExamenInterface.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        nom=findViewById(R.id.contactname);
        num=findViewById(R.id.phonenumber);
        presenter=new ExamenPresentator(this);
    }

    public void guardar(View view) {

        presenter.contacto(getApplicationContext(),
                num.getText().toString(),
                nom.getText().toString());
    }

    @Override
    public void mostrarResultado() {
        Toast.makeText(this,"Contacto registrado",
                Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,ListContactsActivity.class));
    }
}
