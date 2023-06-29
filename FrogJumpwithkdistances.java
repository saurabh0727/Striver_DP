//There are n stones and an array of heights and Geek is standing at stone 1 and can jump to one of the following: Stone i+1, i+2, ... i+k stone and cost will be [hi-hj] is incurred, where j is the stone to land on. Find the minimum possible total cost incurred before the Geek reaches Stone N.


//TC- O(n*k)
//SC - O(n)
class Solution {
    public int minimizeCost(int arr[], int N, int K) {
        int[] dp = new int[N];
        dp[0] = 0;

        for (int i = 1; i < N; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i - 1; j >= Math.max(i - K, 0); j--) {
                dp[i] = Math.min(dp[i], dp[j] + Math.abs(arr[i] - arr[j]));
            }
        }

        return dp[N - 1];
    }
}
