package KAGO_framework.model.threeD.entities;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {

    private ArrayList<Entitize> entities;

    public EntityManager(){

    }

    public void draw(Graphics2D g){
        for(Entitize value:entities){
            value.draw(g);
        }
    }
}
