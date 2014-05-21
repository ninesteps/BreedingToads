import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tae on 5/16/14.
 */
public class BreedingToads {
    static ArrayList<Point> toads = new ArrayList<Point>();
    static double r = 30000; //Radius, set to initially be very large




    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            toads.add(new Point(sc.nextInt(),sc.nextInt()));
        }

        //for every set of 3 toads
        for (int t1 = 0; t1 < toads.size()-2; t1++){
            for (int t2 = t1+1; t2 < toads.size()-1; t2++){
                for (int t3 = t2+1; t3 < toads.size(); t3++){

                    


                }
            }
        }

    }
}
