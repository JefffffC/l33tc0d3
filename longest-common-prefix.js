class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int a = -1;
        boolean ripFlag = false;
        String res = "";
        while (ripFlag == false) {
            char letter = 0;
            try {
                letter = strs[0].charAt(++a);
            } catch(StringIndexOutOfBoundsException e) {
                break;
            }
            for (int i = 1; i < strs.length; i++) {
                char test = 0;
                try {
                    test = strs[i].charAt(a);
                } catch(StringIndexOutOfBoundsException e) {
                    ripFlag = true;
                    break;
                }
                if (test != letter) {
                    ripFlag = true;
                    break;
                }
            }
            if (ripFlag == true) break;
            res = res + strs[0].charAt(a);
        }
        return res;
    }
}
