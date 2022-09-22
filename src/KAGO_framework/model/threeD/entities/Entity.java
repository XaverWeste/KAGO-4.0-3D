package KAGO_framework.model.threeD.entities;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.threeD.shapes.ThreeDObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;
import java.util.ArrayList;

public class Entity extends GraphicalObject {

    private final ArrayList<ThreeDObject> objects;

    public Entity(ArrayList<ThreeDObject> objectList){
        objects=objectList;
    }

    public void draw(DrawTool d){
        Graphics2D g=d.getGraphics2D();
        for(ThreeDObject value:objects) value.draw(g);
    }

    public void rotate(boolean cW,double xDegrees,double yDegrees,double zDegrees){
        for(ThreeDObject value:objects) value.rotate(cW, xDegrees, yDegrees, zDegrees);
    }

    public void rotateAround(double x,double y,double z,boolean cW,double xDegrees,double yDegrees,double zDegrees){
        for(ThreeDObject value:objects) value.rotateAround(x,y,z,cW, xDegrees, yDegrees, zDegrees);
    }

    public void translate(double x, double y, double z) {
        for(ThreeDObject value:objects) value.translate(x,y,z);
    }
}
