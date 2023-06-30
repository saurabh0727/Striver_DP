//You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

//An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

//Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

//tc-o(n*m)
//sc-O((M-1)+(N-1)) + O(N*M)





// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         Integer[][] memo = new Integer[m][n];
//         return calculatePaths(obstacleGrid, 0, 0, m, n, memo);
//     }
    
//     private int calculatePaths(int[][] obstacleGrid, int i, int j, int m, int n, Integer[][] memo) {
//         // Check if out of bounds or obstacle
//         if (i < 0 || i >= m || j < 0 || j >= n || obstacleGrid[i][j] == 1) {
//             return 0;
//         }
        
//         // Check if reached bottom-right corner
//         if (i == m - 1 && j == n - 1) {
//             return 1;
//         }
        
//         // Check if result already memoized
//         if (memo[i][j] != null) {
//             return memo[i][j];
//         }
        
//         // Calculate paths by moving right and down
//         int pathsRight = calculatePaths(obstacleGrid, i, j + 1, m, n, memo);
//         int pathsDown = calculatePaths(obstacleGrid, i + 1, j, m, n, memo);
        
//         // Memoize the result
//         memo[i][j] = pathsRight + pathsDown;
        
//         return memo[i][j];
//     }
// }




//tc-o(n*m)
//sc-o(n*m)

// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;

//         int[][] dp = new int[m][n];

//         // Fill the first row
//         for (int j = 0; j < n; j++) {
//             if (obstacleGrid[0][j] == 1) {
//                 break;  // Obstacle found, no further paths possible
//             }
//             dp[0][j] = 1;
//         }

//         // Fill the first column
//         for (int i = 0; i < m; i++) {
//             if (obstacleGrid[i][0] == 1) {
//                 break;  // Obstacle found, no further paths possible
//             }
//             dp[i][0] = 1;
//         }

//         // Fill the rest of the grid
//         for (int i = 1; i < m; i++) {
//             for (int j = 1; j < n; j++) {
//                 if (obstacleGrid[i][j] == 1) {
//                     continue;  // Obstacle found, skip this cell
//                 }
//                 dp[i][j] = dp[i-1][j] + dp[i][j-1];
//             }
//         }

//         return dp[m-1][n-1];
//     }
// }


//tc-0(m*n)
//sc-o(n)

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] dp = new int[n];

        // Initialize the first element
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        // Fill the first row
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[j] = dp[j-1];
            } else {
                dp[j] = 0;
            }
        }

        // Fill the rest of the grid
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[0] = 0;  // Obstacle found, no further paths possible
            }
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;  // Obstacle found, skip this cell
                } else {
                    dp[j] += dp[j-1];
                }
            }
        }

        return dp[n-1];
    }
}

