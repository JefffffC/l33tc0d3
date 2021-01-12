class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftArray = new int[nums.length];
        int[] rightArray = new int[nums.length];
        leftArray[0] = nums[0];
        rightArray[nums.length - 1] = nums[nums.length -1];
        for (int i = 1; i < nums.length; i++) {
            leftArray[i] = (leftArray[i-1] * nums[i]);
            rightArray[nums.length - 1 - i] = (rightArray[nums.length - i] * nums[nums.length - 1 - i]);
        }
        int[] outputArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && i < (nums.length-1)) {
                outputArray[i] = leftArray[i - 1] * rightArray[i + 1];
            } else if (i == 0) {
                outputArray[i] = rightArray[i + 1];
            } else if (i == (nums.length - 1)) {
                outputArray[i] = leftArray[i - 1];
            }
        }
        return outputArray;
    }
}