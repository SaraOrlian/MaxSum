public class MaxSum {
    private int[][] square;
    private int maxSum;

    public MaxSum(int[][] square) {
        this.square = square;
        this.getResult(square);
    }


    public int getMaxSum(){
        return maxSum;
    }

    private void setMaxSum(int maxSum){
        this.maxSum = maxSum;
    }

    public void getResult(int matrix[][]){
        int rows = matrix.length;
        int cols = matrix[0].length;

        //Create a temp array to cache the current array we are looking at
        int temp[] = new int[rows];

        Square square = new Square();

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
                if(kadaneResult.maxSum > square.maxSum){
                    square.maxSum = kadaneResult.maxSum;
                    square.leftBound = left;
                    square.rightBound = right;
                    square.upBound = kadaneResult.start;
                    square.lowBound = kadaneResult.end;
                }
            }

        }

        setMaxSum(square.maxSum);
    }

    public KadaneResult getKadaneResult(int array[]){
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

}
