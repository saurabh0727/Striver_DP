//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

//Note: You can only move either down or right at any point in time.




//MENOIZATION

//tc-o(n*m)
//sc-O((M-1)+(N-1)) + O(N*M)



// class Solution {
//     int f(int i, int j, int[][] grid, int dp[][]){
//         if(i==0  && j== 0)
//         return grid[i][j];

//         if(i<0 || j<0)
//         return (int)Math.pow(8,9);

//         if(dp[i][j]!=-1)
//         return dp[i][j];

//         int up = grid[i][j]+ f(i-1, j , grid,dp);
//         int left = grid[i][j]+f(i,j-1,grid,dp);

//         return dp[i][j]=Math.min(up,left);
//     }
//     public int minPathSum(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;

//         int dp [][] = new int[n][m];
//         for(int[] row:dp)
//         Arrays.fill(row,-1);

        
//         return f(n-1, m-1, grid, dp);
//     }
// }


//TABULATION 

//tc-o(n*m)
//sc-o(n*m)

//class Solution {


// public int minPathSum(int[][] grid) {
//     int n = grid.length;
//     int m = grid[0].length;
//     int[][] dp = new int[n][m];

//     for (int i = 0; i < n; i++) {
//         for (int j = 0; j < m; j++) {
//             if (i == 0 && j == 0)
//                 dp[i][j] = grid[i][j];
//             else {
//                 int up = grid[i][j] + (i > 0 ? dp[i - 1][j] : (int) Math.pow(10, 9));
//                 int left = grid[i][j] + (j > 0 ? dp[i][j - 1] : (int) Math.pow(10, 9));
//                 dp[i][j] = Math.min(up, left);
//             }
//         }
//     }
//     return dp[n - 1][m - 1];
// }

// }



//tc-o(m*n)
//sc-o(n)
class Solution{
public int minPathSum(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    
    int dp[][]= new int[n][m];
    
    for(int i = 0; i<n; i++){
        for(int j =0; j<m; j++){
            
            if(i==0 && j==0)
            dp[i][j]= grid[i][j];
             else {
                 
            int up=grid[i][j];
            if(i>0) 
            up+=dp[i-1][j];
            else 
            up+=(int)Math.pow(10,9);
           
           
                
            int left = grid[i][j];
            if(j>0) left+=dp[i][j-1];
            else left += (int)Math.pow(10,9);
                
            dp[i][j]=Math.min(up,left);
            }
        }
    }
    
    return dp[n-1][m-1];
}
}

