/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.idmont.candw.serpentdeferproject;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToolBar;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author clara
 */
public class InterfaceBody extends BorderPane{
    
    Controller controller ;
    MenuBar menuBar ;
    Menu fichier ;
    Menu aide ;
    MenuItem nouveau ;
    MenuItem ouvrir ;
    MenuItem enregistrer ;
    MenuItem enregistrersous ;
    MenuItem fermer ;
    MenuItem quitter;
    MenuItem aproposde ;
    MenuItem siteCTS ;
    BorderPane centerPane ;
    SplitPane horizontalSplitPane ;
    SplitPane verticalSplitPane ;
    FlowPane leftTopPane ;
    ScrollPane leftBottomPane ;
    TreeView treeView ;
    TreeItem recap ;
    TreeItem ligneA ; //exemple
    TreeItem ligneB ; //exemple
    TreeItem arret1A ; //exemple
    TreeItem arret2A ; //exemple
    TreeItem arret1B ; //exemple
    TreeItem arret2B ; //exemple
    ToolBar toolBar ;
    Button reseau ;
    Button ligne ;
    Button arret ;
    Button tram ;
    Button selectionner ;
    Button deplacer ;
    Button retourarriere ;
    Button retouravant ;
    Button dezoom ;
    Button zoom ;
    Button supprimer ;
    CreationZone zone;
    
    public InterfaceBody (Stage stage){
        
        this.fichier = new Menu("Fichier");
        this.aide = new Menu("Aide");
        
        this.nouveau = new MenuItem("Nouveau");
        this.ouvrir = new MenuItem("Ouvrir");
        this.enregistrer = new MenuItem("Enregistrer");
        this.enregistrersous = new MenuItem("Enregistrer sous");
        this.fermer = new MenuItem("Fermer");
        this.quitter = new MenuItem("Quitter");
        this.fichier.getItems().addAll(nouveau,ouvrir,enregistrer,enregistrersous,fermer,quitter);
        
        this.aproposde = new MenuItem("A propos de...");
        this.siteCTS = new MenuItem("Site CTS");
        this.aide.getItems().addAll(aproposde,siteCTS);
        
        this.menuBar = new MenuBar();
        this.menuBar.getMenus().addAll(fichier,aide);
        this.setTop(menuBar);
        
        //Création du Pane en haut à gauche avec récap des lignes et arrêts
        this.recap = new TreeItem();
        
        this.treeView = new TreeView(recap);
        this.treeView.setShowRoot(false);
        
        this.ligneA = new TreeItem("Ligne A"); //non définitif
        this.ligneB = new TreeItem("Ligne B");
        this.arret1A = new TreeItem("Arrêt 1A");
        this.arret2A = new TreeItem("Arrêt 2A");
        this.arret1B = new TreeItem("Arrêt 1B");
        this.arret2B = new TreeItem("Arrêt 2B");
        
        this.ligneA.getChildren().addAll(arret1A,arret2A);
        this.ligneB.getChildren().addAll(arret1B,arret2B);
        this.recap.getChildren().addAll(ligneA, ligneB);
        
        this.leftTopPane = new FlowPane(treeView);
        this.leftBottomPane = new ScrollPane();
        this.verticalSplitPane = new SplitPane();
        this.verticalSplitPane.getItems().addAll(leftTopPane,leftBottomPane);
        this.verticalSplitPane.setOrientation(Orientation.VERTICAL);
        this.centerPane = new BorderPane();
        this.centerPane.getStyleClass().add("centerPane");
        
        this.horizontalSplitPane = new SplitPane();
        this.horizontalSplitPane.getItems().addAll(verticalSplitPane, centerPane);
        this.setCenter(horizontalSplitPane);
        
        this.toolBar = new ToolBar();
        this.reseau = new Button("Créer réseau");
        this.ligne = new Button("Ajouter ligne");
        this.arret = new Button("Ajouter arrêt");
        this.tram = new Button("Ajouter tram");
        this.selectionner = new Button("Sélectionner");
        this.deplacer = new Button ("Déplacer");
        this.retourarriere = new Button("Retour arrière");
        this.retouravant = new Button("Retour avant");
        this.zoom = new Button("Zoom");
        this.dezoom = new Button ("Dezoom");
        this.supprimer = new Button ("Supprimer");
        this.toolBar.getItems().addAll(reseau,ligne,arret, tram,selectionner,deplacer,retourarriere,retouravant,zoom,dezoom,supprimer);
        this.centerPane.setTop(toolBar);
        
        this.zone= new CreationZone(this);
        this.centerPane.setCenter(zone);
        
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
        
        this.quitter.setOnAction(e->{
            this.controller.quitter(stage);
        });
        
        stage.setOnCloseRequest(e->{
            this.controller.confirmation(e);
        });
        
        this.zone.setOnMouseClicked(e->{
            this.controller.ClicInZone(e);
        });
        
    }

    
  
}
