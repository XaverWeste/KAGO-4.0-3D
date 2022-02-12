package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class House extends GraphicalObject {

    public House(){

    }

    @Override
    public void draw(DrawTool d) {
        d.drawCube(200,200,100,20,30,40);
    }
}
