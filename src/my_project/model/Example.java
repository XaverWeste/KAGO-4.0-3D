package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Example extends GraphicalObject {

    private double yRotation, zRotation;

    public Example(){
        yRotation= zRotation =0;
    }

    @Override
    public void draw(DrawTool d) {
        d.drawCube(100,100,75,0,-yRotation, zRotation);
        d.drawPyramid(200,200,75,45,yRotation,-zRotation);
    }

    @Override
    public void update(double dt) {
        yRotation= zRotation +=20*dt;
    }
}
