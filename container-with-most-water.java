class Solution {
    public int maxArea(int[] height) {
        int globalMax = 0;
        int lptr = 0;
        int rptr = height.length - 1;
        while (lptr < rptr) {
            globalMax = Math.max(globalMax, Math.min(height[lptr],height[rptr]) * (rptr - lptr));
            if (height[lptr] < height[rptr])
                lptr++;
            else rptr--;
        }
        return globalMax;
    }
}
