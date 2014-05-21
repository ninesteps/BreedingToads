import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tae on 5/16/14.
 *
 * read the toads
 * set the radius to be very large
 * for each set of 3 toads
 * if they are in a straight line
 * let C be the circle containing the bounding box
 * else
 * let C be the circle passing through those toads' locations
 * if the radius of C < the radius so far
 * count the toads on or in C, stopping early if there are at least 16
 * if there are at least 16,
 * set the radius to be the radius of C
 */
public class BreedingToads {
    static ArrayList<Point> toads = new ArrayList<Point>();
    static double radius, cx, cy, ma, mb, triarea, r = 30000; //Radius, set to initially be very large
    static int x1, y1, x2, y2, rectarea, t1x, t2x, t3x, t1y, t2y, t3y, count;
    static Ellipse2D C;


    private static Ellipse2D circleByCenterRadius(double x, double y, double rad) {
        //creates Circle a tiny bit bigger for edge calculation
        rad = rad + 0.0001;
        return new Ellipse2D.Double(x - rad, y - rad, rad * 2, rad * 2);
    }


    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(new File("lineoftoads.txt"));
        while (sc.hasNextInt()) {
            toads.add(new Point(sc.nextInt(), sc.nextInt()));
        }

        //for every set of 3 toads
        for (int t1 = 0; t1 < toads.size() - 2; t1++) {
            for (int t2 = t1 + 1; t2 < toads.size() - 1; t2++) {
                for (int t3 = t2 + 1; t3 < toads.size(); t3++) {

                    t1x = (int) toads.get(t1).getX();
                    t2x = (int) toads.get(t2).getX();
                    t3x = (int) toads.get(t3).getX();

                    t1y = (int) toads.get(t1).getY();
                    t2y = (int) toads.get(t2).getY();
                    t3y = (int) toads.get(t3).getY();

                    x1 = Math.min(t1x, Math.min(t2x, t3x));
                    y1 = Math.min(t1y, Math.min(t2y, t3y));
                    x2 = Math.max(t1x, Math.max(t2x, t3x));
                    y2 = Math.max(t1y, Math.max(t2y, t3y));

                    Rectangle rect = new Rectangle(x1, y1, x2 - x1, y2 - y1);

                    rectarea = (x2 - x1) * (y2 - y1);
                    triarea = Math.abs(((t1x * (t2y - t3y) + t2x * (t3y - t1y) + t3x * (t1y - t2y)) / 2));

                    if (triarea == 0) { // If they are in a straight line
                        // let C be the circle containing rect
                        radius = 0.5 * Math.hypot(x2 - x1, y2 - y1);
                        C = circleByCenterRadius(x1 + (x2 - x1) / 2, y1 + (y2 - y1) / 2, radius);
                    } else {
                        // let C be the circle passing through toads location
                        ma = ((t2y - t1y) / (t2x - t1x)); // SLOPE for t1 to t2
                        mb = ((t3y - t2y) / (t3x - t2x)); // SLOPE for t2 to t3

                        //calculate X coordinate for center of circle
                        cx = ((ma * mb * (t1y - t3y) + mb * (t1x + t2x) - ma * (t2x + t3x)) / (2 * (mb - ma)));
                        cy = ((-1 / ma) * (cx - ((t1x + t2x) / 2)) + ((t1y + t2y) / 2)); // calc for y
                        radius = Math.hypot(cx - t2x, cy - t1y);

                        C = circleByCenterRadius(cx, cy, radius);
                    }

                    if (radius < r) { // If radius of C < the radius so far
                        count = 0;
                        for (int i = 0; i < toads.size(); i++) {
                            if (count < 16) {
                                if (C.contains(toads.get(i))) {
                                    count++;
                                }
                            }
                        }
                        if (count == 16) {
                            r = radius;
                        }

                    }


                }
            }
        }

        if (r != 30000.0){
            System.out.println("Radius < " + r);
        } else {
            System.out.println("Unlimited Radius");
        }
    }
}
