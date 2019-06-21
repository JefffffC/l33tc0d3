class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> res = new ArrayList<Integer>();
        if (bound < 2) {
            return res;
        }
        if (x == 1 && y == 1) {
            res.add(2);
            return res;
        }
        else if (x == 1) {
            int yMax = (int)(Math.log(bound - 1) / Math.log(y));
            for (int i = 0; i <= yMax; i++) {
                res.add((int)(Math.pow(y, i) + 1));
            }
            return res;
        }
        else if (y == 1) {
            int xMax = (int)(Math.log(bound - 1) / Math.log(x));
            for (int i = 0; i <= xMax; i++) {
                res.add((int)(Math.pow(x, i) + 1));
            }
            return res;
        }
        int xMaxPow = (int)(Math.log(bound - 1) / Math.log(x));
        int yMaxPow = (int)(Math.log(bound - 1) / Math.log(y));
        int xPow;
        int yPow;
        for (xPow = 0; xPow <= xMaxPow; xPow++) {
            for (yPow = 0; yPow <= yMaxPow; yPow++) {
                int ans = (int)(Math.pow(x, xPow) + Math.pow(y, yPow));
                if (ans <= bound && !res.contains(ans)) {
                    res.add(ans);
                }
            }
        }
        return res;
    }
}
