package KAGO_framework.model.threeD.shapes;

import KAGO_framework.model.threeD.PointConverter;
import KAGO_framework.model.threeD.PointThreeD;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolygonThreeD{

    private final PointThreeD[] points;
    private Color color;

    /**
     * Polygon im 3D Raum
     * @param color Die Farbe des Polygons
     * @param points Die Eckpunkte des Polygons
     */
    public PolygonThreeD(Color color,PointThreeD... points){
        this.points = new PointThreeD[points.length];
        for(int i=0;i< points.length;i++){
            PointThreeD p = points[i];
            this.points[i]=new PointThreeD(p.getX(),p.getY(),p.getZ());
        }
        this.color=color;
    }

    /**
     * Polygon im 3D Raum
     * @param points Die Eckpunkte des Polygons
     */
    public PolygonThreeD(PointThreeD... points){
        this.points = new PointThreeD[points.length];
        for(int i=0;i< points.length;i++){
            PointThreeD p = points[i];
            this.points[i]=new PointThreeD(p.getX(),p.getY(),p.getZ());
        }
        color=Color.RED;
    }

    /**
     * zeichnet das Polygon
     */
    public void draw(Graphics2D g,double x,double y){
        Polygon poly=new Polygon();
        for (PointThreeD point : points) {
            Point p = PointConverter.convertPoint(point);
            poly.addPoint((int) (p.x + x), (int) (p.y + y));
        }
        g.setColor(color);
        g.fillPolygon(poly);
    }

    /**
     * @return den durchschnitt der x Positionen der einzelnen Punkte des Polygons
     */
    public double getAverageX(){
        double sum=0;
        for(PointThreeD value:points){
            sum+=value.getX();
        }
        return sum/ points.length;
    }

    /**
     * rotiert das Polygon
     * @param cW Ob die Rotation im Uhrzeigersinn sein soll
     */
    public void rotate(boolean cW,double xDegrees,double yDegrees,double zDegrees){
        for(PointThreeD value:points){
            PointConverter.rotateAxisX(value,cW,xDegrees);
            PointConverter.rotateAxisY(value,cW,yDegrees);
            PointConverter.rotateAxisZ(value,cW,zDegrees);
        }
    }

    /**
     * verändert die Farbe des Polygons
     */
    public void setColor(Color color){
        this.color=color;
    }

    /**
     * sortiert ein Array von Polygonen, damit diese in der Richtigen Reihenfolge gezeichnet werden können
     */
    public static void sortPolygons(PolygonThreeD[] p){

        List<PolygonThreeD> polygonList = new ArrayList<>(Arrays.asList(p));

        polygonList.sort((p1, p2) -> p2.getAverageX() - p1.getAverageX() < 0 ? 1 : -1);

        for(int i=0;i<p.length;i++){
            p[i] = polygonList.get(i);
        }
    }

    public void translate(double x, double y, double z){
        for(PointThreeD value:points){
            value.xOffset+=x;
            value.yOffset+=y;
            value.zOffset+=z;
        }
    }

}
