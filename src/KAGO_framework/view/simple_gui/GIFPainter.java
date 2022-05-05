package KAGO_framework.view.simple_gui;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Dient zur Anzeige eines .gif-Bildes, das auch animiert sein kann.
 * Das Objekt kann beliebig viele .gif-Dateien verwalten, die auf Wunsch jeweils
 * gewechselt werden können.
 */
public class GIFPainter extends GraphicalObject {

    private ArrayList<ImageIcon> images;
    private int amount;

    /**
     * Erzeugt ein neues Objekt zur Anzeige eines GIF
     * @param imagePath der relative Pfad zur Bilddatei
     * @param x die x-Koordinate der oberen linken Ecke
     * @param y die y-Koordinate der oberen linken Ecke
     */
    public GIFPainter(String imagePath, double x, double y){
        images = new ArrayList<>();
        addImage(imagePath);
        this.x = x;
        this.y = y;
    }

    /**
     * Fügt den anzeigbaren Bildern des Objekts eines hinzu
     * @param imagePath der Pfad zum zu ergänzenden GIF
     */
    public void addImage(String imagePath){
        images.add(new ImageIcon(imagePath));
        amount++;
    }

    /**
     * Ändert die Anzeige auf ein anderes GIF des Objekts
     * @param i der Index des GIFs
     */
    public void setImageByIndex(int i){
        amount=i;
    }

    @Override
    public void draw(DrawTool drawTool) {
        images.get(amount).paintIcon(drawTool.getParent(), drawTool.getGraphics2D(), (int)x, (int)y);
    }

    @Override
    public void update(double dt) {

    }
}
