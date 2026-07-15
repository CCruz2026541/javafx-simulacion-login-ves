/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cristophercruz.controller;

import com.cristophercruz.model.Rol;
import com.cristophercruz.model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author informatica
 */
public class AuthSistema {
    private static ArrayList <Usuario> listaUsuario = new ArrayList<>();
    
    public AuthSistema(){
        Usuario usuarioAdmin = new Usuario("admin",
                                "admin", "admin", Rol.ADMIN);
        Usuario usuarioUser = new Usuario("user",
                                "user", "user", Rol.USER);
        Usuario usuarioYo = new Usuario("Cristopher",
                                "123", "Cristopher Gabriel Cruz Choc"
                                , Rol.ADMIN);
        
        listaUsuario.add(usuarioAdmin);
        listaUsuario.add(usuarioUser);
        listaUsuario.add(usuarioYo);
    }

    public Usuario login(String nombreUsuario, String clave){
        for(Usuario usuarioBuscado : listaUsuario ){
            if(usuarioBuscado.getNombreUsuario().equals(nombreUsuario)
                    && usuarioBuscado.getPassword().equals(clave))
                return usuarioBuscado;
        }
        return null;
    }
    
    
    public static ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public static void setListaUsuario(ArrayList<Usuario> listaUsuario) {
        AuthSistema.listaUsuario = listaUsuario;
    }
    
    
    
}
