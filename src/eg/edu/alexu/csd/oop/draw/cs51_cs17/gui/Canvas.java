/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.draw.cs51_cs17.gui;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.cs51_cs17.DrawController;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author arabtech
 */
public class Canvas extends JPanel {

    DrawingEngine controller;

    public Canvas(DrawingEngine controller) {
        this.controller = controller;
    }

    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        controller.refresh(g);
        
    }
    
    

}
