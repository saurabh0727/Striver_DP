//You are given two strings s and t. Now your task is to print all longest common sub-sequences in lexicographical order.





class Solution {
    private Set<String> allLCS;

    public List<String> all_longest_common_subsequences(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];

        // Calculate the length of the longest common subsequence
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        allLCS = new HashSet<>();
        generateAllLCS(dp, s, t, m, n, "");
        List<String> result = new ArrayList<>(allLCS);
        Collections.sort(result);
        return result;
    }

    private void generateAllLCS(int[][] dp, String s, String t, int i, int j, String current) {
        if (i == 0 || j == 0) {
            allLCS.add(new StringBuilder(current).reverse().toString());
            return;
        }

        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            generateAllLCS(dp, s, t, i - 1, j - 1, current + s.charAt(i - 1));
        } else {
            if (dp[i - 1][j] >= dp[i][j - 1]) {
                generateAllLCS(dp, s, t, i - 1, j, current);
            }
            if (dp[i][j - 1] >= dp[i - 1][j]) {
                generateAllLCS(dp, s, t, i, j - 1, current);
            }
        }
    }
}