class Solution {
    public int reverse(int x) {
        int res = 0;
        int multiplier = (int)Math.pow(10,(int)(Math.log10(Math.abs(x))));
        int isNeg = 0;
        if (x < 0) isNeg = 1;
        x = Math.abs(x);
        while (x > 0) {
            int toAdd = 0;
            try {
                toAdd = Math.multiplyExact((x % 10), multiplier);
            } catch (ArithmeticException e) {
                return 0;
            }
            try {
                res = Math.addExact(res, toAdd);
            } catch (ArithmeticException e) {
                return 0;
            }
            multiplier /= 10;
            x /= 10;
        }
        if (isNeg == 1) res *= -1;
        return res;
    }
}
