//Given an array arr of size n containing non-negative integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum and find the minimum difference

//tc-o(n*totsum)
//sc-o(n*totsum)

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    // Calculate the total sum of the array
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        // Create a boolean array to store the solutions
        boolean[][] dp = new boolean[n + 1][totalSum + 1];

        // Initialize the first column as true
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Initialize the first row except for the first element as false
        for (int j = 1; j <= totalSum; j++) {
            dp[0][j] = false;
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalSum; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        // Find the minimum difference between the two sets
        int minDiff = Integer.MAX_VALUE;
        for (int j = totalSum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                minDiff = totalSum - 2 * j;
                break;
            }
        }

        return minDiff;
	} 
}
