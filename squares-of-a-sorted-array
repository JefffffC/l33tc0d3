class Solution {
    public int[] sortedSquares(int[] A) {
        int[] outputArr = new int[A.length];
        int lptr = 0;
        int rptr = A.length - 1;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[rptr] > Math.abs(A[lptr])) {
                outputArr[i] = A[rptr] * A[rptr];
                --rptr;
            }
            else {
                outputArr[i] = A[lptr] * A[lptr];
                ++lptr;
            }
        }
        return outputArr;
    }
}
