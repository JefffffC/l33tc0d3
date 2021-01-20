// Naive solution

class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }
}

// Optimal solution (custom binary search)

class Solution {
    public int findMin(int[] nums) {
        // in a binary search, comparison is as follows:
        // if target is greater than selection, then take right side interval
        // otherwise take left side interval
        
        // our binary criteria is as follows:
        // we are looking for an instance where ascending order is violated (goes from 7 to 0, 5 to 2, etc.)
        // numbers to the left of instance are ALWAYS greater than numbers to the right of instance
        // exception to this rule is if it was rotated back to sorted array, in which case we just take nums[0]
        
        int starter = nums[0];
        int ender = nums[nums.length - 1];
        
        if (starter <= ender) return nums[0];
        int lPtr = 0;
        int rPtr = nums.length - 1;
        while (true) {
            int i = (lPtr + rPtr) / 2;
            if (nums[i + 1] < nums[i]) return nums[i + 1];
            if (nums[i] < ender) rPtr = i;
            else lPtr = i;
            continue;
        }
        
    }
}