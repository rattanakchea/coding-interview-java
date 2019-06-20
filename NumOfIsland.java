class NumOfIsland {

    public static void main(String[] args) {

        int[][] grid = new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(int[][] grid) {

        int numsOfRow = grid.length;
        int numsOfCol = grid[0].length;
        boolean[][] visited = new boolean[numsOfRow][numsOfCol];

        int count = 0;
        for (int row = 0; row < numsOfRow; row++) {
            for (int col = 0; col < numsOfCol; col++) {
                if (grid[row][col] == 1 && visited[row][col] == false) {
                    count++;
                    dfs(grid, row, col, visited);
                }
            }
        }
        return count;
    }

    // mark island as visited
    public static void dfs(int[][] grid, int row, int col, boolean[][] visited) {
        // out of bounce
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        if (visited[row][col] == true || grid[row][col] == 0)
            return;
        visited[row][col] = true;
        dfs(grid, row, col + 1, visited);
        dfs(grid, row, col - 1, visited);
        dfs(grid, row + 1, col, visited);
        dfs(grid, row - 1, col, visited);
    }
}