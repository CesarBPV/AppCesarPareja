package com.hola.cesar.examen;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListContactsActivity extends AppCompatActivity {

    ListView lvcontacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contacts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtras(getIntent().getExtras());
                startActivity(intent);
            }
        });
        lvcontacts=findViewById(R.id.contactslv);

        Datos datos = new Datos(this);
        SQLiteDatabase sqLiteDatabase = datos.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "select * from CONTACTOS",null);

        List<Map<String,String>> list=new ArrayList<>();
        if(cursor!=null){
            if(cursor.moveToFirst()) {
                do {
                    String nombres = cursor.getString(
                            cursor.getColumnIndex("NOMBRES"));
                    String numero = cursor.getString(
                            cursor.getColumnIndex("NUMERO"));
                    HashMap<String, String> map = new HashMap<>();
                    map.put("nom", nombres);
                    map.put("cel", numero);
                    list.add(map);
                } while (cursor.moveToNext());
                System.out.println(list.toString());
                ListAdapter listAdapter = new SimpleAdapter(this, list, R.layout.item_contact,
                        new String[]{"nom", "cel"}, new int[]{R.id.tvnombre, R.id.tvcel});
                lvcontacts.setAdapter(listAdapter);
            }
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ContactsActivity.class));
            }
        });
    }

}
