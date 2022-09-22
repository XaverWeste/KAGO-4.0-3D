package KAGO_framework.model;

import KAGO_framework.Config;
import KAGO_framework.view.DrawTool;
import KAGO_framework.control.Drawable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Zur Vererbung. Methoden können nach Bedarf überschrieben werden.
 * Vorgegebene Klasse des Frameworks. Modifikation auf eigene Gefahr.
 */
public class GraphicalObject implements Drawable {

    protected double x = 0, y = 0;
    protected double width = 0, height = 0;
    protected double radius = 0;
    private BufferedImage myImage;

    /**
     * Der generische Konstruktur ermöglicht einen optionalen super-Aufruf in den Unterklassen
     */
    public GraphicalObject(){

    }

    /**
     * Mit diesem Konstruktor kann direkt ein GraphicalObject mit Bild und grundlegenden Methoden
     * verwendet werden.
     * @param picturePath der Pfad zur Bilddatei
     */
    public GraphicalObject(String picturePath){
        this.setNewImage(picturePath);
    }

    /**
     * Mit diesem Konstruktor kann direkt ein GraphicalObject mit Bild und grundlegenden Methoden
     * verwendet werden. Zudem kann es positioniert werden.
     * @param x die x-Koordinate (obere linke Ecke)
     * @param y die y-Koordinate (obere linke Ecke)
     */
    public GraphicalObject(String picturePath, double x, double y){
        this.x = x;
        this.y = y;
        this.setNewImage(picturePath);
    }

    /**
     * Lädt ein Bild, das zur Repräsentation des Objekts benutzt werden kann.
     * Passt automatisch die Attribute für Breite und Höhe der des Bildes an.
     * @param pathToImage Der Pfad zu dem zu ladenden Bild
     */
    public BufferedImage createImage(String pathToImage){
        BufferedImage tmpImage = null;
        try{
            tmpImage = ImageIO.read(new File(pathToImage));
        }catch (IOException e) {
            if ( Config.INFO_MESSAGES) System.out.println("Laden eines Bildes fehlgeschlagen: "+pathToImage+"\n Hast du den Pfad und Dateinamen richtig geschrieben?");
        }
        return tmpImage;
    }

    /**
     * Lädt ein neues Bild und setzt es als aktuelles Bild
     * @param pathToImage Der Pfad zu dem zu ladenden Bild
     */
    public void setNewImage(String pathToImage){
        try {
            myImage = ImageIO.read(new File(pathToImage));
            width = myImage.getWidth();
            height = myImage.getHeight();
        }catch (IOException e){
            if (Config.INFO_MESSAGES) System.out.println("Laden eines Bildes fehlgeschlagen: " + pathToImage);
        }
    }

    /**
     * Setzt ein BufferedImage als neues Bild, passt width und height des Objekts an die Bilddimension an
     * @param image Der Pfad zu dem zu ladenden Bild
     */
    public void setImage(BufferedImage image) {
        this.myImage = image;
        width = this.myImage.getWidth();
        height = this.myImage.getHeight();
    }

    @Override
    public void draw(DrawTool drawTool){
        if(getMyImage() != null) drawTool.drawImage(getMyImage(),x,y);
    }

    @Override
    public void update(double dt){

    }

    /**
     * Überprüft, ob das übergebene Objekt mit diesem GraphicalObject kollidiert (Rechteckkollision). Dabei werden die Koordinaten und
     * die Breite und Höhe des Objekts berücksichtigt.
     * @param gO Das Objekt, das auf Kollision überprüft wird
     * @return True, falls eine Kollision besteht, sonst false.
     */
    public boolean collidesWith(GraphicalObject gO){
        if(radius == 0){
            if(gO.getRadius() == 0) return x < gO.getX() + gO.getWidth() && x + width > gO.getX() && y < gO.getY() + gO.getHeight() && y + height > gO.getY();
            else return x < gO.getX() + 2 * gO.getRadius() && x + width > gO.getX() && y < gO.getY() + 2 * gO.getRadius() && y + height > gO.getY();
        }else{
            if(gO.getRadius() == 0) return gO.getX() < x + 2 * radius && gO.getX() + gO.getWidth() > x && gO.getY() < y + 2 * radius && gO.getY() + gO.getHeight() > y;
            else return getDistanceTo(gO) <= radius + gO.getRadius();
        }
    }

    /**
     * Prüft, ob ein Punkt innerhalb des GraphicalObjects liegt. Dazu müssen x,y,width und height vom
     * GraphicalObject gesetzt sein (passiert bei Bildzuweisung automatisch)
     * @param pX die x-Koordinate des Punktes
     * @param pY die y-Koordinate des Punktes
     * @return true, falls der Punkt im Objekt liegt, sonst false
     */
    public boolean collidesWith(double pX, double pY){
        if(radius == 0) return pX < getX() + getWidth() && pX > getX() && pY < getY() + getHeight() && pY > getY();
        else{
            double midX = x + radius;
            double midY = y + radius;
            return Math.sqrt(Math.pow(midX - pX, 2) + Math.pow(midY - pY, 2)) < radius;
        }
    }

    /**
     * Berechnet die Distanz zwischen dem Mittelpunkt dieses Objekts und dem Mittelpunkt des übergebenen Objekts.
     * @param gO Das Objekt zu dem die Entfernung gemessen wird.
     * @return Die exakte Entfernung zwischen den Mittelpunkten
     */
    public double getDistanceTo(GraphicalObject gO){
        double midX, midY;
        if(radius == 0){
            midX = x + width/2;
            midY = y + height/2;
        }else{
            midX = x + radius;
            midY = y+ radius;
        }

        double midX2, midY2;
        if(gO.getRadius() == 0){
            midX2 = gO.getX() + gO.getWidth()/2;
            midY2 = gO.getY() + gO.getHeight()/2;
        }else{
            midX2 = gO.getX() + gO.getRadius();
            midY2 = gO.getY() + gO.getRadius();
        }

        return Math.sqrt( Math.pow(midX-midX2, 2) + Math.pow(midY-midY2,2));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getRadius(){
        return radius;
    }

    public BufferedImage getMyImage() {
        return myImage;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

}
