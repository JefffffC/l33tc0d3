class Solution {
    public String intToRoman(int num) {
        String res = "";
        int numM = num / 1000;
        for (int i = 0; i < numM; i++) {
            res = res + 'M';
        }
        num = num % 1000;
        if (num / 900 > 0) {
            res += "CM";
            num = num % 900;
        }
        if (num / 500 > 0) {
            res = res + 'D';
            num = num % 500;
        }
        if (num / 400 > 0) {
            res += "CD";
            num = num % 400;
        }
        int numC = num / 100;
        for (int i = 0; i < numC; i++) {
            res = res + 'C';
        }
        num = num % 100;
        if (num / 90 > 0) {
            res += "XC";
            num = num % 90;
        }
        if (num / 50 > 0) {
            res = res + 'L';
            num = num % 50;
        }
        if (num / 40 > 0) {
            res += "XL";
            num = num % 40;
        }
        int numX = num / 10;
        for (int i = 0; i < numX; i++) {
            res = res + 'X';
        }
        num = num % 10;
        if (num / 9 > 0) {
            res += "IX";
            num = num % 9;
        }
        if (num / 5 > 0) {
            res = res + 'V';
            num = num % 5;
        }        
        if (num / 4 > 0) {
            res += "IV";
            num = num % 4;
        }
        for (int i = 0; i < num; i++) {
            res = res + 'I';
        }
        return res;
    }
}
