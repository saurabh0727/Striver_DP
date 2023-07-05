//Given a rod of length N inches and an array of prices, price[]. price[i] denotes the value of a piece of length i. Determine the maximum value obtainable by cutting up the rod and selling the pieces.





//recurence

//tc- exponential
//sc-o(target)


// class Solution{
//     int f(int ind, int n, int price[]){
//         if(ind==0){
//             return (n*price[0]);
//         }
        
//         int nottake = 0+f(ind-1, n, price);
//         int take = Integer.MIN_VALUE;
//         int rodlength= ind+1;
//         if(rodlength <=n)
//         take= price[ind]+f(ind, n-rodlength, price);
        
//         return Math.max(nottake, take);
//     }
//     public int cutRod(int price[], int n) {
//         //code here
//         return f(n-1,n, price);
//     }
// }





//memoization


//tc-o(n*n)
//sc-o(n*n)+o(n)

// class Solution{
//     int f(int ind, int n, int price[], int dp[][]){
//         if(ind==0){
//             return (n*price[0]);
//         }
//         if(dp[ind][n] !=-1)
//         return dp[ind][n];
        
//         int nottake = 0+f(ind-1, n, price,dp);
//         int take = Integer.MIN_VALUE;
//         int rodlength= ind+1;
//         if(rodlength <=n)
//         take= price[ind]+f(ind, n-rodlength, price,dp);
        
//         return dp[ind][n]=Math.max(nottake, take);
//     }
//     public int cutRod(int price[], int n) {
        
//         int dp [][] = new int[n][n+1];
//         for(int[] row: dp)
//         Arrays.fill(row, -1);
        
//         //code here
//         return f(n-1,n, price,dp);
//     }
// }




// tabualtion

//tc- o(n*n)
//sc-o(n*n)


// class Solution{
    
    
//     public int cutRod(int price[], int n) {
        
//         int dp [][] = new int[n][n+1];
//         for(int row[]:dp)
//     Arrays.fill(row,-1);
    
//         for(int i =0; i<=n; i++){
//             dp[0][i]=i*price[0];
//         }
//         for(int ind =1; ind<n; ind++){
//             for(int cap=0; cap<=n; cap++){
                
//                 int nottake =0+dp[ind-1][cap];
//                 int take= Integer.MIN_VALUE;
//                 int rodlength= ind+1;
//                 if(rodlength<=cap)
//                 take=price[ind]+dp[ind][cap-rodlength];
                
//                 dp[ind][cap]= Math.max(nottake, take);
//             }
//         }
        
//         //code here
//         return dp[n-1][n];
//     }
// }





//space optimaization




// class Solution{
    
    
//     public int cutRod(int price[], int n) {
        
//         int prev []= new int [n+1];
    
//         for(int i =0; i<=n; i++){
//             prev[i]=i*price[0];
//         }
//         for(int ind =1; ind<n; ind++){
//             int cur[]= new int [n+1];
//             for(int cap=0; cap<=n; cap++){
                
//                 int nottake =0+prev[cap];
//                 int take= Integer.MIN_VALUE;
//                 int rodlength= ind+1;
//                 if(rodlength<=cap)
//                 take=price[ind]+cur[cap-rodlength];
                
//                 cur[cap]= Math.max(nottake, take);
//             }
//             prev = cur;
//         }
        
//         //code here
//         return prev[n];
//     }
// }







// class Solution{
    
    
//     public int cutRod(int price[], int n) {
        
//         int prev []= new int [n+1];
    
//         for(int i =0; i<=n; i++){
//             prev[i]=i*price[0];
//         }
//         for(int ind =1; ind<n; ind++){
//             int cur[]= new int [n+1];
//             for(int cap=0; cap<=n; cap++){
                
//                 int nottake =0+prev[cap];
//                 int take= Integer.MIN_VALUE;
//                 int rodlength= ind+1;
//                 if(rodlength<=cap)
//                 take=price[ind]+prev[cap-rodlength];
                
//                 prev[cap]= Math.max(nottake, take);
//             }
            
//         }
        
//         //code here
//         return prev[n];
//     }
// }