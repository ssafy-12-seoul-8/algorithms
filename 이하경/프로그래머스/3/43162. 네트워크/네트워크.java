import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                answer += 1;
                visit[i] = true;
                q.offer(i);
                
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    
                    for (int j = 0; j < n; j++) {
                        if (!visit[j] && computers[curr][j] == 1) {
                            visit[j] = true;
                            q.offer(j);
                        }
                    }
                    
                }
            }
        }
        
        
        return answer;
    }
}