import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)return 0;
        String[] arr = s.split("");
        int globMax = 0;
        int indexCounter = 0;
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        Queue <String> queue = new ArrayDeque<String>();
        for (int i = 0; i < arr.length; i++) {
            if (!hash.containsKey(arr[i])) {
                hash.put(arr[i], i);
                queue.add(arr[i]);
                indexCounter++;
            }
            else {
                queue.add(arr[i]);
                if (indexCounter > globMax) {
                    globMax = indexCounter;
                }
                int oopsIndex = hash.get(arr[i]);
                while (!queue.peek().equals(arr[i])) {
                    hash.remove(queue.remove());
                }
                hash.remove(queue.remove());
                hash.put(arr[i], i);
                indexCounter = i - oopsIndex;
            }     
        }
        if (indexCounter > globMax) globMax = indexCounter;
        return globMax;
    }
}
