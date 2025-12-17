import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemies) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        one: for (int enemy : enemies) {
            n -= enemy;
            pq.add(enemy);
            
            while (n < 0) {
                if (k > 0) {
                    k--;
                    n += pq.poll();
                } else {
                    break one;
                }
            }
            
            answer++;
        }
        
        return answer;
    }
}