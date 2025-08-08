import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = n;
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                queue.add(i);
                
                while(!queue.isEmpty()) {
                    int num = queue.poll();
                    
                    for(int j = 0; j < n; j++) {
                        if (computers[num][j] == 1) {
                            if (visited[j] == false) {
                                visited[j] = true;
                                queue.add(j);
                                answer--;
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}