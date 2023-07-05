//Given a set of N items, each with a weight and a value, represented by the array w[] and val[] respectively. Also, a knapsack with weight limit W.
//The task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
//Note: Each item can be taken any number of times.









//THIS  PROBLEME SMILLER AS DP-19  JUST CHANGE IS BASE CASE 


//recursive


//tc- exponential
//sc- o(bag waight)


// class Solution{
//     static int f(int ind, int W, int [] wt,int val[]){
//         if(ind ==0){
//         if(wt[0] <=W) return val[0];
//         else return 0;
//     }
    
//     int nottake= f(ind-1, W, wt, val);
//     int take = Integer.MIN_VALUE;
//     if(wt[ind]<= W)
//     take=val[ind] +f(ind, W-wt[ind], wt, val);
    
//     return Math.max(nottake, take);
//     }
    
//     static int knapSack(int N, int W, int val[], int wt[])
//     {
//         // code here
//         return f(N-1, W, wt, val);
//     }
// }






//memoization

//o(n*w) -tc
//o(n*w)+o(n)-sc

// class Solution{
//      static int f(int ind, int W, int [] wt,int val[], int dp[][]){
//         if(ind ==0){
//              return (W/wt[0]*val[0]);
//         }
//     if(dp[ind][W]!=-1)
//     return dp[ind][W];
    
//     int nottake= f(ind-1, W, wt, val,dp);
//     int take = Integer.MIN_VALUE;
//     if(wt[ind]<= W)
//     take=val[ind] +f(ind, W-wt[ind], wt, val,dp);
    
//     return dp[ind][W]= Math.max(nottake, take);
//     }
    
//     static int knapSack(int N, int W, int val[], int wt[])
//     {
//         // code here
//         int dp[][] = new int[N][W+1];
//         for(int row[]:dp)
//         Arrays.fill(row, -1);
        
//         return f(N-1, W, wt, val,dp);
//     }
// }



//tabulation

//tc-0(n*w)
//sc-0(n*w)

// class Solution{
   
//     static int knapSack(int N, int W, int val[], int wt[])
//     {
//         // code here
//         int dp[][] = new int[N][W+1];
        
//         for(int i = wt[0]; i<=W; i++){
//             dp[0][i]= ((int)i/wt[0])*val[0];
//         }
        
        
//         for(int ind =1; ind<N; ind++){
//             for(int cap=0; cap<=W; cap++){
                
//                  int nottake= 0+dp[ind-1][cap];
//     int take = Integer.MIN_VALUE;
//     if(wt[ind]<= cap)
//     take=val[ind] +dp[ind][cap-wt[ind]];
    
//      dp[ind][cap]= Math.max(nottake, take);
//             }
//         }
        
//         return dp[N-1][W];
//     }
// }






//space optimaization

//tc-o(n*w)
//sc-o(w)

class Solution{
   
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int prev[]=new int[W+1];
        
        for(int i = wt[0]; i<=W; i++){
            prev[i]= ((int)i/wt[0])*val[0];
        }
        
        
        for(int ind =1; ind<N; ind++){
            int cur[] = new int [W+1];
            for(int cap=0; cap<=W; cap++){
                
                 int nottake= 0+prev[cap];
    int take = Integer.MIN_VALUE;
    if(wt[ind]<= cap)
    take=val[ind] +cur[cap-wt[ind]];
    
     cur[cap]= Math.max(nottake, take);
            }
            prev =cur;
        }
        
        return prev[W];
    }
}
