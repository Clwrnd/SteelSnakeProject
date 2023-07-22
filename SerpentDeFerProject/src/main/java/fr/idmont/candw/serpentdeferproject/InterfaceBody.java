/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.idmont.candw.serpentdeferproject;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    MenuItem imprimer ;
    MenuItem fermer ;
    MenuItem quitter;
    MenuItem aproposde ;
    MenuItem siteCTS ;
    SeparatorMenuItem separateur1 ;
    SeparatorMenuItem separateur2 ;
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
    ContextMenu contextmenu;
    MenuItem creerA;
    MenuItem creerL;
    MenuItem copier;
    MenuItem coller;
    MenuItem supprimerClic;
    MenuItem deplacerClic; 
    
    public InterfaceBody (Stage stage){
        
        //Création du MenuBar
        this.fichier = new Menu("Fichier");
        this.aide = new Menu("Aide");
        
        this.nouveau = createMenuItem("Nouveau", "nouveau.png");
        this.ouvrir = createMenuItem("Ouvrir", "ouvrir.png");
        this.enregistrer = createMenuItem("Enregistrer", "enregistrer.png");
        this.enregistrersous = createMenuItem("Enregistrer sous", "enregistrersous.png");
        this.imprimer = createMenuItem("Imprimer", "imprimer.png");
        this.fermer = createMenuItem("Fermer", "fermer.png");
        this.quitter = createMenuItem("Quitter", "quitter.png");
        this.fichier.getItems().addAll(nouveau,ouvrir,enregistrer,enregistrersous,imprimer,fermer,quitter);
        
        this.separateur1 = new SeparatorMenuItem();
        this.separateur2 = new SeparatorMenuItem();
        this.fichier.getItems().add(2, separateur1);
        this.fichier.getItems().add(7, separateur2);
        
        this.aproposde = createMenuItem("A propose de...", "aproposde.png");
        this.siteCTS = createMenuItem("Site CTS", "cts.png");
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
        
        this.contextmenu = new ContextMenu();
        this.creerA = new MenuItem("Créer un arrêt ");
        this.creerL = new MenuItem("Créer une ligne");
        this.copier = new MenuItem("Copier");
        this.coller = new MenuItem("Coller");
        this.supprimerClic = new MenuItem("Supprimer");
        this.deplacerClic = new MenuItem("Déplacer");
        this.contextmenu.getItems().addAll(creerA,creerL,copier,coller,supprimerClic,deplacerClic);
        this.contextmenu.setAutoHide(true);
        
        //this.horizontalSplitPane.setDividerPosition(0, 0.00);
        //this.centerPane.minWidthProperty().bind(leftTopPane.widthProperty().multiply(0.26));
        
        //Création de la barre d'outils
        this.toolBar = new ToolBar();
        this.reseau = createButton("Créer réseau", "reseau.png", "Créer un réseau");
        this.ligne = createButton("Ajouter ligne", "ligne.png", "Ajouter une ligne");
        this.arret = createButton("Ajouter arrêt", "arret.png", "Ajouter un arrêt");
        this.tram = createButton("Ajouter tram", "tram.png", "Ajouter un tram");
        this.selectionner = createButton("", "selectionner.png", "Sélectionner");
        this.deplacer = createButton("", "deplacer.png", "Déplacer");
        this.retourarriere = createButton("", "retourarriere.png", "Retour arrière");
        this.retouravant = createButton("", "retouravant.png", "Retour avant");
        this.zoom = createButton("", "zoom.png", "Zoom");
        this.dezoom = createButton("", "dezoom.png", "Dézoom");
        this.supprimer = createButton("", "supprimer.png", "Supprimer");
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

    //Méthodes
        public MenuItem createMenuItem(String descriptionMI, String nomMI){
            String pathMI = "file:src\\main\\java\\fr\\idmont\\candw\\serpentdeferproject\\Icônes\\";
            Image imageMI = new Image(pathMI + nomMI);
            ImageView iconeMI = new ImageView(imageMI);
            iconeMI.setFitWidth(20);
            iconeMI.setFitHeight(20); 
            iconeMI.setPreserveRatio(true);
            MenuItem menuItem = new MenuItem(descriptionMI, iconeMI);
            return menuItem;
    } 
    
        public static Button createButton(String descrptionB, String nomB, String legendeB) {
            Tooltip tooltip = new Tooltip(legendeB);
            String cheminB = "file:src\\main\\java\\fr\\idmont\\candw\\serpentdeferproject\\Icônes\\";
            Image imageB = new Image(cheminB + nomB);
            ImageView iconeB = new ImageView(imageB);
            iconeB.setFitHeight(25);
            iconeB.setFitWidth(25);
            iconeB.setPreserveRatio(true);
            Button button = new Button(descrptionB, iconeB);
            button.setMinSize(30, 30);
            button.setTooltip(tooltip);

            return button;
    }
  
}
