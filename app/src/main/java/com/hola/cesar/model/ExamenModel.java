package com.hola.cesar.model;

import android.content.Context;

import com.hola.cesar.examen.Datos;
import com.hola.cesar.interfaces.ExamenInterface;

public class ExamenModel implements ExamenInterface.Model {
    private ExamenInterface.Presenter presenter;
    public ExamenModel(ExamenInterface.Presenter presenter){
        this.presenter = presenter;
    }
    @Override
    public void agregarMensaje(Context ctx, String destino, String mensaje) {
        System.out.println("mensaje");
        Datos datos = new Datos(ctx);
        datos.agregarMensaje(datos,
                destino,
                mensaje);
        presenter.mostrarResultado();
    }

    @Override
    public void agregarContacto(Context ctx, String nombre, String numero) {
        System.out.println("contacto");
        Datos datos = new Datos(ctx);
        datos.agregarContacto(datos,
                numero,
                nombre);
        presenter.mostrarResultado();
    }
}
