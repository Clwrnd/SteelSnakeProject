/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.idmont.candw.serpentdeferproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Side;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author patrick
 */
public class Controller {
    InterfaceBody view;
    
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
            System.out.print("hey");
            ContextMenu contextmenu = new ContextMenu();
            MenuItem creerA = new MenuItem("Créer un arrêt ");
            MenuItem creerL = new MenuItem("Créer une ligne");
            MenuItem copier = new MenuItem("Copier");
            MenuItem coller = new MenuItem("Coller");
            MenuItem supprimer = new MenuItem("Supprimer");
            MenuItem deplacer = new MenuItem("Déplacer");
            contextmenu.getItems().addAll(creerA,creerL,copier,coller,supprimer,deplacer);
            contextmenu.show(view,e.getScreenX(),e.getScreenY());
        }
        
        
    }
    


    
}
