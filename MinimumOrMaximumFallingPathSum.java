// Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

// A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).



//memoization
//tc-o(n*n)
//sc-o(n)+o(n*n)

// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length;
//         int[][] dp = new int[n][n];

//         // Initialize the first row of the new matrix with the same values as the input matrix
//         for (int i = 0; i < n; i++) {
//             dp[0][i] = matrix[0][i];
//         }

//         // Iterate from the second row to the last row
//         for (int i = 1; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 int below = dp[i - 1][j]; // directly below
//                 int left = (j > 0) ? dp[i - 1][j - 1] : Integer.MAX_VALUE; // diagonally left
//                 int right = (j < n - 1) ? dp[i - 1][j + 1] : Integer.MAX_VALUE; // diagonally right

//                 // Update the current element with the minimum sum from the three possible paths
//                 dp[i][j] = matrix[i][j] + Math.min(below, Math.min(left, right));
//             }
//         }

//         // Find the minimum value in the last row of the new matrix
//         int minSum = Integer.MAX_VALUE;
//         for (int j = 0; j < n; j++) {
//             minSum = Math.min(minSum, dp[n - 1][j]);
//         }

//         return minSum;
//     }
// }


//TABULATION METHOD

//tc-o(n*m)
//sc-o(n*m)

// class Solution{


//     static int minFallingPathSum(int[][] matrix)
//     {
//         // code here
//         int n= matrix.length;
//         int m= matrix[0].length;
        
//         int dp[][] =new int[n][m];
       
        
//         for(int j = 0; j<m; j++){
//         dp[0][j]= matrix[0][j];
//         }
        
//         for(int i=1; i<n;i++){
//             for(int j=0; j<m;j++){
                
                
//         int s= matrix[i][j]+dp[i-1][j];
        
//         int id=matrix[i][j];
//         if(j-1>=0)  id+=dp[i-1][j-1];
//         else id+=(int)Math.pow(10,9);
        
        
//         int rd=matrix[i][j];
//         if(j+1<m) rd+=dp[i-1][j+1];
//         else rd+=(int)Math.pow(10,9);
        
//         dp[i][j]= Math.min(s,Math.min(id,rd));
        
                
//             }
//         }
        
//         int maxi=Integer.MAX_VALUE;
        
//         for(int j= 0; j<m; j++){
            
        
//         maxi= Math.min(maxi, dp[n-1][j]);
//     }
//     return maxi;
// }
// }











//SPACE OPTIMAZATION

//tc-o(n*m)
//sc-o(m)


// class Solution{


//     static int minFallingPathSum(int[][] matrix)
//     {
//         // code here

//         int n= matrix.length;
//         int m= matrix[0].length;
//         int prev [] = new int[m];
//         int cur [] =new int[m];
       
        
//         for(int j = 0; j<m; j++){
//         prev[j]= matrix[0][j];
//         }
        
//         for(int i=1; i<n;i++){
//             for(int j=0; j<m;j++){
                
                
//         int s= matrix[i][j]+prev[j];
        
//         int id=matrix[i][j];
//         if(j-1>=0)  id+=prev[j-1];
//         else id+=(int)Math.pow(10,9);
        
        
//         int rd=matrix[i][j];
//         if(j+1<m) rd+=prev[j+1];
//         else rd+=(int)Math.pow(10,9);
        
//         cur[j]= Math.min(s,Math.min(id,rd));
        
                
//             }
//             cur=prev;
//         }
        
//         int maxi=Integer.MAX_VALUE;
        
//         for(int j= 0; j<m; j++){
            
        
//         maxi= Math.min(maxi, prev[j]);
//     }
//     return maxi;
// }
// }









class Solution {
    static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[m];
        int[] cur = new int[m];

        for (int j = 0; j < m; j++) {
            prev[j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int s = matrix[i][j] + prev[j];

                int id = matrix[i][j];
                if (j - 1 >= 0)
                    id += prev[j - 1];
                else
                    id += (int) Math.pow(10, 9);

                int rd = matrix[i][j];
                if (j + 1 < m)
                    rd += prev[j + 1];
                else
                    rd += (int) Math.pow(10, 9);

                cur[j] = Math.min(s, Math.min(id, rd));
            }
            int[] temp = prev;
            prev = cur;
            cur = temp;
        }

        int mini = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, prev[j]);
        }

        return mini;
    }
}
