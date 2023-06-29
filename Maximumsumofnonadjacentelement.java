

//Given an array Arr of size N containing positive integers. Find the maximum sum of a subsequence such that no two numbers in the sequence should be adjacent in the array.
//Memoizition
//tc- o(n)
//sc- o(n)

// class Solution {
//     int f(int index, int arr[], int dp[]){
//         if (index==0) return arr[index];
//         if (index<1) return 0;
//         if (dp[index] != -1) return dp[index];
        
//         int pick = arr[index]+ f(index-2,arr, dp);
//         int notpick= 0+f(index-1, arr, dp);
        
//         return dp[index]= Math.max(pick,notpick);
//     }
//     int findMaxSum(int arr[], int n) {
//         // code here
//         n= arr.length;
//         int [] dp = new int[n];
//         Arrays.fill(dp,-1);
//       return f(n-1, arr,dp);
        
        
//     }
// }




// Tabulation 
//tc- o(n)
//sc-o(n)


// class Solution {
//     int f(int n, int arr[], int dp[]){
//           dp[0]=arr[0];
          
//          for(int i = 1; i<n; i++){
//         int pick = arr[i];
//         if (i>1)
//             pick += dp[i-2];
    
//         int notpick= 0+dp[i-1];
         
//         dp[i]= Math.max(pick,notpick);
//     }
//     return dp[n-1];
//     }
//     int findMaxSum(int arr[], int n) {
//         // code here
       
//         int [] dp = new int[n];
//         Arrays.fill(dp,-1);
//       return f(n, arr,dp);
        
        
//     }
// }



//Space optimization

//tc-o(n)
//sc- o(1)



class Solution {
    int f(int n, int arr[], int dp[]){
          int prev=arr[0];
          int prev2 =0;
          
         for(int i = 1; i<n; i++){
        long pick = arr.get[i];
        if (i>1)
            pick += prev2;
    
        int notpick= 0+prev;
         
        int cur_i= Math.max(pick,notpick);
        
        prev2= prev;
        prev =cur_i;
    }
    return prev;
    }
    int findMaxSum(int arr[], int n) {
        // code here
       
        int [] dp = new int[n];
        Arrays.fill(dp,-1);
       return f(n, arr,dp);
        
        
    }
}
