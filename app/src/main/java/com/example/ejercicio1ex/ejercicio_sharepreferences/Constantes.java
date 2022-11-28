package com.example.ejercicio1ex.ejercicio_sharepreferences;

public class Constantes {
    public static final String USER = "usuario";
    public static final String PASSWORD = "contraseña";

    public static String codificaPassword(String password){
        StringBuilder codificado = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            codificado.append((char)password.charAt(i)+1);
        }
        return codificado.toString();
    }

    public static String descodificaPassword(String password){
        StringBuilder codificado = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            codificado.append((char)password.charAt(i)-1);
        }
        return codificado.toString();
    }
}
