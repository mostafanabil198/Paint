/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.draw.cs51_cs17.gui;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.draw.cs51_cs17.DrawController;
import eg.edu.alexu.csd.oop.draw.cs51_cs17.shapeHelpers.SelectShape;
import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author arabtech
 */
public class Paint extends javax.swing.JFrame {

    String shapeNameToDraw = "nth";
    String orderName = "nth";
    SelectShape selectShape = new SelectShape();
    GuiLogic guiLogic = new GuiLogic();
    DrawingEngine controller = new DrawController();
    Shape shape, selectedShape, selectedBorder, copiedShape;

    public void setSelectedShape(Shape selectedShape) {
        this.selectedShape = selectedShape;
    }
    double x1, y1, x2, y2, topleftX, topLeftY;
    Color fillColor, shapeColor;

    public Paint() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        fillColor = fillColorr.getBackground();
        shapeColor = borderColor.getBackground();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new Canvas(controller);
        jPanel2 = new javax.swing.JPanel();
        line = new javax.swing.JLabel();
        rightTriangle = new javax.swing.JLabel();
        rectangle = new javax.swing.JLabel();
        square = new javax.swing.JLabel();
        circle = new javax.swing.JLabel();
        ellipse = new javax.swing.JLabel();
        select = new javax.swing.JLabel();
        move = new javax.swing.JLabel();
        resize = new javax.swing.JLabel();
        delete = new javax.swing.JLabel();
        borderColor = new javax.swing.JLabel();
        fillColorr = new javax.swing.JLabel();
        eqTriangle = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        undo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        redo = new javax.swing.JLabel();
        save = new javax.swing.JLabel();
        load = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        line.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        line.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lineMouseClicked(evt);
            }
        });
        jPanel2.add(line, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 50, 50));

        rightTriangle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rightTriangle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rightTriangleMouseClicked(evt);
            }
        });
        jPanel2.add(rightTriangle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 70, 60));

        rectangle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rectangle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rectangleMouseClicked(evt);
            }
        });
        jPanel2.add(rectangle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 70, 50));

        square.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        square.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                squareMouseClicked(evt);
            }
        });
        jPanel2.add(square, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 50, 50));

        circle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        circle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                circleMouseClicked(evt);
            }
        });
        jPanel2.add(circle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 70, 60));

        ellipse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ellipse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ellipseMouseClicked(evt);
            }
        });
        jPanel2.add(ellipse, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 710, 70, 50));

        select.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectMouseClicked(evt);
            }
        });
        jPanel2.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 50, 60));

        move.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        move.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moveMouseClicked(evt);
            }
        });
        jPanel2.add(move, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 60, 70));

        resize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resizeMouseClicked(evt);
            }
        });
        jPanel2.add(resize, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 70, 60));

        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        jPanel2.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 780, 70, 70));

        borderColor.setBackground(new java.awt.Color(255, 255, 255));
        borderColor.setText("          ");
        borderColor.setOpaque(true);
        borderColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borderColorMouseClicked(evt);
            }
        });
        jPanel2.add(borderColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 930, 50, 50));

        fillColorr.setBackground(new java.awt.Color(0, 0, 0));
        fillColorr.setText("          ");
        fillColorr.setOpaque(true);
        fillColorr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fillColorrMouseClicked(evt);
            }
        });
        jPanel2.add(fillColorr, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 870, 50, 50));

        eqTriangle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eqTriangle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eqTriangleMouseClicked(evt);
            }
        });
        jPanel2.add(eqTriangle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 70, 60));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eg/edu/alexu/csd/oop/draw/cs51_cs17/gui/2222.png"))); // NOI18N
        jPanel2.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 1000));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Round Rectangle");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 120, 40));

        undo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        undo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                undoMouseClicked(evt);
            }
        });
        jPanel3.add(undo, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 90, 70));

        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 70, 70));

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 70, 70));

        redo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        redo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                redoMouseClicked(evt);
            }
        });
        jPanel3.add(redo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 20, 100, 70));

        save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });
        jPanel3.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 80, 70));

        load.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        load.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadMouseClicked(evt);
            }
        });
        jPanel3.add(load, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 70, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eg/edu/alexu/csd/oop/draw/cs51_cs17/gui/1212121.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lineMouseClicked
        orderName = "draw";
        shapeNameToDraw = "Line";
    }//GEN-LAST:event_lineMouseClicked

    private void rightTriangleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightTriangleMouseClicked
        orderName = "draw";
        shapeNameToDraw = "RightTriangle";
    }//GEN-LAST:event_rightTriangleMouseClicked

    private void rectangleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rectangleMouseClicked
        orderName = "draw";
        shapeNameToDraw = "Rectangle";
    }//GEN-LAST:event_rectangleMouseClicked

    private void squareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_squareMouseClicked
        orderName = "draw";
        shapeNameToDraw = "Square";

    }//GEN-LAST:event_squareMouseClicked

    private void circleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circleMouseClicked
        orderName = "draw";
        shapeNameToDraw = "Circle";
    }//GEN-LAST:event_circleMouseClicked

    private void ellipseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ellipseMouseClicked
        orderName = "draw";
        shapeNameToDraw = "Ellipse";

    }//GEN-LAST:event_ellipseMouseClicked

    private void selectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseClicked
        orderName = "select";
    }//GEN-LAST:event_selectMouseClicked

    private void moveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moveMouseClicked
        orderName = "move";
    }//GEN-LAST:event_moveMouseClicked

    private void resizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resizeMouseClicked
        orderName = "resize";
    }//GEN-LAST:event_resizeMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        if (selectedShape != null) {
            controller.removeShape(selectedShape);
            selectedShape = null;
            if (selecting != null) {
                controller.removeShape(selecting);
            }
            selecting = null;
            repaint();
        }
    }//GEN-LAST:event_deleteMouseClicked

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
        FileChooser fileChooser = new FileChooser();
        JFileChooser chooser = fileChooser.jFileChooser1;
        chooser.showSaveDialog(fileChooser);
        File f = chooser.getSelectedFile();
        controller.save(f.getPath());
        repaint();
    }//GEN-LAST:event_saveMouseClicked

    private void loadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadMouseClicked
        FileChooser fileChooser = new FileChooser();
        JFileChooser chooser = fileChooser.jFileChooser1;
        chooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("paint files", "xml", "json");
