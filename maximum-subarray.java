class Solution {
    public int maxSubArray(int[] nums) {
        int globalMax = Integer.MIN_VALUE;
        int localMax = 0;
        for (int i = 0; i < nums.length; i++) {
          // if next number in the array exceeds previously maintained subarray sum, throw out old subarray and make this new number localmax. Otherwise, add it to the localmax and continue.
          localMax = Math.max(nums[i], nums[i] + localMax);
          if (localMax > globalMax) {
              globalMax = localMax;
          }
        }
        return globalMax;
    }
}