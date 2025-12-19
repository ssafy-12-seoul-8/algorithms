class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int[] costs = new int[users.length];
        recur(users, emoticons, 0, costs, answer);
        return answer;
    }
    
    void recur(int[][] users, int[] emoticons, int level, int[] costs, int[] answer) {
        if (level == emoticons.length) {
            int cnt = 0;
            int cost = 0;
            
            for (int i = 0; i < costs.length; i++) {
                if (users[i][1] <= costs[i]) {
                    cnt++;
                } else {
                    cost += costs[i];
                }
            }
            
            if (cnt > answer[0]) {
                answer[0] = cnt;
                answer[1] = cost;
            } else if (cnt == answer[0]) {
                answer[1] = Math.max(answer[1], cost);
            }
            
            return;
        }
        
        for (int i = 10; i <= 40; i += 10) {
            for (int j = 0; j < costs.length; j++) {
                if (i >= users[j][0]) {
                    costs[j] += emoticons[level] * (100 - i) / 100;
                }
            }
            
            recur(users, emoticons, level + 1, costs, answer);
            
            for (int j = 0; j < costs.length; j++) {
                if (i >= users[j][0]) {
                    costs[j] -= emoticons[level] * (100 - i) / 100;
                }
            }
            
        }
    }
}