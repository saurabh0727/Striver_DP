//Given an array arr[] of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

//Note: Answer can be very large, so, output answer modulo 109+7




// class Solution {
//     static final int mod = 1000000007;
    
//     int f(int arr[], int n , int sum,int dp[][]){
//           if (sum == 0) 
//             return 1; // Empty subset
        
//         if(n==0)
//         return (arr[0]==sum)? 1:0;
        
//         if(dp[n][sum] !=-1)
//         return dp[n][sum];
        
//         int notpick= f( arr, n-1, sum%mod,dp);
//         int pick = 0;
        
//         if(arr[n] <= sum)
//         pick = f( arr, n-1, sum-arr[n]%mod,dp)%mod;
        
        
    
    
//     return dp[n][sum]=(notpick%mod+pick%mod)%mod;
//     }

//     public int perfectSum(int arr[], int n, int sum) {
//         // Base cases
        
//         int dp[][]= new int[n+1][sum+1];
//         for(int[] row:dp)
//         Arrays.fill(row,-1);
        
     

//       return f( arr, n-1, sum, dp);
//     }
    
  
// }












// class Solution {
//      static final int mod = 1000000007;
  

//     public int perfectSum(int arr[], int n, int sum) {
//         // Base cases
        
//         int dp[][]= new int[n][sum+1];
        
        
//         for ( int i =0; i<n; i++){
//         dp[i][0]=1;
//         }
        
//         if(arr[0] <= sum)  dp[0][arr[0]]=1;
        
//         for(int ind =1; ind<n; ind++){
            
//             for(int tar=0; tar <=sum; tar ++){
                
//                 int notpick = dp[ind-1][tar];
//                 int pick =0;
                
//                 if(arr[ind] <= tar)  
//                 pick = dp[ind-1][tar-arr[ind]];
                
//             dp[ind][tar]=(notpick +pick)% mod;
//             }
//         }
     

//       return dp[n-1][sum];
//     }
    
  
// }











// class Solution {
//     static final int mod = 1000000007;

//     public int perfectSum(int arr[], int n, int sum) {
//         int dp[][] = new int[n][sum + 1];

//         for (int i = 0; i < n; i++) {
//             dp[i][0] = 1;
//         }

//         if (arr[0] <= sum) {
//             dp[0][arr[0]] = 2;
//         }

//         for (int ind = 1; ind < n; ind++) {
//             for (int tar = 0; tar <= sum; tar++) {
//                 int notpick = dp[ind - 1][tar];
//                 int pick = 0;

//                 if (arr[ind] <= tar) {
//                     pick = dp[ind - 1][tar - arr[ind]];
//                 }

//                 dp[ind][tar] = (notpick + pick) % mod;
//             }
//         }

//         return dp[n - 1][sum];
//     }
// }




//tc-o(n*k)
//tc- o(n*k) + o(n)


public class Solution {
    static int mod = (int) 1e9 + 7;

    static int func(int ind, int sum, int[] arr, int[][] dp) {
        if (ind < 0)
            return sum == 0 ? 1 : 0;

        if (dp[ind][sum] != -1)
            return dp[ind][sum];

        int pick = 0;
        if (arr[ind] <= sum) {
            pick = func(ind - 1, (sum - arr[ind]) % mod, arr, dp) % mod;
        }

        int notPick = func(ind - 1, sum % mod, arr, dp) % mod;

        return dp[ind][sum] = (pick % mod + notPick % mod) % mod;
    }

    public static int perfectSum(int arr[], int n, int sum) {
        int[][] dp = new int[n][sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return func(n - 1, sum, arr, dp) % mod;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int n = 6;
        int sum = 10;
        System.out.println(perfectSum(arr, n, sum)); // Output: 3
    }
}





