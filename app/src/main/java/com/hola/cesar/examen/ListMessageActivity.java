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

public class ListMessageActivity extends AppCompatActivity {

    ListView lvmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_message);
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
        lvmessage=findViewById(R.id.messagelv);

        Datos datos = new Datos(this);
        SQLiteDatabase sqLiteDatabase = datos.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "select * from MENSAJE",null);

        List<Map<String,String>> list=new ArrayList<>();
        if(cursor!=null){
            if(cursor.moveToFirst()) {
                do {
                    String nombres = cursor.getString(
                            cursor.getColumnIndex("DESTINO"));
                    String mes = cursor.getString(
                            cursor.getColumnIndex("MENSAJE"));
                    HashMap<String, String> map = new HashMap<>();
                    map.put("des", nombres);
                    map.put("mes", mes);
                    list.add(map);
                } while (cursor.moveToNext());
                System.out.println(list.toString());
                ListAdapter listAdapter = new SimpleAdapter(this, list, R.layout.item_message,
                        new String[]{"des", "mes"}, new int[]{R.id.tvdes, R.id.tvmes});
                lvmessage.setAdapter(listAdapter);
            }
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MensajeActivity.class));
            }
        });
    }

}
