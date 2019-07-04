class Solution {
    public int romanToInt(String s) {
        int res = 0;
        int i = 0;
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        hash.put('I', 1);
        hash.put('V', 5);
        hash.put('X', 10);
        hash.put('L', 50);
        hash.put('C', 100);
        hash.put('D', 500);
        hash.put('M', 1000);
        HashMap<String, Integer> rulehash = new HashMap<String, Integer>();
        rulehash.put("IV",4);
        rulehash.put("IX",9);
        rulehash.put("XL",40);
        rulehash.put("XC",90);
        rulehash.put("CD",400);
        rulehash.put("CM",900);
        while (i < s.length()) {
            if (i < s.length() - 1) {
                String str = "" + s.charAt(i) + s.charAt(i + 1);
                if (rulehash.containsKey(str)) {
                    res+=rulehash.get(str);
                    i+=2;
                    continue;
                }
                else {
                    res+=hash.get(s.charAt(i));
                    i++;
                };
            }
            else {
                res+=hash.get(s.charAt(i));
                i++;
            }
        }
        return res;
    }
}
