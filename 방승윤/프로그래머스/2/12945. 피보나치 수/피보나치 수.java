class Solution {
    public int solution(int n) {
        int[] dp = new int[100001];
        dp[1] = 1;
        
        for (int i = 2; i <= 100000; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }
        
        return dp[n];
    }
}