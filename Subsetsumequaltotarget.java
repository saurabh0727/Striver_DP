
//Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 





//MEMOIZATION METHOD

//tc-o(n*k)
//sc-o(n*k)+o(n)

// class Solution{
    
//     static Boolean f(int ind, int target, int arr[],int dp[][]){
//         if(target==0)
//         return true;
        
//         if(ind==0)
//         return arr[0]==target;
        
//         if(dp[ind][target] != -1)
//         return dp[ind][target]==0?false:true;
        
//         Boolean nottake = f(ind-1,target, arr,dp);
        
//         Boolean take= false;
        
//         if(target>=arr[ind])
//         take = f(ind-1,target-arr[ind],arr,dp);
        
//         dp[ind][target]= nottake || take?1:0;
//         return nottake || take;
//     }


//     static Boolean isSubsetSum(int N, int arr[], int sum){
        
        
        
        
//         int dp[][]  = new int[N][sum+1];
//         for(int[] row: dp)
//         Arrays.fill(row,-1);
        
     
//         return f(N-1, sum, arr,dp);
        
//         // code here
//     }
// }




//TABULATION METHOD

//tc-o(n*k)
//sc-o(n*k)



class Solution{
    
    

    static Boolean isSubsetSum(int N, int arr[], int sum){
        
        
        
        
        boolean dp[][]  = new boolean[N][sum+1];
        
        for(int i =0; i<N-1 ; i++){
        dp[i][0] = true;
        }
        
        if(arr[0]<sum)
        dp[0][arr[0]] =true;
        
        
        for(int ind =1; ind<N; ind++){
            for(int target =1; target <=sum; target++){
                
        Boolean nottake = dp[ind-1][target];
        
        Boolean take= false;
        
        if(target>=arr[ind])
        take = dp[ind-1][target-arr[ind]];
        
        dp[ind][target]= nottake || take;
            }
        }
            
        
        
     
        return dp[N-1][sum];
        
        // code here
    }
}





//SPACE OPTIMAZATIONN




//tc-o(n*k)
//sc-o(n)


class Solution{
    
    

    static Boolean isSubsetSum(int N, int arr[], int sum){
        
        
        
        
        boolean prev[] =new boolean[sum+1];
        
        
        prev[0]=true;
        
        if(arr[0]<=sum)
        prev[arr[0]]=true;
        
        
        
        
        for(int ind =1; ind<N; ind++){
            boolean cur[]= new boolean[sum+1];
            cur[0] =true;
            for(int target =1; target <=sum; target++){
                
        Boolean nottake = prev[target];
        
        Boolean take= false;
        
        if(target>=arr[ind])
        take = prev[target-arr[ind]];
        
        cur[target]= nottake || take;
            }
            
            prev= cur;
        }
            
        
        
     
        return prev[sum];
        
        // code here
    }
}
