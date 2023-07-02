//Given an array arr, partition it into two subsets(possibly empty) such that their union is the original array. Let the sum of the element of these two subsets be S1 and S2. 

//Given a difference d, count the number of partitions in which S1 is greater than or equal to S2 and the difference S1 and S2 is equal to d. since the answer may be large return it modulo 109 + 7.



// recursive


// class Solution{
//         int mode = (int) Math.pow(10,9)+7;
//         int f(int ind , int target, int arr[]){
//             if(ind==0){
//                 if(target ==0 && arr[0]==0)
//                 return 2;
                
//                 if(target ==0 || target == arr[0])
//                 return 1;
//                 return 0;
//             }
            
//           int nottake = f(ind-1, target , arr);
//           int take =0;
           
//           if(arr[ind] <= target )
//           take = f(ind-1, target - arr[ind], arr);
           
//           return (nottake  +take)%mode;
//         }
//     public int countPartitions(int n, int d, int arr[]){
//         // Code here
//         int totsum = 0;
        
//         for(int i = 0; i <arr.length; i++){
//             totsum += arr[i];
            
//         }
        
//         if(totsum -d <0 || (totsum -d) %2 ==1 )
//         return 0;
        
//         int  s2 = (totsum-d)/2;
        
//         return f(n-1, s2, arr);
//     }
// }





// memoization


//tc-o(n*k)
//sc-o(n*k)+o(n)


// class Solution{
//         int mode = (int) Math.pow(10,9)+7;
//         int f(int ind , int target, int arr[], int dp [] []){
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
           
//           return  dp[ind][target]=(nottake  +take)%mode;
//         }
//     public int countPartitions(int n, int d, int arr[]){
//         // Code here
//         int totsum = 0;
        
//         for(int i = 0; i <arr.length; i++){
//             totsum += arr[i];
            
//         }
        
//         if(totsum -d <0 || (totsum -d) %2 ==1 )
//         return 0;
        
//         int  s2 = (totsum-d)/2;
        
//         int dp [][]  = new int[n][s2+1];
//         for(int [] row : dp)
//         Arrays.fill(row, -1);
        
        
//         return f(n-1, s2, arr, dp);
//     }
// }







// tabulation 

//tc-o(n*k)
//sc-o(n*k)


// class Solution{
//         int mode = (int) Math.pow(10,9)+7;
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
           
//              dp[ind][target]=(nottake  +take)%mode; 
//                  }
//              }
            
//             return dp[n-1][tar];
            
           
//         }
//     public int countPartitions(int n, int d, int arr[]){
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
// }




//space optimazation 



//tc-o(n*k)
//sc-0(k)

class Solution{
        int mode = (int) Math.pow(10,9)+7;
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
           
            cur[target]=(nottake  +take)%mode; 
                 }
                 prev =cur;
             }
            
            return prev[tar];
            
           
        }
    public int countPartitions(int n, int d, int arr[]){
        // Code here
        int totsum = 0;
        
        for(int i = 0; i <arr.length; i++){
            totsum += arr[i];
            
        }
        
        if(totsum -d <0 || (totsum -d) %2 ==1 )
        return 0;
        
        int  s2 = (totsum-d)/2;
        
        // int dp [][]  = new int[n][s2+1];
        // for(int [] row : dp)
        // Arrays.fill(row, -1);
        
        
        return f(s2, arr);
    }
}