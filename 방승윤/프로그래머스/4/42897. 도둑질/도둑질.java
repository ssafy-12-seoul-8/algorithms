class Solution {
    public int solution(int[] money) {
        int[] dp0 = new int[money.length];
        int[] dp1 = new int[money.length];
        
        dp0[0] = money[0];
        dp0[1] = money[1];
        dp1[1] = money[1];
        dp0[2] = dp0[0] + money[2];
        dp1[2] = money[2];
        
        for (int i = 3; i < dp0.length; i++) {
            dp0[i] = Math.max(dp0[i - 2], dp0[i - 3]) + money[i];
            dp1[i] = Math.max(dp1[i - 2], dp1[i - 3]) + money[i];
        }
        
        return Math.max(Math.max(dp0[dp0.length - 2], dp0[dp0.length - 3]), dp1[dp0.length - 1]);
    }
}