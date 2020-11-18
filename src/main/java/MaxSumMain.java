import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaxSumMain {

    public static void main(String[] args) {
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

            myReader.close();
            //This is just for testing/visualising the array.
            for(int[] row : square) {
                printRow(row);
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    //This is just for testing/visualising the array.
    public static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
}
