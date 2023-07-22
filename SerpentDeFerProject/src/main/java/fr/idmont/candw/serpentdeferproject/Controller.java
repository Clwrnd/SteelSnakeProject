/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.idmont.candw.serpentdeferproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
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
            MenuItem selectionner = InterfaceBody.createMenuItem("Sélectionner", "selectionner.png");
            MenuItem deplacer = InterfaceBody.createMenuItem("Déplacer", "deplacer.png");
            MenuItem ajouterL = InterfaceBody.createMenuItem("Ajouter une ligne", "ligne.png");
            MenuItem ajouterA = InterfaceBody.createMenuItem("Ajouter un arrêt", "arret.png");
            MenuItem ajouterT = InterfaceBody.createMenuItem("Ajouter un tram", "tram.png");
            MenuItem couper = InterfaceBody.createMenuItem("Couper", "couper.png");
            MenuItem copier = InterfaceBody.createMenuItem("Copier", "copier.png");
            MenuItem coller = InterfaceBody.createMenuItem("Coller", "coller.png");
            MenuItem zoom = InterfaceBody.createMenuItem("Zoom avant", "zoom.png");
            MenuItem dezoom = InterfaceBody.createMenuItem("Zoom arrière", "dezoom.png");
            MenuItem supprimer = InterfaceBody.createMenuItem("Supprimer", "supprimer.png");
            
            contextmenu.getItems().addAll(selectionner,deplacer,ajouterL,ajouterA,ajouterT,couper,copier,coller,zoom,dezoom,supprimer);
            
            SeparatorMenuItem separateur1 = new SeparatorMenuItem();
            SeparatorMenuItem separateur2 = new SeparatorMenuItem();
            SeparatorMenuItem separateur3 = new SeparatorMenuItem();
            SeparatorMenuItem separateur4 = new SeparatorMenuItem();
            contextmenu.getItems().add(2, separateur1);
            contextmenu.getItems().add(6, separateur2);
            contextmenu.getItems().add(10, separateur3);
            contextmenu.getItems().add(13, separateur4);
            
            contextmenu.show(view,e.getScreenX(),e.getScreenY());
        }
        
        
    }
    


    
}
