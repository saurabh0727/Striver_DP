
// Geek wants to climb from the 0th stair to the (n-1)th stair. At a time the Geek can climb either one or two steps. A height[N] array is also given. Whenever the geek jumps from stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. return the minimum energy that can be used by the Geek to jump from stair 0 to stair N-1.

//Tabulation mathod

//tc- o(n)
//sc-o(n)

// class Solution{
//     public int minimumEnergy(int arr[],int N){
//         //code here
//         int [] dp = new int[N];
//         Arrays.fill(dp,-1);
//         dp[0]= 0;
//         for(int ind= 1; ind <N; ind++){
//             int secondstep = Integer.MAX_VALUE;
//             int firststep = dp[ind-1] + Math.abs(arr[ind]- arr[ind-1]);
//             if (ind>1)
//             secondstep = dp[ind-2]+ Math.abs(arr[ind]-arr[ind-2]);
//             dp[ind] = Math.min(firststep, secondstep);
//         }
//         return dp[N-1];
//     }
// }







//Space optimization

//o(n)- tc
//o(1)-sc

class Solution{
    public int minimumEnergy(int arr[],int N){
        //code here
        int prev = 0;
        int prev2 = 0;
        for(int ind= 1; ind <N; ind++){
            int secondstep = Integer.MAX_VALUE;
            int firststep = prev + Math.abs(arr[ind]- arr[ind-1]);
            if (ind>1)
            secondstep = prev2+ Math.abs(arr[ind]-arr[ind-2]);
            int curi = Math.min(firststep, secondstep);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
}