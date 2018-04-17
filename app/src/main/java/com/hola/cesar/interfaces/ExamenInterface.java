package com.hola.cesar.interfaces;

import android.content.Context;

public interface ExamenInterface {
    interface FormView{
        void mostrarResultado();
    }
    interface Presenter{
        void mostrarResultado();
        void mensaje(Context ctx, String destino, String mensaje);
        void contacto(Context ctx, String nombre,String numero);
    }
    interface Model{
        void agregarMensaje(Context ctx, String destino, String mensaje);
        void agregarContacto(Context ctx,String nombre,String numero);
    }
}
