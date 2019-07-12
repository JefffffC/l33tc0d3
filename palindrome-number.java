class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))  return false;
        int sz = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (x > 0) {
            stack.push(x % 10);
            x = x / 10;
            sz++;
        }
        int[] arr = new int[sz];
        for (int i = 0; i < sz; i++) {
            arr[i] = stack.pop();
        }
        int lptr = 0;
        int rptr= arr.length - 1;
        while (lptr < rptr) {
            if (arr[lptr] != arr[rptr])
                return false;
            lptr ++;
            rptr --;
        }
        return true;
    }
}
