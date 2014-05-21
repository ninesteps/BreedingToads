import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tae on 5/16/14.
 *
 * read the toads
 * set the radius to be very large
 * for each set of 3 toads
 *  if they are in a straight line
 *      let C be the circle containing the bounding box
 *  else
 *      let C be the circle passing through those toads' locations
 *  if the radius of C < the radius so far
 *      count the toads on or in C, stopping early if there are at least 16
 *  if there are at least 16,
 *      set the radius to be the radius of C
 *
 */
public class BreedingToads {
    static ArrayList<Point> toads = new ArrayList<Point>();
    static double triarea, r = 30000; //Radius, set to initially be very large
    static int x1, y1, x2, y2, rectarea, t1x, t2x, t3x, t1y, t2y, t3y;
    static Ellipse2D C;




    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            toads.add(new Point(sc.nextInt(),sc.nextInt()));
        }

        //for every set of 3 toads
        for (int t1 = 0; t1 < toads.size()-2; t1++){
            for (int t2 = t1+1; t2 < toads.size()-1; t2++){
                for (int t3 = t2+1; t3 < toads.size(); t3++){

                    t1x = (int) toads.get(t1).getX();
                    t2x = (int) toads.get(t2).getX();
                    t3x = (int) toads.get(t3).getX();

                    t1y = (int) toads.get(t1).getY();
                    t2y = (int) toads.get(t2).getY();
                    t3y = (int) toads.get(t3).getY();

                    x1 = Math.min(t1x, Math.min(t2x,t3x));
                    y1 = Math.min(t1y, Math.min(t2y,t3y));
                    x2 = Math.max(t1x, Math.max(t2x, t3x));
                    y2 = Math.max(t1y, Math.max(t2y, t3y));

                    Rectangle rect = new Rectangle(x1, y1, x2-x1, y2-y1);

                    rectarea = (x2-x1) * (y2-y1);
                    triarea = Math.abs(((t1x * (t2y - t3y) + t2x * (t3y - t1y) + t3x * (t1y - t2y)) / 2));
                    
                    if(triarea == 0){
                        // let C be the circle containing rect
                        double radius = 0.5 * Math.hypot(x2 - x1, y2 - y1);
                        C = new Ellipse2D.Double((x2-x1)/2 - radius, (y2-y1)/2 - radius,radius*2,radius*2);
                    } else {
                        // let C be the circle passing through toads location
                        
                    }






                }
            }
        }

    }
}
