/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.idmont.candw.serpentdeferproject;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author clara
 */
public class InterfaceBody extends BorderPane{
    
    MenuBar menuBar ;
    Menu fichier ;
    Menu aide ;
    MenuItem nouveau ;
    MenuItem ouvrir ;
    MenuItem enregistrer ;
    MenuItem enregistrersous ;
    MenuItem fermer ;
    MenuItem aproposde ;
    MenuItem siteCTS ;
    Separator sepAide ;
    Controller controller;
    
    public InterfaceBody (Stage stage){
        
        this.fichier = new Menu("Fichier");
        this.aide = new Menu("Aide");
        
        this.nouveau = new MenuItem("Nouveau");
        this.ouvrir = new MenuItem("Ouvrir");
        this.enregistrer = new MenuItem("Enregistrer");
        this.enregistrersous = new MenuItem("Enregistrer sous");
        this.fermer = new MenuItem("Fermer");
        fichier.getItems().addAll(nouveau,ouvrir,enregistrer,enregistrersous,fermer);
        
        this.aproposde = new MenuItem("A propos de...");
        this.siteCTS = new MenuItem("Site CTS");
        this.sepAide = new Separator();
        aide.getItems().addAll(aproposde,siteCTS);
        
        this.menuBar = new MenuBar();
        menuBar.getMenus().addAll(fichier,aide);
        this.setTop(menuBar);
        
        this.getStylesheets().add("file:src/main/java/fr/idmont/candw/serpentdeferproject/Style.css");
        
        
        
        
        
        
        
        
        
        
        
        this.controller= new Controller(this);
        
        this.nouveau.setOnAction(e->{
            this.controller.nouveau(e);
        });
        
        this.fermer.setOnAction(e->{
            this.controller.fermer(e);
        });
        
        this.ouvrir.setOnAction(e->{
            this.controller.ouvrir(e);
        });
        
        this.enregistrer.setOnAction(e->{
            this.controller.enregistrer(e);
        });
        
        this.enregistrersous.setOnAction(e->{
            this.controller.enregistrersous(e);
        });
        
        this.aproposde.setOnAction(e->{
            this.controller.aproposde(e);
        });
        
        this.siteCTS.setOnAction(e->{
            this.controller.siteCTS(e);
        });
    }

    
  
}
