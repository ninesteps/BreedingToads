/**
 * Created by tae on 5/16/14.
 */
public class Coordinate{
    double x, y;

    public Coordinate(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public String toString(){
        return "(" + x + "," + y + ")";
    }
}