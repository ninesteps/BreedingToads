import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tae on 5/16/14.
 */
public class BreedingToads {

    static Double[][] dist;
    static Double[] smallDist, clo;
    static ArrayList<Coordinate> list = new ArrayList<Coordinate>();
    static Double size;

    public static double distance(Coordinate a, Coordinate b){
        return Math.sqrt((a.getX()-b.getX())*(a.getX()-b.getX())+(a.getY()-b.getY())*(a.getY()-b.getY()));
    }


    public static void sortDistances(){
        XSmallest xsmall;

        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.size(); j++){
                smallDist[j] = distance(list.get(i), list.get(j));
            }
            xsmall = new XSmallest(smallDist,15);
            clo[i] = xsmall.partition(0,smallDist.length-1);
        }
        Arrays.sort(clo);
        size = clo[15];

    }


    public static void main(String args[]){
        try{
            Scanner filescan = new Scanner(new File(args[0])); //Try and take a file as input
            while(filescan.hasNext()){
                list.add(new Coordinate(filescan.nextDouble(),filescan.nextDouble()));
            }
            dist = new Double[list.size()][list.size()];
            clo = new Double[list.size()];
            smallDist = new Double[list.size()];

            if(list.size() < 16){
                System.out.println("Infinite Area");
            } else {
                sortDistances();
                System.out.println("Biggest Diameter: " + (clo[15]-0.000000000000001)); // hax
            }




        } catch(FileNotFoundException e){System.err.println("File Not Found");}
    }


}

