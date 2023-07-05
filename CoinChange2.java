
//You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

//Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

//You may assume that you have an infinite number of each kind of coin.

//The answer is guaranteed to fit into a signed 32-bit integer.






//recursive


//tc- exponential
//sc= >> o(n)


// class Solution {
//     int f(int ind, int T , int arr[]){
//         if(ind==0){
//             return (T%arr[0]==0)?1:0;
//         }
//         int  nottake = f(ind-1, T,arr);
//         int take=0;
//         if(arr[ind] <=T)
//         take= f(ind, T- arr[ind], arr);

//         return nottake+take;
//     }
//     public int change(int amount, int[] coins) {
//         int n = coins.length;
//         return f(n-1, amount, coins);
//     }
// }




//memoization


//tc-0(n*t)
//sc-o(n*t)+o(n)

// class Solution {
//     int f(int ind, int T , int arr[],int dp [][]){
//         if(ind==0){
//             return (T%arr[0]==0)?1:0;
//         }
//         if(dp[ind][T] !=-1)
//         return dp[ind][T];

//         int  nottake = f(ind-1, T,arr,dp);
//         int take=0;
//         if(arr[ind] <=T)
//         take= f(ind, T- arr[ind], arr,dp);

//         return dp[ind][T]= nottake+take;
//     }
//     public int change(int amount, int[] coins) {
//         int n = coins.length;
//         int dp[][]= new int [n][amount+1];
//         for(int row[] :dp)
//         Arrays.fill(row, -1);
        
//         return f(n-1, amount, coins,dp);
//     }
// }




//tabulation


//tc-o(n*t)
//sc-o(n*t)

// class Solution {
   
//     public int change(int amount, int[] coins) {
//         int n = coins.length;
//         int dp[][]= new int [n][amount+1];
//         for(int i = 0; i<=amount; i++){
//             dp[0][i]= (i%coins[0]==0)?1:0;
//         }

//         for(int ind =1; ind<n; ind++){
//             for(int target =0; target <=amount ; target++){

//                 int nottake= dp[ind-1][target];
//                 int take=0;
//                 if(coins[ind] <= target )
//                 take= dp[ind][target - coins[ind]];

//                 dp[ind][target]= nottake +take;
//             }
//         }
//         return dp [n-1][amount];
//     }
// }




//space optimaization

//tc-o(n*t)
//sc-o(t)


class Solution {
   
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int prev[]= new int[amount+1];
        for(int i = 0; i<=amount; i++){
            if(i%coins[0]==0)
            prev[i]= 1;
        }

        for(int ind =1; ind<n; ind++){
            int cur[] =new int [amount+1];
            for(int target =0; target <=amount ; target++){

                int nottake=prev[target];
                int take=0;
                if(coins[ind] <= target )
                take= cur[target - coins[ind]];

                cur[target]= nottake +take;
            }
           prev =cur;
        }
        return prev[amount];
    }
}