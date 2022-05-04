package KAGO_framework.model.threeD.entities;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.threeD.Camera;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class EntityManager extends GraphicalObject {

    private final ArrayList<Entity> entities;
    private final Camera camera;

    public EntityManager(){
        entities=new ArrayList<>();
        camera=new Camera(0,0,0);
        //add(EntityBuilder.createCube(300,300,100,0,0,0));
        //add(EntityBuilder.createDiamond(100,100,50,10,0.9));
    }

    public void draw(DrawTool d){
        for(Entity value:entities){
            value.draw(d.getGraphics2D());
        }
    }

    public void add(Entity e){
        entities.add(e);
    }

    public void update(int key){
        if(Config.USE_CAMERA) {
            switch (key) {
                case KeyEvent.VK_S -> {
                    camera.translate(0, 0, 10);
                    for (Entity value : entities) {
                        value.translate(0, 0, 10);
                    }
                }
                case KeyEvent.VK_D -> {
                    camera.translate(0, 10, 0);
                    for (Entity value : entities) {
                        value.translate(0, 10, 0);
                    }
                }
                case KeyEvent.VK_W -> {
                    camera.translate(0, 0, -10);
                    for (Entity value : entities) {
                        value.translate(0, 0, -10);
                    }
                }
                case KeyEvent.VK_A -> {
                    camera.translate(0, -10, 0);
                    for (Entity value : entities) {
                        value.translate(0, -10, 0);
                    }
                }
                case KeyEvent.VK_Q -> {
                    for (Entity value : entities) {
                        value.rotateAround(camera.getX(),camera.getY(),camera.getZ(),false,0, 0, 10);
                    }
                }
                case KeyEvent.VK_E -> {
                    for (Entity value : entities) {
                        value.rotateAround(camera.getX(),camera.getY(),camera.getZ(),true,0, 0, -10);
                    }
                }
                case KeyEvent.VK_R -> {
                    camera.translate(10, 0, 0);
                    for (Entity value : entities) {
                        value.translate(10, 0, 0);
                    }
                }
                case KeyEvent.VK_F -> {
                    camera.translate(-10, 0, 0);
                    for (Entity value : entities) {
                        value.translate(-10,0, 0);
                    }
                }
            }
        }
    }
}
