package com.hola.cesar.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private String user="cesar";
    private String pass="123";
    public String name="César Pareja";
    private int i=0;
    private EditText usermed,passmed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usermed=findViewById(R.id.usered);
        passmed=findViewById(R.id.passed);
    }

    public void login(View view) {
        if(i<2){
            String username=usermed.getText().toString();
            String password=passmed.getText().toString();
            if(username.equals(user)&&password.equals(pass)){
                Intent intent=new Intent(this,MainActivity.class);
                intent.putExtra("nombres",name);
                startActivity(intent);
            }else if(username.equals(user)&&!password.equals(pass)){
                i++;
                passmed.setText("");
                passmed.requestFocus();
                Toast.makeText(this,"Contraseña incorrecta. Tienes "+(3-i)+" intentos",Toast.LENGTH_SHORT).show();
            }else if(!username.equals(user)){
                i++;
                usermed.setText("");
                passmed.setText("");
                usermed.requestFocus();
                Toast.makeText(this,"Usuario Inválido. Tienes "+(3-i)+" intentos",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"No hay más intentos, se cerrará la aplicación",Toast.LENGTH_SHORT).show();
            finish();
            System.exit(0);
        }
    }

}
