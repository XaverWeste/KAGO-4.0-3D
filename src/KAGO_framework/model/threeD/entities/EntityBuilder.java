package KAGO_framework.model.threeD.entities;

import KAGO_framework.model.threeD.PointThreeD;
import KAGO_framework.model.threeD.PolygonThreeD;
import KAGO_framework.model.threeD.ThreeDObject;

import java.awt.*;
import java.util.ArrayList;

public class EntityBuilder {

    public static Entity createCube(double x,double y,double size){
        PointThreeD p1=new PointThreeD(size/2,-size/2,-size/2);
        PointThreeD p2=new PointThreeD(size/2,size/2,-size/2);
        PointThreeD p3=new PointThreeD(size/2,size/2,size/2);
        PointThreeD p4=new PointThreeD(size/2,-size/2,size/2);
        PointThreeD p5=new PointThreeD(-size/2,-size/2,-size/2);
        PointThreeD p6=new PointThreeD(-size/2,size/2,-size/2);
        PointThreeD p7=new PointThreeD(-size/2,size/2,size/2);
        PointThreeD p8=new PointThreeD(-size/2,-size/2,size/2);
        ThreeDObject t=new ThreeDObject(
                x,
                y,
                new PolygonThreeD(Color.DARK_GRAY,p5,p6,p7,p8),
                new PolygonThreeD(Color.BLUE,p1,p2,p6,p5),
                new PolygonThreeD(Color.YELLOW,p1,p4,p8,p5),
                new PolygonThreeD(Color.GREEN,p2,p6,p7,p3),
                new PolygonThreeD(Color.ORANGE,p4,p3,p7,p8),
                new PolygonThreeD(Color.RED,p1,p2,p3,p4)
        );
        return new Entity(new ArrayList<>(){{ add(t); }});
    }

    public static Entity createPyramid(double x,double y,double size){
        PointThreeD p1=new PointThreeD(size/2,-size/2,size/2);
        PointThreeD p2=new PointThreeD(size/2,size/2,size/2);
        PointThreeD p3=new PointThreeD(-size/2,size/2,size/2);
        PointThreeD p4=new PointThreeD(-size/2,-size/2,size/2);
        PointThreeD p5=new PointThreeD(0,0,-size/2);
        ThreeDObject t=new ThreeDObject(
                x,
                y,
                new PolygonThreeD(Color.YELLOW,p1,p2,p3,p4),
                new PolygonThreeD(Color.RED,p1,p2,p5),
                new PolygonThreeD(Color.GREEN,p2,p3,p5),
                new PolygonThreeD(Color.YELLOW,p3,p4,p5),
                new PolygonThreeD(Color.BLUE,p4,p1,p5)
        );
        return new Entity(new ArrayList<>(){{ add(t); }});
    }
}
