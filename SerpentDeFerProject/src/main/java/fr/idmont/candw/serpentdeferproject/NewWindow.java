/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.idmont.candw.serpentdeferproject;

import javafx.scene.shape.*;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author clara
 */
public class NewWindow extends Stage {
    
    TextField textFieldNomReseau;
    TextField textFieldNomLigne ;
    TextField textFieldNomArret ;
    Stage stageReseau ;
    Stage stageLigne ;
    Stage stageArret ;
            
    public NewWindow(){
          
    }
    
    public static void openNewWindow(){
         int compteurWindow ;
         
         List<Window> open = Stage.getWindows();
         if (open.size()!=1){
            compteurWindow = open.size()+1 ;  
         } else
         {
            compteurWindow = 2;
         }
         
         StackPane secondWindow = new StackPane();
         Stage stage = new Stage();
         secondWindow.getChildren().add(new InterfaceBody(stage));
         
         Scene secondScene = new Scene(secondWindow, 500, 500);
         
         Stage secondStage = new Stage();
         secondStage.setTitle("Serpent de Fer " + compteurWindow);
         secondStage.getIcons().add(new Image("file:src\\main\\java\\fr\\idmont\\candw\\serpentdeferproject\\Icônes\\logo.png"));
         secondStage.setScene(secondScene);
         
         secondStage.setX(stage.getX() + 200);
         secondStage.setY(stage.getY() + 200);
         secondStage.show();
    }
    
    public  void openReseauWindow(){
             
        Image imageReseau = new Image("file:src\\main\\java\\fr\\idmont\\candw\\serpentdeferproject\\Icônes\\reseau.png");
        Circle cercleReseau = new Circle(200,200,75);
        cercleReseau.setStroke(Color.DARKGREY);
        cercleReseau.setFill(new ImagePattern(imageReseau));
        cercleReseau.setEffect(new DropShadow(+25d, 0d, +2d,Color.DARKGREY));
        
        Label labelReseau = new Label("Réseau");
        Label labelVille = new Label("Ville");
        this.textFieldNomReseau = new TextField();
        textFieldNomReseau.setPromptText("Entrez le nom de la ville");
        textFieldNomReseau.setFocusTraversable(false);
        
        Button btnOkReseau = new Button("OK");
        Separator separatorReseau = new Separator();
        Button btnAnnulReseau = new Button("Annuler");
        
        HBox hBoxLabel = new HBox(labelVille);
        VBox vBoxReseau = new VBox(cercleReseau,labelReseau,hBoxLabel,textFieldNomReseau, 
                btnOkReseau,separatorReseau, btnAnnulReseau);
        vBoxReseau.setAlignment(Pos.CENTER);
        vBoxReseau.setMaxSize(400, 450);
        StackPane reseauWindow = new StackPane(vBoxReseau);
        
        Scene sceneReseau = new Scene(reseauWindow, 450,500);
        this.stageReseau = new Stage();
        this.stageReseau.setTitle("Créer un réseau");
        this.stageReseau.getIcons().add(new Image("file:src\\main\\java\\fr\\idmont\\candw\\serpentdeferproject\\Icônes\\reseau.png"));
        this.stageReseau.setScene(sceneReseau);
        this.stageReseau.show();
        
        btnOkReseau.setOnAction((e)->{
            this.stageReseau.close();
        });
    }
    
