import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.StrictMath.sqrt;

public class Driver {

    public static void main(String [] args){

        String [] numbers = new String [45403];// Array to store words

        float loadNum;
        float fileSize = 45403;
        int linColl = 0;
        int quadColl = 0;

        int i =0; // int for indexes

        loadNum = (float) 1;

        fileSize = fileSize/loadNum;
        fileSize = nextPrime(fileSize);
        System.out.println((int)fileSize);

        BrukHashTable linear = new BrukHashTable((int)fileSize);
        BrukHashTable quadratic = new BrukHashTable((int)fileSize);

        //Try and catch statement that reads the file.
        try {
            File myObj = new File("src/dictionary.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                numbers[i] = myReader.nextLine();
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. File not found, exiting program.");
            System.exit(0);
        }

        for (int j = 0; j <numbers.length ; j++) {

            linColl += linear.linear(numbers[j]);
            quadColl += quadratic.quad(numbers[j]);
        }

        System.out.println("Linear: ");
        System.out.println("Non-collisions: " + linear.none);
        System.out.println("Collisions: " + linColl);

        System.out.println();
        System.out.println("Quadratic: " );
        System.out.println("Non-collisions: " + quadratic.none);
        System.out.println("Collisions: " + quadColl);
    }

    public static float nextPrime(float num){
        int count;
        num++;

        while(true){
            int low = (int) sqrt(num);
            count = 0;
            for (int i = 2; i <= low; i++) {
                if (num % i == 0){
                    count++;
                }
                if (count == 0){
                    return num;
                } else {
                    num++;
                    continue;
                }
            }
        }

    }
}
