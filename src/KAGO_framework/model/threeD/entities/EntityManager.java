package KAGO_framework.model.threeD.entities;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.threeD.Camera;
import KAGO_framework.view.DrawTool;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class EntityManager extends GraphicalObject {

    private ArrayList<Entity> entities;
    private Camera camera;

    public EntityManager(){
        entities=new ArrayList<>();
        camera=new Camera(0,0,0);
        add(EntityBuilder.createCube(300,300,100));
    }

    public void draw(DrawTool d){
        for(Entity value:entities){
            value.draw(d.getGraphics2D());
        }
    }

    public void add(Entity e){
        entities.add(e);
    }

    public void rotate(boolean cW,double xDegrees,double yDegrees,double zDegrees){
        for(Entity value:entities){
            value.rotate(cW,xDegrees,yDegrees,zDegrees);
        }
    }

    public void update(int key){
        switch(key){
            case KeyEvent.VK_W->{
                camera.translate(0,0,10);
                for(Entity value:entities){
                    value.translate(0,0,10);
                }
            }
            case KeyEvent.VK_A->{
                camera.translate(0,10,0);
                for(Entity value:entities){
                    value.translate(0,10,0);
                }
            }
            case KeyEvent.VK_S->{
                camera.translate(0,0,-10);
                for(Entity value:entities){
                    value.translate(0,0,-10);
                }
            }
            case KeyEvent.VK_D->{
                camera.translate(0,-10,0);
                for(Entity value:entities){
                    value.translate(0,-10,0);
                }
            }
            case KeyEvent.VK_Q->{
                camera.translate(10,0,0);
                for(Entity value:entities){
                    value.translate(10,0,0);
                }
            }
            case KeyEvent.VK_E->{
                camera.translate(-10,0,0);
                for(Entity value:entities){
                    value.translate(-10,0,0);
                }
            }
            case KeyEvent.VK_UP->rotate(true,0,10,0);
            case KeyEvent.VK_DOWN->rotate(true,0,-10,0);
            case KeyEvent.VK_LEFT->rotate(true,0,0,-10);
            case KeyEvent.VK_RIGHT->rotate(true,0,0,10);
        }
    }
}
