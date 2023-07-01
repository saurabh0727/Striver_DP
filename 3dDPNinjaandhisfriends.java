
//You are given an r rows and c cols matrix grid representing a field of chocolates where grid[i][j] represents the number of chocolates that you can collect from the (i, j) cell.

//You have two robots that can collect chocolates for you:

//Robot #1 is located at the top-left corner (0, 0), and
//Robot #2 is located at the top-right corner (0, cols - 1).
//Return the maximum number of chocolates collection using both robots by following the rules below:

//From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
//When any robot passes through a cell, It picks up all chocolates, and the cell becomes an empty cell.
//When both robots stay in the same cell, only one takes the chocolates.
//Both robots cannot move outside of the grid at any moment.
//Both robots should reach the bottom row in grid.






//MEMOIZATION CODE

//tc-o(n*m*m)*9
//sc-o(n)+o(n*n*m)

// class Solution{
//     int f(int i, int j1, int j2,int n, int m,int grid[][], int dp[][][]){
//         if(j1<0 || j1>=m ||j2<0 || j2>=m)
//         return (int)Math.pow(-10,9);
        
//         if(i==n-1){
//             if(j1==j2){
//           return grid[i][j1];
//             }
            
//             else return grid[i][j1]+ grid[i][j2];
//         }
        
//         if(dp[i][j1][j2] != -1)
//         return dp[i][j1][j2];
        
//         int maxi =Integer.MIN_VALUE;
        
//         for(int jd1 =-1; jd1 <=+1;jd1++){
//             for(int jd2 = -1; jd2<=+1; jd2++){
                
//                 // int value;
                
//                 // if(j1==j2)
//                 // value = grid[i][j1];
                
//                 // else 
//                 // value =grid[i][j1]+grid[i][j2];
                
//                 // value+= f(i+1, j1+jd1,j2+jd2,n, m, grid,dp);
                
//                 // maxi = Math.max(maxi, value);
                
                
//                  int ans;
//         if (j1 == j2)
//           ans = grid[i][j1] + f(i + 1, j1 + jd1, j2 + jd2, n, m, grid, dp);
//         else
//           ans = grid[i][j1] + grid[i][j2] + f(i + 1, j1 + jd1, j2 + jd2,n,
//           m, grid, dp);
//         maxi = Math.max(maxi, ans);
//             }
//         }
//         return dp[i][j1][j2] =maxi;
        
//     }
//     public int solve(int n, int m, int grid[][]){
        
//         int dp[][][] = new int[n][m][m];
//         for(int[][]  row1: dp){
//             for(int row2[] : row1){
//                 Arrays.fill(row2,-1);
//             }
//         }
        
        
//         return f(0,0,m-1,n,m,grid,dp);
//         // Code here
//     }
// }





//TABULATION METHOOD

// class Solution{
    
 //tc-O(N*M*M)*9      
 //sc-O(N*M*M)

//     public int solve(int n, int m, int grid[][]){
        
//         int dp[][][] = new int[n][m][m];
        
        
        
        
//       for(int j1 =0; j1<m; j1++){
//           for(int j2=0; j2<m; j2++){
//               if(j1==j2)   dp[n-1][j1][j2]= grid[n-1][j1];
//               else
//               dp[n-1][j1][j2]= grid[n-1][j1]+grid[n-1][j2];
//           }
//       }
       
//       for(int i =n-2; i>=0; i--){
//           for(int j1= 0; j1<m; j1++){
//               for(int j2=0; j2<m; j2++){
                   
                   
//                 int maxi =Integer.MIN_VALUE;
                   
                   
//                   for(int jd1 =-1; jd1 <=+1;jd1++){
//                       for(int jd2 = -1; jd2<=+1; jd2++){
                
//                 int value;
                
//                 if(j1==j2)
//                 value = grid[i][j1];
                
//                 else 
//                 value =grid[i][j1]+grid[i][j2];
                
//                 if (j1+jd1<0  || j1+jd1>=m || j2+jd2<0  ||   j2+jd2 >=m)
//                  value+= (int) Math.pow(-10,9);
//                  else
//                  value+= dp[i+1][j1+jd1][j2+jd2];
                 
                
//                 maxi = Math.max(maxi, value);
                
                   
//               }
//           }
           
//           dp[i][j1][j2]=maxi;
//       }
//         // Code here
//     }
// }
//   return dp[0][0][m-1];
// }
// }




//SPACE OPTIMIZATION



//tc-O(N*M*M)*9
//sc-O(M*M)


class Solution{
    
        
    
    public int solve(int n, int m, int grid[][]){
        
      int front[][]= new int[m][m];
      int cur[][]= new int[m][m];
        
        
        
        
      for(int j1 =0; j1<m; j1++){
          for(int j2=0; j2<m; j2++){
              if(j1==j2)   front[j1][j2]= grid[n-1][j1];
              else
              front[j1][j2]= grid[n-1][j1]+grid[n-1][j2];
          }
      }
       
      for(int i =n-2; i>=0; i--){
          for(int j1= 0; j1<m; j1++){
              for(int j2=0; j2<m; j2++){
                   
                   
                int maxi =Integer.MIN_VALUE;
                   
                   
                  for(int jd1 =-1; jd1 <=+1;jd1++){
                      for(int jd2 = -1; jd2<=+1; jd2++){
                
                int value;
                
                if(j1==j2)
                value = grid[i][j1];
                
                else 
                value =grid[i][j1]+grid[i][j2];
                
                if (j1+jd1<0  || j1+jd1>=m || j2+jd2<0  ||   j2+jd2 >=m)
                 value+= (int) Math.pow(-10,9);
                 else
                 value+= front[j1+jd1][j2+jd2];
                 
                
                maxi = Math.max(maxi, value);
                
                   
              }
          }
           
          cur[j1][j2]=maxi;
      }
          }
      
          for( int a=0; a<m; a++){
              front[a]= (int[])(cur[a].clone());
           

        // Code here
    }
}
  return front[0][m-1];
}
}


