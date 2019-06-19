class Solution {
    
    public List<Integer> addToArrayForm(int[] A, int K) {
        Deque <Integer> queue = new ArrayDeque<Integer>();
        while(K > 0) {
            queue.add(K % 10); // adding to a queue because we are interested in the first order number first (FIFO)
            K = K / 10;
        }
        List<Integer> inputArr = new ArrayList<Integer>(); // new arrayList
        for (int k = 0; k < A.length; k++) {
            inputArr.add(A[k]);
        }
        Collections.reverse(inputArr); // now the input array is reversed for far simpler operations
        for (int i = 0; i < inputArr.size(); i++) {
            int num;
            if (!queue.isEmpty()) {
                num = queue.remove();
            }
            else {
                num = 0;
            }
            if (num + inputArr.get(i) > 9) {
                inputArr.set(i, (inputArr.get(i) + num) % 10);
                if (i < (inputArr.size() - 1)) {
                    inputArr.set(i + 1, inputArr.get(i + 1) + 1); 
                }
                else {
                    inputArr.add(1);
                }
            }
            else {
                inputArr.set(i, (inputArr.get(i)) + num);
            }
        }
        
        while (!queue.isEmpty()) { // directly add on rest of numbers
            inputArr.add(queue.remove());
        }
        
        Collections.reverse(inputArr);
        return inputArr;
    }
}
