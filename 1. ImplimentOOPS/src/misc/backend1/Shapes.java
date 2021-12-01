package misc.backend1;

public class Shapes {
double hight,length,width;


public Shapes(double hight, double length, double width) {
        this.hight = hight;
        this.length = length;
        this.width = width;
    }

    //rectangle
    public Shapes(double hight, double length) {
        this.hight = hight;
        this.length = length;
    }

    //circle
    public Shapes(double hight) {
        this.hight = hight;
    }


    public static double findArea(double hight, double length, double width){
        return hight*length*2+hight*width*2+width*length*2;
    }

    //circle area
    public static double findArea(double hight){
        return hight*hight*Math.PI;
    }

    //rect area
    public static double findArea(double length, double width){
        return length*length;
    }
}

