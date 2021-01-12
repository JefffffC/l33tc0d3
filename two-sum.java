// Brute force solution

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int a = 0;
        for (; a < nums.length - 1; a++) {
            for (int b = a + 1; b < nums.length; b++) {
                if (nums[a] + nums[b] == target) {
                    int[] res = new int[2];
                    res[0] = a;
                    res[1] = b;
                    return res;
                }
                else continue;
            }
        }
        return null;
    }
}

// Optimal solution

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return (new int[] {map.get(complement), i});
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}