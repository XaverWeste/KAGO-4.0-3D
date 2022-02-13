package KAGO_framework.model.threeD.entities;

import java.awt.*;

public interface Entitize {

    void draw(Graphics2D g);

    void rotate(boolean cW,double xDegrees,double yDegrees,double zDegrees);
}
