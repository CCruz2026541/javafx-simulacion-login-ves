/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cristophercruz.controller;
import com.cristophercruz.model.Usuario;
import com.cristophercruz.view.LoginView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 *
 * @author informatica
 */
public class LoginController {
    private final LoginView LOGIN_VIEW;
    private double ejeX=0;
    private double ejeY=0;
  
    public LoginController ( LoginView loginView){
        this.LOGIN_VIEW = loginView;
        construirAcciones();
    }
    
    private Stage escenarioPrincpal = SceneManager
                            .getInstanciaSceneManager().getEscenarioPrincipal();
    
    private AuthSistema authSistema = new AuthSistema();
   
    public void iniciarSesion(){
        String nombreUsuario = this.LOGIN_VIEW.getTxtNombreUsuario().getText().trim();
        String clave = this.LOGIN_VIEW.getPwdClave().getText().trim();
        
        if( nombreUsuario.isEmpty() ){
            this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().add("empty");
           JOptionPane.showMessageDialog(null, "NO DEJES VACIO EL NOMBRE DE USUARIO");
       }else if( clave.isEmpty() ){
           this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().remove("empty");
           this.LOGIN_VIEW.getPwdClave().getStyleClass().add("empty");
           JOptionPane.showMessageDialog(null, "NO DEJES VACIO LA CONTRASEÑA");
           
       }else{
           this.LOGIN_VIEW.getPwdClave().getStyleClass().remove("empty");
           //METODO LOGIN
           Usuario usuario = authSistema.login(nombreUsuario, clave);
           
           if( usuario == null ){
               JOptionPane.showMessageDialog(null, "VERIFICA TUS CREDENCIALES");
           }else{
               JOptionPane.showMessageDialog(null, "HOLA BIENVENIDO");
           }
       }
    }
    
    public void construirAcciones(){
        
         this.LOGIN_VIEW.getBtnIniciarSesion().setOnMouseClicked(
             (evento)->{
                 System.exit(0);
             }
    );
          
        this.LOGIN_VIEW.getBtnCerrarVentana().setOnMouseClicked(
            (evento)->{
                System.exit(0);
            }       
        );
        
        this.LOGIN_VIEW.setOnMouseClicked(
             (evento)->{
                 ejeX = evento.getSceneX();
                 ejeY = evento.getSceneY();
             }
    );
        
        this.LOGIN_VIEW.setOnMouseClicked(
             (evento)->{
                 double ejeXDesplazamientoVentana = evento.getSceneX();
                 double ejeYDesplazamientoVentana = evento.getSceneY();
                 
                 escenarioPrincpal.setX( ejeXDesplazamientoVentana - ejeX);
                 escenarioPrincpal.setY( ejeYDesplazamientoVentana - ejeY);
             }
    );
        
        
//       this.LOGIN_VIEW.setOnMouseDragged(
//       (evento)->{
//                 ejeX = evento.getSceneX();
//                 ejeY = evento.getSceneY();
//                 System.out.println("Eje x " + ejeX);
//                 System.out.println("Eje y " + ejeY);
//                 System.out.println("Eje x pantalla" + evento.getSceneX());
//                 System.out.println("Eje y pantalla" + evento.getSceneY());
//
//             }
//       );
        
    }
    
    
    
    
}
