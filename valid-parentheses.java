class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        int ptr = 0;
        while (ptr < s.length()) {
            if (s.charAt(ptr) == '{' || s.charAt(ptr) == '[' || s.charAt(ptr) == '(' )
                stack.push(s.charAt(ptr));
            else {
                if (stack.isEmpty()) return false;
                if (!opposite(stack.peek(), s.charAt(ptr)))
                    return false;
                stack.pop();
            }
            ptr++;
        }
        if (stack.isEmpty())
            return true;
        else return false;
    }
    
    private boolean opposite(char last, char now) {
        if (last == '(' && now == ')')
            return true;
        else if (last == '{' && now == '}')
            return true;
        else if (last == '[' && now == ']')
            return true;
        else return false;
    }
}
