package KAGO_framework.model.threeD.entities;

import KAGO_framework.model.threeD.shapes.ThreeDObject;

import java.awt.*;
import java.util.ArrayList;

public class Entity {

    private ArrayList<ThreeDObject> objects;

    public Entity(ArrayList<ThreeDObject> objectList){
        objects=objectList;
    }

    public void draw(Graphics2D g){
        for(ThreeDObject value:objects){
            value.draw(g);
        }
    }

    public void rotate(boolean cW,double xDegrees,double yDegrees,double zDegrees){
        for(ThreeDObject value:objects){
            value.rotate(cW, xDegrees, yDegrees, zDegrees);
        }
    }

    public void translate(double x, double y, double z) {
        for(ThreeDObject value:objects){
            value.translate(x,y,z);
        }
    }
}
