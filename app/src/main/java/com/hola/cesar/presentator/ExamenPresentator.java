package com.hola.cesar.presentator;

import android.content.Context;
import android.widget.Toast;

import com.hola.cesar.interfaces.ExamenInterface;
import com.hola.cesar.model.ExamenModel;

public class ExamenPresentator implements ExamenInterface.Presenter {
    private ExamenInterface.FormView view;
    private ExamenInterface.Model model;

    public ExamenPresentator(ExamenInterface.FormView view){
        this.view=view;
        model=new ExamenModel(this);
    }

    @Override
    public void mostrarResultado() {
        if(view!=null){
            view.mostrarResultado();
        }
    }

    @Override
    public void mensaje(Context ctx, String destino, String mensaje) {
        System.out.println("hola");
        if(view!=null){
            System.out.println("mundo");
            model.agregarMensaje(ctx,destino,mensaje);
        }
    }

    @Override
    public void contacto(Context ctx, String nombre, String numero) {
        if(view!=null){
            model.agregarContacto(ctx,nombre,numero);
        }
    }
}
