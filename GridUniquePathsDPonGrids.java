//There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

//Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

//The test cases are generated so that the answer will be less than or equal to 2 * 109.


// MEMOIZATION

//o(m*n)-tc
//o((n-1)+(m-1))+O(m*n)-sc

// class Solution {
//     int f(int m, int n , int [] [] dp){
//         if(m==0 && n==0)
//         return 1;
//         if(m<0 || n<0)
//         return 0;

//         if(dp[m][n] != -1)
//         return dp[m][n];
//         int up = f(m-1, n,dp);
//         int left = f(m, n-1,dp);
//         return dp[m][n]= up+left;
//     }
//     public int uniquePaths(int m, int n) {
//         int [][] dp = new int[m][n];
//         for(int[] row: dp)
//         Arrays.fill(row,-1);
//         return f(m-1, n-1,dp);
//     }
// }


//TABULATION

//tc-o(m*n)
//sc-o(m*n)


// class Solution {
//     int f(int m, int n , int [] [] dp){
//        // dp[0][0]=1;
//         for(int i =0; i<m; i++){
//             for(int j =0; j<n; j++){
//                 if(i==0 && j==0){
//                     dp[i][j]=1;
//                     continue;

//                 }
//                     int up=0;
//                     int left = 0;

//                     if(i>0)
//                     up = dp[i-1][j];
//                     if(j>0)
//                     left = dp[i][j-1];
            

//                 dp[i][j]=up+left;
//             }
//         }
            
        
//         return dp[m-1][n-1];
//     }
        
//     public int uniquePaths(int m, int n) {
//         int [][] dp = new int[m][n];
//         for(int[] row: dp)
//         Arrays.fill(row,-1);
//         return f(m, n,dp);
//     }
// }



//SPACE OPTIMIZATION


//tc-o(m*n)
//o(n)-sc


  class Solution{  

   public int uniquePaths(int m, int n) {
       
        int prev[]= new int[n];
        for(int i =0; i<m; i++){
            int temp[] =new int[n];
            for(int j=0; j<n; j++){
                if(i==0 &&j==0){  
                temp[j]=1;
                continue;
            }

            int up =0;
            int left =0;
            if(i>0)
            up = prev[j];
            if(j>0)
            left= temp[j-1];

            temp[j] = up+left;
        }
        prev = temp;
    }
    return prev[n-1];
}
  }
