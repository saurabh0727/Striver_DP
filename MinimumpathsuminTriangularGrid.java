//Given a triangle array, return the minimum path sum from top to bottom.

//For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.




//RECURSIVE SOLUTION

//tc-n
//sc-o(n)

// class Solution {
// int f(int i ,int j ,List<List<Integer>> triangle ){
//         if(i==triangle.size()-1)
//         return triangle.get(i).get(j);

//         int d= triangle.get(i).get(j)+f(i+1,j ,triangle);
//         int dg=triangle.get(i).get(j)+f(i+1, j+1,triangle);

//         return Math.min(d,dg);
// }
//     public int minimumTotal(List<List<Integer>> triangle) {
        
//         return f(0,0,triangle);
        
//     }
// }



//MEMOIZATION METHOD

//tc-o(n*n)
//sc-o(n)+o(n*n)

// class Solution {
// int f(int i ,int j ,List<List<Integer>> triangle,int [][] dp){
//         if(i==triangle.size()-1)
//         return triangle.get(i).get(j);

//         if(dp[i][j] != -1)
//         return dp[i][j];

//         int d= triangle.get(i).get(j)+f(i+1,j ,triangle,dp);
//         int dg=triangle.get(i).get(j)+f(i+1, j+1,triangle,dp);

//         return dp[i][j] =Math.min(d,dg);
// }
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
      


//         int dp [][]=new int[n][n];
//         for(int[] row : dp)
//         Arrays.fill(row,-1);

//         return f(0,0,triangle,dp);
        
//     }
// }




//TABULATION METHOD

//tc-o(n*n)
//sc-o(n*n)

// class Solution {

       
    
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
      


//         int dp [][]=new int[n][n];
//         for(int[] row : dp)
//         Arrays.fill(row,-1);

//         for(int j = 0; j<n; j++){
//             dp[n-1][j]=triangle.get(n-1).get(j);
//         }

//             for(int i =n-2; i>=0; i--){
//                 for( int j=i; j>=0; j--){
                    
//                     int d= triangle.get(i).get(j)+dp[i+1][j];
//                     int dg=triangle.get(i).get(j)+dp[i+1][j+1];

//                     dp[i][j]= Math.min(d,dg);
                    
//                 }
//             }
        

//         return dp[0][0];
        
//     }
// }




// class Solution {

    //tc-o(n*n)
    //sc-o(n)
       
    
//     public int minimumTotal(List<List<Integer>> triangle) {
//           int n = triangle.size();
//           int front [] =new int[n];
//           int cur[] = new int[n];

//         for(int j = 0; j<n; j++){
//             front[j]=triangle.get(n-1).get(j);
//         }

//             for(int i =n-2; i>=0; i--){
                
//                 for( int j=i; j>=0; j--){
                    
//                     int d= triangle.get(i).get(j)+front[j];
//                     int dg=triangle.get(i).get(j)+front[j+1];

//                     cur[j]= Math.min(d,dg);
                    
//                 }


//                 front = cur;
//             }
        

//         return front[0];
        
//     }
// }














class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        
        // Initialize the dp array with the values from the bottom row
        List<Integer> lastRow = triangle.get(n - 1);
        for (int i = 0; i < n; i++) {
            dp[i] = lastRow.get(i);
        }
        
        // Traverse the triangle from second-to-last row up to the top
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> currentRow = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                // Calculate the minimum path sum for each element in the current row
                int currentSum = currentRow.get(j) + Math.min(dp[j], dp[j + 1]);
                dp[j] = currentSum; // Update the dp array with the new minimum path sum
            }
        }
        
        // The minimum path sum from top to bottom will be the value at the top of the dp array
        return dp[0];
    }
}
