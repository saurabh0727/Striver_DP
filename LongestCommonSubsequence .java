//Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

//A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.




// class Solution {
//     int f(int ind1 ,int ind2,String text1, String text2){
//         if(ind1<0 || ind2<0){
//             return 0;
//         }
//         if(text1.charAt(ind1)==text2.charAt(ind2)){
//             return 1+f(ind1-1, ind2-1, text1, text2);
//         }
//         else{
//             return Math.max(f(ind1-1, ind2, text1, text2), f(ind1, ind2-1, text1, text2));
//         }
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();
        
        
//         return f(n-1, m-1, text1 ,text2);
        
//     }
// }



//memoization

//tc- o(n*m)
//sc-o(n*m)+o(n+m)

// class Solution {
//     int f(int ind1 ,int ind2,String text1, String text2, int dp[][]){
//         if(ind1<0 || ind2<0){
//             return 0;
//         }

//         if(dp[ind1][ind2] != -1)
//         return dp[ind1][ind2];


//         if(text1.charAt(ind1)==text2.charAt(ind2)){
//             return 1+f(ind1-1, ind2-1, text1, text2, dp);
//         }
//         else{
//             return dp[ind1][ind2]= Math.max(f(ind1-1, ind2, text1, text2, dp), f(ind1, ind2-1, text1, text2, dp));
//         }
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();

//         int dp[][] = new int [n][m];
//         for(int [] row : dp)
//         Arrays.fill(row, -1);
        
    
        
//         return f(n-1, m-1, text1 ,text2, dp);
        
//     }
// }





// class Solution {
//     int f(int ind1 ,int ind2,String text1, String text2, int dp[][]){
//         if(ind1==0 || ind2==0){
//             return 0;
//         }

//         if(dp[ind1][ind2] != -1)
//         return dp[ind1][ind2];


//         if(text1.charAt(ind1-1)==text2.charAt(ind2-1)){
//             return 1+f(ind1-1, ind2-1, text1, text2, dp);
//         }
//         else{
//             return dp[ind1][ind2]= Math.max(f(ind1-1, ind2, text1, text2, dp), f(ind1, ind2-1, text1, text2, dp));
//         }
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();

//         int dp[][] = new int [n+1][m+1];
//         for(int [] row : dp)
//         Arrays.fill(row, -1);
        
    
        
//         return f(n, m, text1 ,text2, dp);
        
//     }
// }






//tabulation


//tc- o(n*m)
//sc-o(n*m)


// class Solution {
   
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();

//         int dp[][] = new int [n+1][m+1];

//         for(int j = 0 ; j<= m-1; j++) dp[0][j]=0;
//         for(int i = 0; i<= n-1; i++) dp[i][0]=0;

//         for(int i =1; i<=n; i++){
//             for(int j=1; j<=m; j++){
//                  if(text1.charAt(i-1)==text2.charAt(j-1)){
//                 dp[i][j]= 1+dp[i-1][j-1];
//         }
//         else{
//              dp[i][j]= 0+Math.max (dp[i-1][j],dp[i][j-1]);
//         }
//             }
//         }
    
//         return dp[n][m];
    
        
        
        
//     }
// }





//space optimaization



//tc-o(n*m)
//sc - o(m)



class Solution {
   
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int prev [] = new int[m+1];
        int cur [] =new int [m+1];

        for(int j = 0 ; j<= m-1; j++) prev[j]=0;
        

        for(int i =1; i<=n; i++){
            for(int j=1; j<=m; j++){
                 if(text1.charAt(i-1)==text2.charAt(j-1)){
                cur[j]= 1+prev[j-1];
        }
        else
             cur[j]= 0+Math.max (prev[j],cur[j-1]);
        }

       prev = cur.clone();
            }
        
    
        return prev[m];
    
    
    }
}

