import java.util.Arrays;

public class MaxSum {
    private int maxSum;
    private int maxSumKadane;
    private KadaneResult kadaneResult = new KadaneResult();;

    public MaxSum(int[][] square) {
        this.getResult(square);
    }
    public int getMaxSum() {
        return maxSum;
    }

    public void getResult(int matrix[][]) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        //Create a temp array to cache the current array we are looking at
        int temp[] = new int[rows];

        for (int left = 0; left < cols; left++) {
            Arrays.fill(temp, 0);  //reset temp array, since left column marker shifts
            for (int right = left; right < cols; right++) {    //right column marker shifts
                for (int i = 0; i < rows; i++) {               //iterate through rows
                    temp[i] += matrix[i][right];               //keep running total
                }

                maxSumKadane = kadaneResult.getKadaneResult(temp); //uses kadane's alogorithm to find maximum contiguous portion of temp array
                if (maxSumKadane > maxSum) {
                    maxSum = maxSumKadane;
                }
            }
        }
    }
}
