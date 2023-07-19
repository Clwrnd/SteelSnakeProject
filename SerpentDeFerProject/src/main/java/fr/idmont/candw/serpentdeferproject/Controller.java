/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.idmont.candw.serpentdeferproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

/**
 *
 * @author patrick
 */
public class Controller {
    InterfaceBody view;
    
    public Controller(InterfaceBody view){
        view=this.view;
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



    
}
