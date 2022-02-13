package KAGO_framework.model.threeD.entities;

import KAGO_framework.model.threeD.Camera;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {

    private ArrayList<Entitize> entities;
    private Camera camera;

    public EntityManager(){
        entities=new ArrayList<>();
        camera=new Camera(0,0,0);
    }

    public void draw(Graphics2D g){
        for(Entitize value:entities){
            value.draw(g);
        }
    }

    public void add(Entitize e){
        entities.add(e);
    }

    public void rotate(boolean cW,double xDegrees,double yDegrees,double zDegrees){
        for(Entitize value:entities){
            value.rotate(cW,xDegrees,yDegrees,zDegrees);
        }
    }
}
