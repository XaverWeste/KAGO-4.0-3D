package my_project;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Beispiel extends GraphicalObject {

    private double xd,yd,zd;

    public void draw(DrawTool d){
        d.drawCube(100,100,50,xd,yd,zd);
        d.drawPyramid(300,300,50,xd,-yd,-zd);
    }

    public void update(double dt){
        xd+=20*dt;
        yd+=20*dt;
        zd+=20*dt;
    }
}
