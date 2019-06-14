class Solution {
    public int orangesRotting(int[][] grid) {
        
        boolean isDone = false;
        int numMinutes = 0;
        
        
        int i = 0;
        int j = 0;
        while (i < 1) {
            isDone = true;
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[x].length; y++) {
                    if (rotAdjacent(grid, x, y) == true) {
                        isDone = false;
                        j++;
                    }
                }
            }
            if (isDone = false) {
                numMinutes++;
            }
            i++;
        }
        return j;
    }
    
    private boolean rotAdjacent(int[][] grid, int x, int y) {
        
        boolean didRot = false;
        
        if (grid[x][y] == 2) {
            if (x > 0) {
                if (grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    didRot = true;
                }
            }
            if (x + 1 < grid.length) {
                if (grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    didRot = true;
                }
            }
            if (y > 0) {
                if (grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    didRot = true;
                }
            }
            if (y + 1 < grid[0].length) {
                if (grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    didRot = true;
                }
            }   
        }
        else didRot = false;
        
        return didRot;
    }
}