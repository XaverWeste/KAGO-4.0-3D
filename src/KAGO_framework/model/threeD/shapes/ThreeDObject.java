package KAGO_framework.model.threeD.shapes;

import KAGO_framework.model.threeD.shapes.PolygonThreeD;

import java.awt.*;

public class ThreeDObject {

    private final PolygonThreeD[] polygons;
    private Color color;
    private final double x,y;

    public ThreeDObject(Color color, double x, double y, PolygonThreeD... polygons){
        this.color=color;
        this.x=x;
        this.y=y;
        this.polygons=polygons;
        setColor(this.color);
    }

    public ThreeDObject(double x, double y, PolygonThreeD... polygons){
        this.x=x;
        this.y=y;
        this.polygons=polygons;
    }

    /**
     * zeichnet die einzelnen Polygone
     */
    public void draw(Graphics2D g) {
        for(PolygonThreeD value:polygons){
            value.draw(g,x,y);
        }
    }

    /**
     * dreht alle Polygone
     * @param cW ob im Uhrzeigersinn gedreht wird
     */
    public void rotate(boolean cW,double xDegrees,double yDegrees,double zDegrees){
        for(PolygonThreeD value:polygons){
            value.rotate(cW, xDegrees, yDegrees, zDegrees);
        }
        sortPolygons();
    }

    /**
     * sortiert die Polygone damit diese in der richtigen Reihenfolge gezeichnet werden können
     */
    private void sortPolygons(){
        PolygonThreeD.sortPolygons(polygons);
    }

    public void translate(double x, double y, double z){
        for(PolygonThreeD value:polygons){
            value.translate(x,y,z);
        }
    }

    /**
     * verändert die Farbe alle Polygone
     */
    public void setColor(Color color){
        for(PolygonThreeD value:polygons){
            value.setColor(color);
        }
    }
}
