public class ClimbingStairs {

    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     *
     *     Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     *
     *
     *     Example 1:
     *
     *     Input: n = 2
     *     Output: 2
     *     Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     *     Example 2:
     *
     *     Input: n = 3
     *     Output: 3
     *     Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     *
     *     Constraints:
     *
     *             1 <= n <= 45
     */

    public static void main(String[] args) {
        System.out.println(climbStairs(6));
    }

    public static int climbStairs(int n) {

        int dp[] = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }

        if(n <2){
            return 1;
        }

//        int ans = solve(n-1, dp) + solve(n-2, dp);

        int ans = solveUsingTabulation(n);

        return ans;
    }

    public static int solve(int size, int []dp){

        if (size == 0) {
            return 1;
        }

        if (size == 1){
            return 1;
        }

        if(dp[size] != -1){
            return dp[size];
        }

        dp[size] = solve(size-1, dp) + solve(size-2, dp);

        return dp[size];

    }

    public static int solveUsingTabulation(int n){
        //Step 1 : Creation of dp[]
        int dp[] = new int[n+1];

        //Step 2 : Base case intialization
        dp[0] = 1;
        dp[1] = 1;

        //Step 3 : Calculate the remaining cases
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }


}
