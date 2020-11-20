import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


    public static Result getResult(int matrix[][]){
        int rows = matrix.length;
        int cols = matrix[0].length;

        //Create a temp array to cache the current array we are looking at
        int temp[] = new int[rows];

        Result result = new Result();

        for (int left = 0; left < cols; left++) {
            for (int i = 0; i < rows; i++) {
                temp[i]=0;
                //we are instantiating temp to be fully zero
            }
            for(int right = left; right<cols; right++){
                for (int i = 0; i < rows; i++) {
                    temp[i] += matrix[i][right];

                }
                KadaneResult kadaneResult = getKadaneResult(temp);
                if(kadaneResult.maxSum > result.maxSum){
                    result.maxSum = kadaneResult.maxSum;
                    result.leftBound = left;
                    result.rightBound = right;
                    result.upBound = kadaneResult.start;
                    result.lowBound = kadaneResult.end;
                }
            }

        }

        return result;
    }


    public static KadaneResult getKadaneResult(int array[]){
        //This function finds the max sum of the temp array
        int max = 0;
        int maxStart = -1;
        int maxEnd = -1;
        int currentStart = 0;
        int maxSoFar = 0;

        for (int i = 0; i < array.length; i++) {
            //the max sum so far will equal to the current maxSum + the number at the index we're currently up to.
            maxSoFar += array[i];
            //if maxSoFar is a neg number
            if(maxSoFar < 0){
                maxSoFar = 0; //then just set it to 0
                currentStart = i+1; //go to the next number in the array (i.e ignore the previous values)

            }
            //if the current max is less than the max we've been gathering (maxSoFar), swap it
            if(max<maxSoFar){
//                maxStart = currentStart;
//                maxEnd = i;
                max = maxSoFar;
            }
        }
        return new KadaneResult(max, maxStart, maxEnd);
    }

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


            Result result =  getResult(square);
            System.out.printf(String.valueOf(result.maxSum));
            myReader.close();


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



}