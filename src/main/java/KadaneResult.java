class KadaneResult {

    public int getKadaneResult(int array[]) {
        //This function finds the max sum of the temp array
        int max = 0;
        int maxSoFar = 0;

        for (int i = 0; i < array.length; i++) {
            //the max sum so far will equal to the current maxSum + the number at the index we're currently up to.
            maxSoFar += array[i];
            //if maxSoFar is a neg number then set maxSoFar to 0
            maxSoFar = Math.max(maxSoFar, 0);
            //if the current max is less than the max we've been gathering (maxSoFar), swap it
            max = Math.max(max, maxSoFar);
        }
        return max;
    }

}