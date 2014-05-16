import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tae on 5/16/14.
 */
public class BreedingToads {
    static ArrayList<Coordinate> list = new ArrayList<Coordinate>();

public static void main(String args[]){
    try{
        Scanner filescan = new Scanner(new File(args[0])); //Try and take a file as input
        while(filescan.hasNext()){
            list.add(new Coordinate(filescan.nextDouble(),filescan.nextDouble()));
        }

    } catch(FileNotFoundException e){System.err.println("File Not Found");}
}


}

