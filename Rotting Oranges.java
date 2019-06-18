class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        HashMap<Integer,Integer> gen = new HashMap<Integer,Integer>();
        
        int numCol = grid[0].length;
        int numRow = grid.length;
        int numOranges = 0;
        
        for (int r = 0; r < numRow; r++) {
            for (int c = 0; c < numCol; c++) {
                if (grid[r][c] == 2) { // if orange is rotting, enqueue cell position
                    int code = getCode(r, c, numCol);
                    queue.add(code);
                    gen.put(code, 0); // add cell position and depth (zero for start)
                    numOranges++;
                }
                if (grid[r][c] == 1)
                    numOranges++;
            }
        }
        
        int numRotted = 0;
        
        while (!queue.isEmpty()) {
            int code = queue.remove();
            numRotted++;
            int c = code % numCol;
            int r = code / numCol;
            if (grid[r][c] == 2) {
                if (r > 0) {
                    if (grid[r - 1][c] == 1) {
                        grid[r - 1][c] = 2;
                        int newCode = getCode(r - 1, c, numCol); // get the 1D representation of child cell
                        queue.add(newCode); // enqueue child cell
                        gen.put(newCode, gen.get(code) + 1); // increase the gen (minute) of the child cell
                        minutes = gen.get(newCode); // increase minutes to latest one
                    }
                }
                if (r + 1 < numRow) {
                    if (grid[r + 1][c] == 1) {
                        grid[r + 1][c] = 2;
                        int newCode = getCode(r + 1, c, numCol); // get the 1D representation of child cell
                        queue.add(newCode); // enqueue child cell
                        gen.put(newCode, gen.get(code) + 1); // increase the gen (minute) of the child cell
                        minutes = gen.get(newCode);
                    }   
                }
                if (c > 0) {
                    if (grid[r][c - 1] == 1) {
                        grid[r][c - 1] = 2;
                        int newCode = getCode(r, c - 1, numCol); // get the 1D representation of child cell
                        queue.add(newCode); // enqueue child cell
                        gen.put(newCode, gen.get(code) + 1); // increase the gen (minute) of the child cell
                        minutes = gen.get(newCode);
                    }
                }
                if (c + 1 < numCol) {
                    if (grid[r][c + 1] == 1) {
                        grid[r][c + 1] = 2;
                        int newCode = getCode(r, c + 1, numCol); // get the 1D representation of child cell
                        queue.add(newCode); // enqueue child cell
                        gen.put(newCode, gen.get(code) + 1); // increase the gen (minute) of the child cell
                        minutes = gen.get(newCode);
                    }
                }   
            }
        }
        
        if (numRotted != numOranges)
            return -1;
        
        return minutes;
    }
    
    private int getCode(int r, int c, int numCol) {
        return (r * numCol) + c;
    }
}
