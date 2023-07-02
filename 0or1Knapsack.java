//You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
//In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or dont pick it (0-1 property)









// RECURSIVE SOLUTION

// class Solution 
// { 
    
//     static  int f(int ind , int W, int [] wt, int [] val){
//         if(ind==0){
//             if(wt[0] <=W) return val[0];
//             else return 0;
//         }
            
            
//             int nottake = 0+f(ind-1, W, wt, val);
//             int take = Integer.MIN_VALUE;
//             if(wt[ind] <= W)
//             take = val[ind] +f(ind-1, W-wt[ind], wt, val);
            
//             return Math.max(nottake, take);
//         }
    
//     //Function to return max value that can be put in knapsack of capacity W.
//     static int knapSack(int W, int wt[], int val[], int n) 
//     { 
//          // your code here 
       
//          return f(n-1, W, wt,val);
//     } 
// }






//MEMOIZATION

//tc- o(n*w)
//sc-o(n*w)+o(n)

// class Solution 
// { 
    
//     static  int f(int ind , int W, int [] wt, int [] val, int dp[][]){
//         if(ind==0){
//             if(wt[0] <=W) return val[0];
//             else return 0;
//         }
//             if(dp[ind][W] != -1)
//             return dp[ind][W];
            
//             int nottake = 0+f(ind-1, W, wt, val,dp);
//             int take = Integer.MIN_VALUE;
//             if(wt[ind] <= W)
//             take = val[ind] +f(ind-1, W-wt[ind], wt, val,dp);
            
//             return dp[ind][W] =Math.max(nottake, take);
//         }
    
//     //Function to return max value that can be put in knapsack of capacity W.
//     static int knapSack(int W, int wt[], int val[], int n) 
//     { 
//          // your code here 
//          int dp[][] = new int[n][W+1];
//          for(int [] row: dp)
//          Arrays.fill(row,-1);
//          return f(n-1, W, wt,val,dp);
//     } 
// }





//TABULATION


//tc- O(N*W)
//sc- O(N*W)


// class Solution 
// { 
    
//     //Function to return max value that can be put in knapsack of capacity W.
//     static int knapSack(int W, int wt[], int val[], int n) 
//     { 
//          // your code here 
//          int dp[][] = new int[n][W+1];
        
//          for(int i = wt[0] ; i<= W; i++)
//          dp[0][i] = val[0];
         
//          for( int ind=1; ind<n; ind++){
//              for(int cap= 0; cap <= W; cap++ ){
                 
//                 int nottake = 0+dp[ind-1][cap];
//                 int take = Integer.MIN_VALUE;
//                 if(wt[ind] <= cap)
//                   take = val[ind] +dp[ind-1][cap-wt[ind]];
            
//             dp[ind][cap] =Math.max(nottake, take);
                 
//              }
//          }
//          return dp[n-1][W];
        
//     } 
// }










//SPACE OPTIMAIZATION

//tc- O(N*W)
//sc-o(w)

class Solution 
{ 
    
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int prev []  =new int[W+1];
        
         for(int i = wt[0] ; i<= W; i++)
         prev[i] = val[0];
         
         for( int ind=1; ind<n; ind++){
             
             for(int cap= W; cap >=0; cap--){
                 
                int nottake = 0+prev[cap];
                int take = Integer.MIN_VALUE;
                if(wt[ind] <= cap)
                   take = val[ind] +prev[cap-wt[ind]];
            
            prev[cap] =Math.max(nottake, take);
                 
             }
           
         }
         return prev[W];
        
    } 
}