class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[queries.length];
        int sum = 0; // sum starts at zero
        for (int q = 0; q < A.length; q++) {
            if (A[q] % 2 == 0) {
                sum = sum + A[q]; // sum is generated, and further changes are only based on individual queries
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            if(A[queries[i][1]] % 2 == 0) { // if was even
                sum-=A[queries[i][1]];
            }
            A[queries[i][1]] = A[queries[i][1]] + queries[i][0]; // update array entry
            if(A[queries[i][1]] % 2 == 0) { // if became even
                sum += A[queries[i][1]];
            }
            
            res[i] = sum;
            // place sum into output array
        }   
        return res;
    }
}
