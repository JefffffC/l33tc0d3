// Optimal solution (but not quite for very small values of n)

import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 1) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else return true;
        }
        return false;
    }
}