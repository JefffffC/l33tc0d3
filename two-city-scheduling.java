class Solution {
    public int twoCitySchedCost(int[][] costs) {
        quickSort(costs, 0, costs.length - 1); // call the quicksort function (below), which sorts it by cost savings
        int lowestCost = 0; 
        int counter1 = 0; // we use counters to track the # of people per city to prevent from exceeding N
        int counter2 = 0;
        for (int i = 0; i < costs.length; i ++) { // iterate through each person
            if (Math.min(costs[i][0], costs[i][1]) == costs[i][0]) { // if city A is cheaper
                if (counter1 < (costs.length / 2)) { // if city A capacity hasn't reached N
                    counter1++; // increment counter for city A
                    lowestCost += costs[i][0]; // add to total cost
                }
                else {
                    counter2++; // if city A counter has reached N, we are forced to use city B instead
                    lowestCost += costs[i][1];
                }
            }
            else {
                if (counter2 < (costs.length / 2)) { // same process goes for if City B is cheaper
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
    
    private void quickSort (int[][] costs, int left, int right) { // quicksort function (see www.algolist.net/Algorithms/Sorting/Quicksort)
        int index = partition(costs, left, right);  // call the partition function which sorts and returns index of partition
        if (left < (index - 1)) { // check valid partition on left side, then recursively call
            quickSort(costs, left, index - 1);
        }
        if (index < right) { // same goes for right
            quickSort(costs, index, right);
        }
    }
    
    private int partition (int[][] costs, int low, int high) { // partition by selecting the middle element
        int pivot[] = costs[(low + high) / 2]; // set pivot to middle position
		
		/* We use deltas (difference between city A and B cost for a person) because the actual cost isn't relevant,
			but the importance (weight) of the decision depends on how much more money we save from picking one city over the other.
			This is why the quicksort function is sorting by the delta and not the actual costs.*/
		
		// variable to store delta (absolute value difference) between city A and city B cost for that specific person (subarray)
        int pivotDelta = Math.abs(pivot[0] - pivot[1]); 
        int r = high; // position keepers (left and right)
        int l = low;
        while (l <= r) { // loop breaks when l passes r
            
            while (delta(costs[l]) > pivotDelta) // keep on shifting left tracker until a possible swap is found (where the deltas of:  l < pivot < r)
                l++;
            while (delta(costs[r]) < pivotDelta) // same for right tracker
                r--;
            if (l <= r) {
                int temp[] = costs[r]; // do a swap if (delta) l < pivot < r is true
                costs[r] = costs[l];
                costs[l] = temp;
                --r; // move right pointer
                l++; // move left pointer
            }
        }
        return l;
    }
    private int delta (int[] costs) { // helper function for calculating deltas
        return Math.abs(costs[0] - costs[1]);
    }
}
