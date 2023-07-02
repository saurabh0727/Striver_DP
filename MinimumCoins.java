//You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

//Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

//You may assume that you have an infinite number of each kind of coin.




//recursive



// class Solution {
//     int f(int ind, int T, int coins[]){
//         if(ind==0){
//         if(T%coins[0]==0)
//         return T/coins[0];

//         else return  (int)Math.pow(9,8)+7;
//         }

//         int nottake= 0+f(ind-1,T, coins);
//         int take = Integer.MAX_VALUE;
//         if(coins[ind]  <= T)
//         take= 1+ f(ind, T- coins[ind], coins);

//         return Math.min(nottake, take);
//     }
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         int ans= f(n-1, amount, coins);

//         if(ans >= (int)Math.pow(9,8)+7)
//         return -1;

//         return ans;
        
//     }
// }






//memoization

//tc-o(n*t)
//sc-o(n*t)+o(n)

// class Solution {
//     int f(int ind, int T, int coins[], int dp [][]){
//         if(ind==0){
//         if(T%coins[0]==0)
//         return T/coins[0];

//         else return  (int)Math.pow(9,8)+7;

       
//         }
//          if(dp[ind][T] != -1)
//         return dp[ind][T];

//         int nottake= 0+f(ind-1,T, coins, dp);
//         int take = Integer.MAX_VALUE;
//         if(coins[ind]  <= T)
//         take= 1+ f(ind, T- coins[ind], coins, dp);

//         return dp[ind][T] =Math.min(nottake, take);
//     }
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;

//         int dp[][] = new int [n][amount+1];
//         for(int [] row:dp)
//         Arrays.fill(row, -1);

//         int ans= f(n-1, amount, coins,dp);
//         if(ans >=(int)Math.pow(9,8)+7 )
//         return -1;

//         return ans;
        
//     }
// }



// tabulation 


//tc-o(n*t)
//sc-o(n*t)


// class Solution {
    
    
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;

//         int dp[][] = new int [n][amount+1];
        
//         for(int T=0; T<=amount; T++){
//             if(T% coins[0]==0)
//             dp[0][T]= T/coins[0];
//             else dp[0][T] =(int)Math.pow(9,8)+7;
//         }

//         for(int ind = 1; ind <n; ind++){
//             for(int T = 0; T<=amount; T++){

//             int nottake= 0+dp[ind-1][T];
//             int take = Integer.MAX_VALUE;
//             if(coins[ind]  <= T)
//             take= 1+ dp[ind][T-coins[ind]];

//             dp[ind][T] =Math.min(nottake, take);

//             }
//         }

        

//         int ans= dp[n-1][amount];
//         if(ans >=(int)Math.pow(9,8)+7 )
//         return -1;

//         return ans;
        
//     }
// }




//spce optimaization




//tc- o(n*t)
//sc-o(t)





class Solution {
    
    
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int prev [] = new int [amount+1];
        int cur[] = new int [ amount +1];
        
        for(int T=0; T<=amount; T++){
            if(T% coins[0]==0)
            prev[T]= T/coins[0];
            else prev[T] =(int)Math.pow(9,8)+7;
        }

        for(int ind = 1; ind <n; ind++){
            for(int T = 0; T<=amount; T++){

            int nottake= 0+prev[T];
            int take = Integer.MAX_VALUE;
            if(coins[ind]  <= T)
            take= 1+ cur[T-coins[ind]];

            cur[T] =Math.min(nottake, take);

            }

            prev = cur;
        }

        

        int ans= prev[amount];
        if(ans >=(int)Math.pow(9,8)+7 )
        return -1;

        return ans;
        
    }
}