import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = n;
        
        int[][] dp = new int[info.length][m];
        
        for (int i = 0; i < info.length; i++) {
            Arrays.fill(dp[i], n);
        }
        
        dp[0][0] = info[0][0];
        
        if (info[0][1] < m) {
            dp[0][info[0][1]] = 0;
        }
        
        for (int i = 1; i < info.length; i++) {
            for (int j = 0; j < m; j++) {
                if (j < info[i][1]) {
                    dp[i][j] = dp[i - 1][j] + info[i][0];
                    continue;
                }
                
                dp[i][j] = Math.min(dp[i - 1][j] + info[i][0], dp[i - 1][j - info[i][1]]);
            }
        }
        
        for (int i = 0; i < m; i++) {
            answer = Math.min(dp[info.length - 1][i], answer);
        }
        
        return answer >= n ? -1 : answer;
    }
}