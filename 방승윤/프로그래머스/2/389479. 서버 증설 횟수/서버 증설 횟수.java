class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] server = new int[24];
        
        for (int i = 0; i < 24; i++) {
            int need = players[i] / m;
            int add = need - server[i];
            
            if (add > 0) {
                answer += add;
            
                for (int j = i; j < 24 && j < i + k; j++) {
                    server[j] += add;
                }
            }
        }
        
        return answer;
    }
}