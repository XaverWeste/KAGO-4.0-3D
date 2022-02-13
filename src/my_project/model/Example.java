package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Example extends GraphicalObject {

    private double yRotation,zRoation;

    public Example(){
        yRotation=zRoation=0;
    }

    @Override
    public void draw(DrawTool d) {
        d.drawCube(100,100,50,0,yRotation,zRoation);
        d.drawPyramid(200,200,100,45,45,45);
    }

    @Override
    public void update(double dt) {
        yRotation=zRoation+=20*dt;
    }
}
