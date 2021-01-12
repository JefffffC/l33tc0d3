// Optimal solution

// --> this is extension of Kadane's algo but with consideration of multiplication cases.

class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct=nums[0], minProduct=nums[0];
        int res=nums[0];
        for(int i=1;i<nums.length;i++){
            // Get copy of current local max
            int temp = maxProduct;
            // define new local max based on all possible scenarios
            // 1. neg num x minproduct
            // 2. pos num x maxproduct
            // 3. new num exceeds localmax
            maxProduct=Math.max(nums[i], Math.max(nums[i] * maxProduct, nums[i] * minProduct));
            // define new local min based on all possible scenarios
            // 1. neg num x maxproduct
            // 2. pos num x minproduct
            // 3. new num is smaller than localmin
            minProduct=Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * minProduct));
            res=Math.max(res, maxProduct);
        }
        return res;
    }
}