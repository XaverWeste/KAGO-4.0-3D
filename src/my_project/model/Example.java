package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Example extends GraphicalObject {

    public Example(){

    }

    @Override
    public void draw(DrawTool d) {
        d.drawPyramid(200,200,100,0,45,45);
    }
}
