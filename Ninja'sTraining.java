//Geek is going for n days training program, he can perform any one of these three activities Running, Fighting, and Learning Practice. Each activity has some point on each day. as Geek wants to improve all his skills, he can't do the same activity on two consecutive days, help Geek to maximize his merit points as we were given a 2D array of n*3 points corresponding to each day and activity.

//Memoization method

//tc-o(n*4*3)
//sc-o(n)+o(n*4)


// class Solution{
//     int f(int day , int last, int points[][], int [] [] dp){
//         if (dp[day][last] != -1)
//         return dp[day][last];
//         if(day==0){
//             int maxi = 0;
//             for(int task =0; task <=2 ; task++){
//                 if(task != last)
//                     maxi = Math.max(maxi, points[0][task]);
                    
//                 }
            
//             return dp[day][last]= maxi;
//         }
        
        
//         int maxi = 0; 
//         for(int task = 0; task <=2; task++){
//             if (task != last){
//                 int point = points[day][task]+ f(day-1 , task, points, dp);
//                 maxi = Math.max(maxi, point);
//             }
//         }
//         return dp[day][last]= maxi;
//     }
//     public int maximumPoints(int points[][],int N){
//         int [][] dp = new int[N][4];
//         for (int[] row: dp)
//         Arrays.fill(row, -1);
        
//       return  f(N-1,3 , points, dp);
//         //code here
//     }
// }


// Tabulation 

//tc-o(n*4*3)
//sc-o(n*4)

// class Solution{
  
        
       
//     public int maximumPoints(int points[][],int N){
//          int[][] dp = new int[N][4];
//             dp[0][0]=Math.max(points[0][1],points[0][2]);
//             dp[0][1]=Math.max(points[0][0],points[0][2]);
//             dp[0][2]=Math.max(points[0][0],points[0][1]);
//             dp[0][3]=Math.max(points[0][0],Math.max(points[0][1],points[0][2]));
//             for(int day= 1; day<N;day++){
//                 for(int last =0; last <4; last++){
//                     dp[day][last]=0;;
//                     for (int task =0; task<=2; task++){
                        
//                         if(task !=last){
//                             int point =points[day][task] +dp[day-1][task];
//                             dp[day][last]=Math.max(dp[day][last],point);
//                         }
//                     }
//                 }
//             }
//             return dp[N-1][3];
//     }
// }

///space optimIZATION

//tc-o(n*4*3)
//o(4)


class Solution{
  
        
       
    public int maximumPoints(int points[][],int N){
         int prev[]= new int[4];
            prev[0]=Math.max(points[0][1],points[0][2]);
            prev[1]=Math.max(points[0][0],points[0][2]);
            prev[2]=Math.max(points[0][0],points[0][1]);
            prev[3]=Math.max(points[0][0],Math.max(points[0][1],points[0][2]));
            for(int day= 1; day<N;day++){
                 int temp[] = new int[4];
                for(int last =0; last <4; last++){
                    temp[last]=0;
                    for (int task =0; task<=2; task++){
                        
                        if(task !=last){
                            temp[last] =Math.max(temp[last],points[day][task]+prev[task]);
                           
                        }
                    }
                }
                prev =temp;
            }
            return prev[3];
    }
}