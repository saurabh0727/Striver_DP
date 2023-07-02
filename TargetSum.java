//You are given an integer array nums and an integer target.

//You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

//For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
//Return the number of different expressions that you can build, which evaluates to target.

 

//memoization

//tc -o(n*k)
//sc-o(n*k) +o(n)





//  class Solution {
// int f(int ind , int target, int arr[], int dp [] []){
//             if(ind==0){
//                 if(target ==0 && arr[0]==0)
//                 return 2;
                
//                 if(target ==0 || target == arr[0])
//                 return 1;
//                 return 0;
//             }
            
//             if(dp[ind][target] != -1)
//             return dp[ind][target];
            
//           int nottake = f(ind-1, target , arr, dp);
//           int take =0;
           
//           if(arr[ind] <= target )
//           take = f(ind-1, target - arr[ind], arr, dp);
           
//           return  dp[ind][target]=(nottake  +take);
//         }
    
//     public int findTargetSumWays(int[] nums, int target) {
//         int n = nums.length;

//          int totsum = 0;
        
//         for(int i = 0; i <nums.length; i++){
//             totsum += nums[i];
            
//         }
        
//         if(totsum -target <0 || (totsum -target) %2 ==1 )
//         return 0;
        
//         int  s2 = (totsum-target)/2;
        
//         int dp [][]  = new int[n][s2+1];
//         for(int [] row : dp)
//         Arrays.fill(row, -1);
        
        
//         return f(n-1, s2, nums, dp);
        
//     }
// }





//tabulation

//tc-o(n*k)
//sc-o(n*k)

//   class Solution{ 
//         int f( int tar, int arr[]){
            
//             int n = arr.length;
//             int dp[][] = new int [n][tar +1];
            
//             if(arr[0] ==0)
//             dp[0][0]=2;
            
//             else dp[0][0]=1;
            
//             if(arr[0] !=0 && arr[0] <=tar)
//             dp[0][arr[0]]=1;
            
            
//              for(int ind = 1; ind <n; ind++){
//                  for(int target = 0 ; target <= tar; target++){
                     
//                     int nottake = dp[ind-1][target];
//                     int take =0;
           
//                     if(arr[ind] <= target )
//                       take = dp[ind-1][target - arr[ind]];
           
//              dp[ind][target]=(nottake  +take); 
//                  }
//              }
            
//             return dp[n-1][tar];
            
           
//         }
//           public int findTargetSumWays(int[] nums, int target) {
//         int n = nums.length;

//          int totsum = 0;
        
//         for(int i = 0; i <nums.length; i++){
//             totsum += nums[i];
            
//         }
        
//         if(totsum -target <0 || (totsum -target) %2 ==1 )
//         return 0;
        
//         int  s2 = (totsum-target)/2;
        
        
        
        
//         return f(s2,nums);
        
//     }
// }

  

  //space optimazation 

  //tc-o(n*k)
  //sc-o(k)
  
  class Solution{ 
        int f( int tar, int arr[]){
            
            int n = arr.length;
            int prev [] = new int[tar+1];
            
            
            if(arr[0] ==0)
            prev[0]=2;
            
            else prev[0]=1;
            
            if(arr[0] !=0 && arr[0] <=tar)
            prev[arr[0]]=1;
            
            
             for(int ind = 1; ind <n; ind++){
                 int cur[] = new int [tar+1];
                 for(int target = 0 ; target <= tar; target++){
                     
                    int nottake = prev[target];
                    int take =0;
           
                    if(arr[ind] <= target )
                      take = prev[target - arr[ind]];
           
            cur[target]=(nottake  +take); 
                 }
                 prev =cur;
             }
            
            return prev[tar];
            
           
        }
          public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

         int totsum = 0;
        
        for(int i = 0; i <nums.length; i++){
            totsum += nums[i];
            
        }
        
        if(totsum -target <0 || (totsum -target) %2 ==1 )
        return 0;
        
        int  s2 = (totsum-target)/2;
        
        
        
        
        return f(s2,nums);
        
    }
}


//space optimaization2



// class Solution {
//       int f( int tar, int arr[]){
            
//             int n = arr.length;
//             int prev [] = new int[tar+1];
            
            
//             if(arr[0] ==0)
//             prev[0]=2;
            
//             else prev[0]=1;
            
//             if(arr[0] !=0 && arr[0] <=tar)
//             prev[arr[0]]=1;
            
            
//              for(int ind = 1; ind <n; ind++){
//                  int cur[] = new int [tar+1];
//                  for(int target = 0 ; target <= tar; target++){
                     
//                     int nottake = prev[target];
//                     int take =0;
           
//                     if(arr[ind] <= target )
//                       take = prev[target - arr[ind]];
           
//             cur[target]=(nottake  +take); 
//                  }
//                  prev =cur;
//              }
            
//             return prev[tar];
            
           
//         }
//      public int countPartitions(int n, int d, int arr[]){
//         // Code here
//         int totsum = 0;
        
//         for(int i = 0; i <arr.length; i++){
//             totsum += arr[i];
            
//         }
        
//         if(totsum -d <0 || (totsum -d) %2 ==1 )
//         return 0;
        
//         int  s2 = (totsum-d)/2;
        
//         // int dp [][]  = new int[n][s2+1];
//         // for(int [] row : dp)
//         // Arrays.fill(row, -1);
        
        
//         return f(s2, arr);
//     }
//     public int findTargetSumWays(int[] nums, int target) {
//         int n = nums.length;

//         return countPartitions(n, target, nums);
        
//     }
// }