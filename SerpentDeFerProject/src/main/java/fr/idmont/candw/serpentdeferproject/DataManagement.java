/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.idmont.candw.serpentdeferproject;

import Modele.Event;
import Modele.Line;
import Modele.Network;
import Modele.Tram;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cidmo
 */
public class DataManagement {
    Network Dreseau;
    List<Line> Dligne;
    List<Event> Devenem;
    List<Tram> Dtram;
    
    
    public DataManagement(){
    this.Devenem = new ArrayList<Event>();
    this.Dligne = new ArrayList<Line>();
    this.Dtram = new ArrayList<Tram>();
    this.Dreseau = new Network();
    }
    
}
