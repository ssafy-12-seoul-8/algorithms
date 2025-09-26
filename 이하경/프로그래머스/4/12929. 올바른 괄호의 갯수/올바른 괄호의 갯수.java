import java.util.*;

class Solution {
    public int solution(int n) {
        int[][] memo = new int[n + 1][n + 1];
        memo[0][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += memo[i - 1][j];
                memo[i][j] = sum;
            }
        }
        
        return memo[n][n];
    }
}