    public void openLigneWindow(){
        
        Rectangle rect = new Rectangle();
        rect.setWidth(50);
        rect.setHeight(5);
        
        Image imageLigne = new Image("file:src\\main\\java\\fr\\idmont\\candw\\serpentdeferproject\\Icônes\\ligne.png");
        Circle cercleLigne = new Circle(200,200,75);
        cercleLigne.setStroke(Color.DARKGREY);
        cercleLigne.setFill(new ImagePattern(imageLigne));
        cercleLigne.setEffect(new DropShadow(+25d, 0d, +2d,Color.DARKGREY));
        
        Label labelLigne = new Label("Ligne");
        Label labelNomLigne = new Label("Nom de la ligne");
        this.textFieldNomLigne = new TextField();
        textFieldNomLigne.setPromptText("Entrez le nom de la ligne (A, B, C,... ou 1,2,3,...)");
        textFieldNomLigne.setFocusTraversable(false);
        Label labelCouleurLigne = new Label("Couleur de la ligne");
        ColorPicker colorPicker = new ColorPicker();
        Label labelDepartLigne = new Label("Nom du terminus 1");
        TextField textFieldDepartLigne = new TextField();
        textFieldDepartLigne.setPromptText("Entrez le nom du terminus 1");
        textFieldDepartLigne.setFocusTraversable(false);
        Label labelArriveeLigne = new Label("Nom du terminus 2");
        TextField textFieldArriveeLigne = new TextField();
        textFieldArriveeLigne.setPromptText("Entrez le nom du terminus 2");
        textFieldArriveeLigne.setFocusTraversable(false);
        
        Button btnOkLigne = new Button("OK");
        Separator separatorLigne = new Separator();
        Button btnAnnulLigne = new Button("Annuler");
        
        HBox color = new HBox(colorPicker,rect);        
        VBox vBoxLigne = new VBox(cercleLigne,labelLigne,labelNomLigne,textFieldNomLigne,
                labelCouleurLigne, color,labelDepartLigne,textFieldDepartLigne,
                labelArriveeLigne,textFieldArriveeLigne,btnOkLigne,separatorLigne,btnAnnulLigne);
        rect.setTranslateY(10);
        vBoxLigne.setAlignment(Pos.CENTER);
        vBoxLigne.setMaxSize(400, 450);
        StackPane ligneWindow = new StackPane(vBoxLigne);
        
        Scene sceneLigne = new Scene(ligneWindow, 450,500);
        this.stageLigne = new Stage();
        stageLigne.setTitle("Ajouter une ligne");
        stageLigne.getIcons().add(new Image("file:src\\main\\java\\fr\\idmont\\candw\\serpentdeferproject\\Icônes\\ligne.png"));
        stageLigne.setScene(sceneLigne);
        stageLigne.show();
        
        colorPicker.setOnAction((e)->{
            rect.setFill(colorPicker.getValue());
        });
    }
    
    public void openArretWindow(){
        
        Image imageArret = new Image("file:src\\main\\java\\fr\\idmont\\candw\\serpentdeferproject\\Icônes\\arret.png");
        Circle cercleArret = new Circle(200,200,75);
        cercleArret.setStroke(Color.DARKGREY);
        cercleArret.setFill(new ImagePattern(imageArret));
        cercleArret.setEffect(new DropShadow(+25d, 0d, +2d,Color.DARKGREY));
        
        Label labelArret = new Label("Arrêt");
        Label labelNomArret = new Label("Nom de l'arrêt");
        this.textFieldNomArret = new TextField();
        textFieldNomArret.setPromptText("Entrez le nom de l'arrêt");
        textFieldNomArret.setFocusTraversable(false);
        
        Button btnOkArret = new Button("OK");
        Separator separatorArret = new Separator();
        Button btnAnnulArret = new Button("Annuler");
        
        VBox vBoxArret = new VBox(cercleArret,labelArret,labelNomArret,textFieldNomArret,
                btnOkArret,separatorArret,btnAnnulArret);
        vBoxArret.setAlignment(Pos.CENTER);
        vBoxArret.setMaxSize(400, 450);
        StackPane arretWindow = new StackPane(vBoxArret);
        
        Scene sceneArret = new Scene(arretWindow, 450,500);
        this.stageArret = new Stage();
        stageArret.setTitle("Ajouter un arrêt");
        stageArret.getIcons().add(new Image("file:src\\main\\java\\fr\\idmont\\candw\\serpentdeferproject\\Icônes\\arret.png"));
        stageArret.setScene(sceneArret);
        stageArret.show();
        
    }
    
    public static void openTramWindow(){
        
        Image imageTram = new Image("file:src\\main\\java\\fr\\idmont\\candw\\serpentdeferproject\\Icônes\\tram.png");
        Circle cercleTram = new Circle(200,200,75);
        cercleTram.setStroke(Color.DARKGREY);
        cercleTram.setFill(new ImagePattern(imageTram));
        cercleTram.setEffect(new DropShadow(+25d, 0d, +2d,Color.DARKGREY));
        
        VBox vBoxTram = new VBox(cercleTram);
        vBoxTram.setAlignment(Pos.CENTER);
        vBoxTram.setMaxSize(400, 450);
        StackPane tramWindow = new StackPane(vBoxTram);
        
        Scene sceneTram = new Scene(tramWindow, 450,500);
        Stage stageTram = new Stage();
        stageTram.setTitle("Ajouter un tram");
        stageTram.getIcons().add(new Image("file:src\\main\\java\\fr\\idmont\\candw\\serpentdeferproject\\Icônes\\tram.png"));
        stageTram.setScene(sceneTram);
        stageTram.show();
        
    }
    
}
