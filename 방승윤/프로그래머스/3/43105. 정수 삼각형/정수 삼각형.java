class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int[] dp = new int[triangle.length];
        
        for (int i = 0; i < dp.length; i++) {
            int[] temp = dp.clone();
            dp[0] += triangle[i][0];
            
            for (int j = 1; j < i + 1; j++) {
                dp[j] = Math.max(temp[j] + triangle[i][j], temp[j - 1] + triangle[i][j]);
            }
        }
        
        for (int i : dp) {
            answer = Math.max(i, answer);
        }
        
        return answer;
    }
}