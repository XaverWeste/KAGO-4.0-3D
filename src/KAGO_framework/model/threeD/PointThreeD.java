package KAGO_framework.model.threeD;

public class PointThreeD {

    private double x,y,z;
    public double xOffset,yOffset,zOffset;

    /**
     * Punkt im drei dimensionalen Raum
     */
    public PointThreeD(double x,double y,double z){
        this.x=x;
        this.y=y;
        this.z=z;
        xOffset=0;
        yOffset=0;
        zOffset=0;
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getAdjustedX(){
        return x+xOffset;
    }

    public double getAdjustedY(){
        return y+yOffset;
    }

    public double getAdjustedZ(){
        return z+zOffset;
    }
}
