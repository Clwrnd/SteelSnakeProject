/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.idmont.candw.serpentdeferproject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.input.*;
import javafx.scene.text.Text;
import javafx.util.Duration;

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
        NewWindow.openNewWindow();
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
    
    void reseau(ActionEvent e){
        this.view.newwindows.openReseauWindow();       
    }
    
    void ligne(ActionEvent e){
        NewWindow.openLigneWindow();
    }
    
    void arret(ActionEvent e){
        NewWindow.openArretWindow();
    }
    
    void tram(ActionEvent e){
        NewWindow.openTramWindow();
    }

    void ClicInZone(MouseEvent e) {
        if(e.getButton()== MouseButton.SECONDARY){
            this.view.contextmenu.show(view.getScene().getWindow(),e.getScreenX(),e.getScreenY());
        }
        
    }
    
    void heure(Text dh) {
        Timeline tl= new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    dh.setText(formatter.format(LocalDateTime.now()));;
                }
            }));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();
    }


    


    
}
