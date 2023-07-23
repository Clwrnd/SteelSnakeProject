/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.idmont.candw.serpentdeferproject;

import static fr.idmont.candw.serpentdeferproject.Etat.SELECTION;
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
    MenuItem selectionnerClic ;
    MenuItem deplacerClic;
    MenuItem ajouterL ;
    MenuItem ajouterA ;
    MenuItem ajouterT ;
    MenuItem couper ;
    MenuItem copier;
    MenuItem coller;
    MenuItem zoomClic ;
    MenuItem dezoomClic ;
    MenuItem supprimerClic;
    SeparatorMenuItem separateur3 ;
    SeparatorMenuItem separateur4 ;
    SeparatorMenuItem separateur5 ;
    SeparatorMenuItem separateur6 ;
    
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
        this.selectionnerClic = createMenuItem("Sélectionner", "selectionner.png");
        this.deplacerClic = createMenuItem("Déplacer", "deplacer.png");
        this.ajouterL = createMenuItem("Ajouter une ligne", "ligne.png");
        this.ajouterA = createMenuItem("Ajouter un arrêt", "arret.png");
        this.ajouterT = createMenuItem("Ajouter un tram", "tram.png");
        this.couper = createMenuItem("Couper", "couper.png");
        this.copier = createMenuItem("Copier", "copier.png");
        this.coller = createMenuItem("Coller", "coller.png");
        this.zoomClic = createMenuItem("Zoom", "zoom.png");
        this.dezoomClic = createMenuItem("Dezoom", "dezoom.png");
        this.supprimerClic = createMenuItem("Supprimer", "supprimer.png");
        this.contextmenu.getItems().addAll(selectionnerClic,deplacerClic,ajouterL,ajouterA,ajouterT,couper,copier,coller,zoomClic,dezoomClic,supprimerClic);
        this.contextmenu.setAutoHide(true);
        
        this.separateur3 = new SeparatorMenuItem();
        this.separateur4 = new SeparatorMenuItem();
        this.separateur5 = new SeparatorMenuItem();
        this.separateur6 = new SeparatorMenuItem();
        this.contextmenu.getItems().add(2, separateur3);
        this.contextmenu.getItems().add(6, separateur4);
        this.contextmenu.getItems().add(10, separateur5);
        this.contextmenu.getItems().add(13, separateur6);
        
        //this.horizontalSplitPane.setDividerPosition(0, 0.00);
        //this.centerPane.minWidthProperty().bind(leftTopPane.widthProperty().multiply(0.26));
        
        //Création de la barre d'outils
        this.toolBar = new ToolBar();
        this.reseau = createButton("Créer réseau", "reseau.png", "Créer un réseau");
        this.ligne = createButton("Ajouter ligne", "ligne.png", "Ajouter une ligne");
        this.arret = createButton("Ajouter arrêt", "arret.png", "Ajouter un arrêt");
        this.tram = createButton("Ajouter tram", "tram.png", "Ajouter un tram");
        this.selectionner = createButton("", "selectionner.png", "Sélectionner");
        this.deplacer = createButton("", "deplacer.png", "Se déplacer");
        this.retourarriere = createButton("", "retourarriere.png", "Retour arrière");
        this.retouravant = createButton("", "retouravant.png", "Retour avant");
        this.zoom = createButton("", "zoom.png", "Zoom avant");
        this.dezoom = createButton("", "dezoom.png", "Zoom arrière");
        this.supprimer = createButton("", "supprimer2.png", "Supprimer");
        this.toolBar.getItems().addAll(reseau,ligne,arret, tram,selectionner,deplacer,retourarriere,retouravant,zoom,dezoom,supprimer);
        this.centerPane.setTop(toolBar);
        
        this.zone= new CreationZone(this);
        this.centerPane.setCenter(zone);
        
        this.getStylesheets().add("file:src/main/java/fr/idmont/candw/serpentdeferproject/Style.css");

        
        
        
        
        
        this.controller= new Controller(this);
        this.controller.etat= SELECTION;
        
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
        public static MenuItem createMenuItem(String descriptionMI, String nomMI){
            String pathMI = "file:src\\main\\java\\fr\\idmont\\candw\\serpentdeferproject\\Icônes\\";
            Image imageMI = new Image(pathMI + nomMI);
            ImageView iconeMI = new ImageView(imageMI);
            iconeMI.setFitWidth(25);
            iconeMI.setFitHeight(25); 
            iconeMI.setPreserveRatio(true);
            MenuItem menuItem = new MenuItem(descriptionMI, iconeMI);
            return menuItem;
    } 
    
        public static Button createButton(String descrptionB, String nomB, String legendeB) {
            Tooltip tooltip = new Tooltip(legendeB);
            String cheminB = "file:src\\main\\java\\fr\\idmont\\candw\\serpentdeferproject\\Icônes\\";
            Image imageB = new Image(cheminB + nomB);
            ImageView iconeB = new ImageView(imageB);
            iconeB.setFitHeight(35);
            iconeB.setFitWidth(35);
            iconeB.setPreserveRatio(true);
            Button button = new Button(descrptionB, iconeB);
            button.setMinSize(45, 45);
            button.setTooltip(tooltip);

            return button;
    }
  
}