//        FileNameExtensionFilter filter1 = new FileNameExtensionFilter("json", "json");
        chooser.setFileFilter(filter);

        chooser.showOpenDialog(fileChooser);
        File f = chooser.getSelectedFile();
        if (f != null && !f.getName().isEmpty()) {
            controller.load(f.getPath());

            selectedShape = null;
            if (selecting != null) {
                controller.removeShape(selecting);
            }
            selecting = null;
        }
        repaint();
    }//GEN-LAST:event_loadMouseClicked

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        x1 = evt.getXOnScreen() - jPanel1.getX();
        y1 = evt.getYOnScreen() - jPanel1.getY() - 30;
        if (orderName.equals("draw")) {
            selectedShape = null;
            if (selecting != null) {
                controller.removeShape(selecting);
            }
            selecting = null;
            shape = guiLogic.generateShape(shapeNameToDraw);
            guiLogic.drawShapes(shape, x1, y1, x1, y1, shapeColor, fillColor);
            controller.addShape(shape);
            repaint();
        } else if (orderName.equals("move") && selectedShape != null && selectedShape != selecting) {
            try {
                guiLogic.moveShape(selectedShape, this, x1, y1, true, controller);
                selecting.setProperties(guiLogic.copyMape(selectedShape.getProperties()));
                if (!selecting.getClass().getSimpleName().contains("Triangle") && !selecting.getClass().getSimpleName().contains("Line")) {
                    selecting.getProperties().put("width", selectedShape.getProperties().get("width") + 5);
                    selecting.getProperties().put("height", selectedShape.getProperties().get("height") + 5);
                } else {
                    selecting.getProperties().put("point1X", selectedShape.getProperties().get("point1X") + 5);
                    selecting.getProperties().put("point1Y", selectedShape.getProperties().get("point1Y") - 5);
                    selecting.getProperties().put("point2X", selectedShape.getProperties().get("point2X") - 5);
                    selecting.getProperties().put("point2Y", selectedShape.getProperties().get("point2Y") + 5);
                    if (selecting.getClass().getSimpleName().contains("Triangle")) {
                        selecting.getProperties().put("point3X", selectedShape.getProperties().get("point3X") + 5);
                        selecting.getProperties().put("point3Y", selectedShape.getProperties().get("point3Y") + 5);
                    }
                }
                selecting.getProperties().put("fillColor", Double.parseDouble(String.valueOf(Integer.MAX_VALUE)));
                selecting.getProperties().put("shapeColor", Double.parseDouble(String.valueOf(Color.red.getRGB())));

            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
            }
            repaint();
        } else if (orderName.equals("resize") && selectedShape != null && selectedShape != selecting) {
            try {
                guiLogic.resizeShape(selectedShape, this, x1, y1, false, controller);
                selecting.setProperties(guiLogic.copyMape(selectedShape.getProperties()));
                if (!selecting.getClass().getSimpleName().contains("Triangle") && !selecting.getClass().getSimpleName().contains("Line")) {
                    selecting.getProperties().put("width", selectedShape.getProperties().get("width") + 5);
                    selecting.getProperties().put("height", selectedShape.getProperties().get("height") + 5);
                } else {
                    selecting.getProperties().put("point1X", selectedShape.getProperties().get("point1X") + 5);
                    selecting.getProperties().put("point1Y", selectedShape.getProperties().get("point1Y") - 5);
                    selecting.getProperties().put("point2X", selectedShape.getProperties().get("point2X") - 5);
                    selecting.getProperties().put("point2Y", selectedShape.getProperties().get("point2Y") + 5);
                    if (selecting.getClass().getSimpleName().contains("Triangle")) {
                        selecting.getProperties().put("point3X", selectedShape.getProperties().get("point3X") + 5);
                        selecting.getProperties().put("point3Y", selectedShape.getProperties().get("point3Y") + 5);
                    }
                }
                selecting.getProperties().put("fillColor", Double.parseDouble(String.valueOf(Integer.MAX_VALUE)));
                selecting.getProperties().put("shapeColor", Double.parseDouble(String.valueOf(Color.red.getRGB())));
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
            }
            repaint();
        }
    }//GEN-LAST:event_jPanel1MousePressed
    Shape selecting;
    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        double x3 = evt.getXOnScreen() - jPanel1.getX();
        double y3 = evt.getYOnScreen() - jPanel1.getY() - 30;
        if (orderName.equals("select")) {
            selectedShape = selectShape.selectShape(evt.getXOnScreen() - jPanel1.getX(), evt.getYOnScreen() - jPanel1.getY() - 30, controller.getShapes());
            if (selectedShape == null || selectedShape == selecting) {
                if (selecting != null) {
                    controller.removeShape(selecting);
                }
                selecting = null;
                selectedShape = null;
                repaint();
            } else {
//                selectedShape.getProperties().put("shapeColor", Double.parseDouble(String.valueOf((Color.BLUE).getRGB())));
//                selectedShape.getProperties().put("fillColor", Double.parseDouble(String.valueOf((Color.BLUE).getRGB())));
                if (selecting != null) {
                    controller.removeShape(selecting);
                    selecting = null;
                }
                selecting = guiLogic.generateShape(selectedShape.getClass().getSimpleName());
                selecting.setProperties(guiLogic.copyMape(selectedShape.getProperties()));
                if (!selecting.getClass().getSimpleName().contains("Triangle") && !selecting.getClass().getSimpleName().equals("Line")) {
                    selecting.getProperties().put("width", selectedShape.getProperties().get("width") + 5);
                    selecting.getProperties().put("height", selectedShape.getProperties().get("height") + 5);
                } else {
                    selecting.getProperties().put("point1X", selectedShape.getProperties().get("point1X") + 5);
                    selecting.getProperties().put("point1Y", selectedShape.getProperties().get("point1Y") - 5);
                    selecting.getProperties().put("point2X", selectedShape.getProperties().get("point2X") - 5);
                    selecting.getProperties().put("point2Y", selectedShape.getProperties().get("point2Y") + 5);
                    if (selecting.getClass().getSimpleName().contains("Triangle")) {
                        selecting.getProperties().put("point3X", selectedShape.getProperties().get("point3X") + 5);
                        selecting.getProperties().put("point3Y", selectedShape.getProperties().get("point3Y") + 5);
                    }
                }
                selecting.getProperties().put("fillColor", Double.parseDouble(String.valueOf(Integer.MAX_VALUE)));
                selecting.getProperties().put("shapeColor", Double.parseDouble(String.valueOf(Color.red.getRGB())));
                controller.addShape(selecting);
                repaint();
            }
        } else if (orderName.equals("paste")) {
            try {
                Shape pastedShape = (Shape) copiedShape.clone();
                controller.addShape(pastedShape);
                pastedShape.setPosition(new Point((int) x3, (int) y3));
                repaint();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        x2 = evt.getXOnScreen() - jPanel1.getX();
        y2 = evt.getYOnScreen() - jPanel1.getY() - 30;
        if (orderName.equals("draw")) {
            guiLogic.drawShapes(shape, x1, y1, x2, y2, shapeColor, fillColor);
            repaint();
        } else if (orderName.equals("move") && selectedShape != null && selectedShape != selecting) {
            try {
                guiLogic.moveShape(selectedShape, this, x2, y2, false, controller);
                selecting.setProperties(guiLogic.copyMape(selectedShape.getProperties()));
                if (!selecting.getClass().getSimpleName().contains("Triangle") && !selecting.getClass().getSimpleName().contains("Line")) {
                    selecting.getProperties().put("width", selectedShape.getProperties().get("width") + 5);
                    selecting.getProperties().put("height", selectedShape.getProperties().get("height") + 5);
                } else {
                    selecting.getProperties().put("point1X", selectedShape.getProperties().get("point1X") + 5);
                    selecting.getProperties().put("point1Y", selectedShape.getProperties().get("point1Y") - 5);
                    selecting.getProperties().put("point2X", selectedShape.getProperties().get("point2X") - 5);
                    selecting.getProperties().put("point2Y", selectedShape.getProperties().get("point2Y") + 5);
                    if (selecting.getClass().getSimpleName().contains("Triangle")) {
                        selecting.getProperties().put("point3X", selectedShape.getProperties().get("point3X") + 5);
                        selecting.getProperties().put("point3Y", selectedShape.getProperties().get("point3Y") + 5);
                    }
                }
                selecting.getProperties().put("fillColor", Double.parseDouble(String.valueOf(Integer.MAX_VALUE)));
                selecting.getProperties().put("shapeColor", Double.parseDouble(String.valueOf(Color.red.getRGB())));
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
            }
            repaint();
        } else if (orderName.equals("resize") && selectedShape != null && selectedShape != selecting) {
            try {
                guiLogic.resizeShape(selectedShape, this, x2, y2, true, controller);
                selecting.setProperties(guiLogic.copyMape(selectedShape.getProperties()));
                if (!selecting.getClass().getSimpleName().contains("Triangle") && !selecting.getClass().getSimpleName().contains("Line")) {
                    selecting.getProperties().put("width", selectedShape.getProperties().get("width") + 5);
                    selecting.getProperties().put("height", selectedShape.getProperties().get("height") + 5);
                } else {
                    selecting.getProperties().put("point1X", selectedShape.getProperties().get("point1X") + 5);
                    selecting.getProperties().put("point1Y", selectedShape.getProperties().get("point1Y") - 5);
                    selecting.getProperties().put("point2X", selectedShape.getProperties().get("point2X") - 5);
                    selecting.getProperties().put("point2Y", selectedShape.getProperties().get("point2Y") + 5);
                    if (selecting.getClass().getSimpleName().contains("Triangle")) {
                        selecting.getProperties().put("point3X", selectedShape.getProperties().get("point3X") + 5);
                        selecting.getProperties().put("point3Y", selectedShape.getProperties().get("point3Y") + 5);
                    }
                }
                selecting.getProperties().put("fillColor", Double.parseDouble(String.valueOf(Integer.MAX_VALUE)));
                selecting.getProperties().put("shapeColor", Double.parseDouble(String.valueOf(Color.red.getRGB())));
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
            }
            repaint();
        }
    }//GEN-LAST:event_jPanel1MouseDragged

    private void undoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_undoMouseClicked
        controller.undo();
        repaint();
    }//GEN-LAST:event_undoMouseClicked

    private void redoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redoMouseClicked
        controller.redo();
        repaint();
    }//GEN-LAST:event_redoMouseClicked

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
//        if (orderName.equals("move")) {
//            controller.updateShape(shape, selectedShape);
//        } else if (orderName.equals("resize")) {
//            controller.updateShape(shape, selectedShape);
//        }
    }//GEN-LAST:event_jPanel1MouseReleased

    private void fillColorrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fillColorrMouseClicked
        ColorChooser colorChooser = new ColorChooser();
        colorChooser.setVisible(true);
        colorChooser.setForm(this);
        colorChooser.setColorFor("fillColor");
    }//GEN-LAST:event_fillColorrMouseClicked

    private void borderColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borderColorMouseClicked
        ColorChooser colorChooser = new ColorChooser();
        colorChooser.setVisible(true);
        colorChooser.setForm(this);
        colorChooser.setColorFor("shapeColor");
    }//GEN-LAST:event_borderColorMouseClicked

    private void eqTriangleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eqTriangleMouseClicked
        orderName = "draw";
        shapeNameToDraw = "EquilateralTriangle";
        selectedShape = null;
    }//GEN-LAST:event_eqTriangleMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        if (selectedShape != null) {
            try {
                copiedShape = (Shape) selectedShape.clone();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        orderName = "paste";
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        for (Class<? extends Shape> classes : controller.getSupportedShapes()) {
            if (classes.getName().contains("Round")) {
                try {
                    Map<String, Double> properties = new HashMap<>();
                    properties.put("Length", 300.0);
                    properties.put("ArcWidth", 50.0);
                    properties.put("ArcLength", 50.0);
                    properties.put("Width", 300.0);
                    Constructor<?> ctor = classes.getConstructor();
                    Shape ob = (Shape) ctor.newInstance();
                    ob.setProperties(properties);
                    ob.setPosition(new Point(250, 250));
                    ob.setColor(shapeColor);
                    ob.setFillColor(fillColor);
                    controller.addShape(ob);
                    repaint();
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SecurityException ex) {
                    Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    public void setColorFor(String colorFor, Color color) throws CloneNotSupportedException {
        if (colorFor.equals("fillColor")) {
            fillColor = color;
            fillColorr.setBackground(color);
            if (selectedShape != null) {
                guiLogic.changeColor(selectedShape, this, true, controller, fillColor, new Color(selectedShape.getProperties().get("shapeColor").intValue()));
                selectedShape.getProperties().put("fillColor", Double.parseDouble(String.valueOf((fillColor).getRGB())));
                repaint();
            }
        } else if (colorFor.equals("shapeColor")) {
            shapeColor = color;
            borderColor.setBackground(color);
            if (selectedShape != null) {
                guiLogic.changeColor(selectedShape, this, true, controller, new Color(selectedShape.getProperties().get("fillColor").intValue()), shapeColor);
                selectedShape.getProperties().put("shapeColor", Double.parseDouble(String.valueOf((shapeColor).getRGB())));
                repaint();
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Paint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel borderColor;
    private javax.swing.JLabel circle;
    private javax.swing.JLabel delete;
    private javax.swing.JLabel ellipse;
    private javax.swing.JLabel eqTriangle;
    private javax.swing.JLabel fillColorr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel line;
    private javax.swing.JLabel load;
    private javax.swing.JLabel move;
    private javax.swing.JLabel rectangle;
    private javax.swing.JLabel redo;
    private javax.swing.JLabel resize;
    private javax.swing.JLabel rightTriangle;
    private javax.swing.JLabel save;
    private javax.swing.JLabel select;
    private javax.swing.JLabel square;
    private javax.swing.JLabel undo;
    // End of variables declaration//GEN-END:variables
}
