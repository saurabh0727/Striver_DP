//Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.


//tc-O(N*K) +O(N)
//sc-O(N*K)

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totSum = 0;

        for (int i = 0; i < n; i++) {
            totSum += nums[i];
        }

        if (totSum % 2 == 1)
            return false;
        else {
            int sum = totSum / 2;
            boolean dp[][] = new boolean[n][sum + 1];

            for (int i = 0; i < n; i++)
                dp[i][0] = true;

            if (nums[0] <= sum)
                dp[0][nums[0]] = true;

            for (int ind = 1; ind < n; ind++) {
                for (int target = 1; target <= sum; target++) {
                    boolean notTake = dp[ind - 1][target];
                    boolean take = false;

                    if (target >= nums[ind])
                        take = dp[ind - 1][target - nums[ind]];

                    dp[ind][target] = notTake || take;
                }
            }

            return dp[n - 1][totSum / 2];
        }
    }
}