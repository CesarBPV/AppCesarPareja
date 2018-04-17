package com.hola.cesar.examen;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Datos extends SQLiteOpenHelper {

    public Datos(Context context){
        super(context,"Examen",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE CONTACTOS (NOMBRES text,NUMERO text)");
        sqLiteDatabase.execSQL(
                "CREATE TABLE MENSAJE (DESTINO text,MENSAJE text)");
    }

    public void agregarContacto(Datos db, String numero, String nombres){
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NUMERO",numero);
        contentValues.put("NOMBRES",nombres);
        sqLiteDatabase.insert(
                "CONTACTOS",null,contentValues);
    }

    public void agregarMensaje(Datos db, String destino, String mensaje){
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DESTINO",destino);
        contentValues.put("MENSAJE",mensaje);
        sqLiteDatabase.insert(
                "MENSAJE",null,contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
