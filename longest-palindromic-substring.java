class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        int globalMax = 0;
        int leftP = 0;
        int rightP = 0;
        for (int i = 0; i < s.length(); i++) {
            int [] tempArr = findPalindrome(s,i);
            if ((tempArr[1] - tempArr[0] + 1) > globalMax) {
                leftP =  tempArr[0];
                rightP = tempArr[1];
                globalMax = rightP - leftP + 1;
            }
        }
        return s.substring(leftP, rightP + 1);
    }
    
    private int[] findPalindrome(String s, int location) {
        int lPtr = location;
        int rPtr = location;
        if (location < s.length() - 1) {
            if (s.charAt(lPtr) == s.charAt(location + 1)) {
                while (s.charAt(rPtr + 1) == s.charAt(rPtr)) {
                    rPtr++;
                    if (rPtr == s.length() - 1)
                        break;
                }
            }   
        }
        if (lPtr > 0 && rPtr < s.length() - 1) {
            while (true) {
                if (rPtr == (s.length() - 1) || lPtr == 0)
                    break;
                else if (s.charAt(lPtr - 1) == s.charAt(rPtr + 1)) {
                    lPtr--;
                    rPtr++;
                }
                else
                    break;
            }
        }
        int[] arr = {lPtr, rPtr};
        return arr;
    }
}
    
