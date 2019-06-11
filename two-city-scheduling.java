class Solution {
    public int twoCitySchedCost(int[][] costs) {
        quickSort(costs, 0, costs.length - 1);
        int lowestCost = 0;
        int counter1 = 0;
        int counter2 = 0;
        for (int i = 0; i < costs.length; i ++) {
            if (Math.min(costs[i][0], costs[i][1]) == costs[i][0]) {
                if (counter1 < (costs.length / 2)) {
                    counter1++;
                    lowestCost += costs[i][0];
                }
                else {
                    counter2++;
                    lowestCost += costs[i][1];
                }
            }
            else {
                if (counter2 < (costs.length / 2)) {
                    counter2++;
                    lowestCost += costs[i][1];
                }
                else {
                    counter1++;
                    lowestCost += costs[i][0];
                }
            }
        }
        return lowestCost;
    }
    
    private void quickSort (int[][] costs, int left, int right) {
        int index = partition(costs, left, right);
        if (left < (index - 1)) {
            quickSort(costs, left, index - 1);
        }
        if (index < right) {
            quickSort(costs, index, right);
        }
    }
    
    private int partition (int[][] costs, int low, int high) {
        int pivot[] = costs[(low + high) / 2]; // set pivot to middle position
        int pivotDelta = Math.abs(pivot[0] - pivot[1]);
        int r = high;
        int l = low;
        while (l <= r) { // loop breaks when l passes r
            
            while (delta(costs[l]) > pivotDelta)
                l++;
            while (delta(costs[r]) < pivotDelta)
                r--;
            if (l <= r) {
                int temp[] = costs[r];
                costs[r] = costs[l];
                costs[l] = temp;
                --r; // move right pointer
                l++; // move left pointer
            }
        }
        return l;
    }
    private int delta (int[] costs) {
        return Math.abs(costs[0] - costs[1]);
    }
}