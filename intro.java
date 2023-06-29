
//Geek is learning data structures, and he recently learned about the top-down and bottom-up dynamic programming approaches. Geek is having trouble telling them apart from one another.
// TC- O(N)
//SC- O(N) + O(N)


class Solution {
    static long topDown(int n) {
        if (n <= 1)
            return n;
        long[] dp = new long[n + 1];
        return fibTopDown(n, dp);
    }

    static long fibTopDown(int n, long[] dp) {
        if (n <= 1)
            return n;
        if (dp[n] != 0)
            return dp[n];
        dp[n] = (fibTopDown(n - 1, dp) + fibTopDown(n - 2, dp)) % (1000000007);
        return dp[n];
    }

    static long bottomUp(int n) {
        if (n <= 1)
            return n;
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % (1000000007);
        }
        return dp[n];
    }
}
