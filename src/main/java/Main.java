import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Referenced:
 *  https://youtu.be/-FgseNO-6Gk
 *  https://www.youtube.com/watch?v=yCQN096CwWM
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/SubRectangularMatrixWithMaximumSum.java
 */

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
            int[][] matrix = new int[size][size];
            //Populate array
            for(int row = 0; row < size; row++){
                for(int col = 0; col <size; col++){
                    int cell = myReader.nextInt();
                    matrix[row][col] = cell;
                }
            }

            MaxSum maxSum = new MaxSum(matrix);
            System.out.printf(String.valueOf(maxSum.getMaxSum()));
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}