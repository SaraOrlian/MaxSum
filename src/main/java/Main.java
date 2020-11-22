import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        try {
            //Read file
            String filePath = args[0];
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            //Get dimensions
            int size = myReader.nextInt();
            //Create empty array
            int[][] square = new int[size][size];
            //Populate array
            for(int row = 0; row < size; row++){
                for(int col = 0; col <size; col++){
                    int cell = myReader.nextInt();
                    square[row][col] = cell;
                }
            }

            MaxSum maxSum = new MaxSum(square);
            System.out.printf(String.valueOf(maxSum.getMaxSum()));
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}