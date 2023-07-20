/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.idmont.candw.serpentdeferproject;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author patrick
 */
public class CreationZone extends Pane {
    Canvas canvas;
    InterfaceBody main;
    
    public CreationZone(InterfaceBody main){
        
        this.main=main;
        this.canvas= new Canvas(this.getWidth(),this.getHeight());
        this.getChildren().add(canvas);
        this.canvas.widthProperty().bind(this.widthProperty());
        this.canvas.widthProperty().addListener((o)->{
            this.drawCanvas();
        });
        
        this.canvas.heightProperty().bind(this.heightProperty());
        this.canvas.heightProperty().addListener((o)->{
            this.drawCanvas();
        });
        
    }

    private void drawCanvas() {
        GraphicsContext context = this.canvas.getGraphicsContext2D();
        context.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
        context.setFill(Color.valueOf("#45f0f0"));
        context.fillRect(0, 0,this.canvas.getWidth(), this.canvas.getHeight());
    }
    
}
