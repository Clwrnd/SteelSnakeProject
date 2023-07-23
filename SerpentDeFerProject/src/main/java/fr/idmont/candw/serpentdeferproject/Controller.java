/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.idmont.candw.serpentdeferproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.input.*;

/**
 *
 * @author patrick
 */
public class Controller {
    
    InterfaceBody view;
    Etat etat;
    
    public Controller(InterfaceBody view){
        this.view=view;
    }

    void nouveau(ActionEvent e) {
    }

    void fermer(ActionEvent e) {
    }

    void ouvrir(ActionEvent e) {
    }

    void enregistrer(ActionEvent e) {
    }

    void enregistrersous(ActionEvent e) {
    }

    void aproposde(ActionEvent e) {
    }

    void siteCTS(ActionEvent e) {      
         Application lien = new Application() {@Override public void start(Stage stage){}};
         lien.getHostServices().showDocument("https://www.cts-strasbourg.eu/de/");
    }

    void quitter(Stage stage) {
        stage.close();
    }

    void confirmation(WindowEvent e) {
        // e.consume();
    }

    void ClicInZone(MouseEvent e) {
        if(e.getButton()== MouseButton.SECONDARY){
            this.view.contextmenu.show(view.getScene().getWindow(),e.getScreenX(),e.getScreenY());
        }
        
    }


    


    
}
