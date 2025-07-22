import java.util.*;

class Solution {
    static boolean[][][][][] visited;
    static int answer = Integer.MAX_VALUE;

    public int solution(int k, int n, int[][] reqs) {
        visited = new boolean[n - k + 2][n - k + 2][n - k + 2][n - k + 2][n - k + 2];

        if (k == 1) {
            recur(k, n, reqs, new int[] {0, n - k + 1, 0, 0, 0, 0});
        }
        
        if (k == 2) {
            recur(k, n, reqs, new int[] {0, n - k + 1, 1, 0, 0, 0});
        }
        
        if (k == 3) {
            recur(k, n, reqs, new int[] {0, n - k + 1, 1, 1, 0, 0});
        }

        if (k == 4) {
            recur(k, n, reqs, new int[] {0, n - k + 1, 1, 1, 1, 0});
        }

        if (k == 5) {
            recur(k, n, reqs, new int[] {0, n - k + 1, 1, 1, 1, 1});
        }

        return answer;
    }

    public void recur(int k, int n, int[][] reqs, int[] t) {
        visited[t[1]][t[2]][t[3]][t[4]][t[5]] = true;
        int wait = 0;
        PriorityQueue<Integer>[] pq = new PriorityQueue[k + 1];
        
        for (int i = 1; i < k + 1; i++) {
            pq[i] = new PriorityQueue<>();
        }

        for (int[] req : reqs) {
            int a = req[0];
            int b = req[1];
            int c = req[2];
            
            if (pq[c].size() < t[c]) {
                pq[c].add(a + b);
            } else {
                int recent = pq[c].poll();
                
                if (a >= recent) {
                    pq[c].add(a + b);
                } else {
                    pq[c].add(recent + b);
                    wait += recent - a;
                }
            }
        }
        
        answer = Math.min(answer, wait);

        if (t[1] - 1 > 0 && !visited[t[1] - 1][t[2] + 1][t[3]][t[4]][t[5]]) {
            recur(k, n, reqs, new int[] {0, t[1] - 1, t[2] + 1, t[3], t[4], t[5]});
        }

        if (t[3] != 0 && t[1] - 1 > 0 && !visited[t[1] - 1][t[2]][t[3] + 1][t[4]][t[5]]) {
            recur(k, n, reqs, new int[] {0, t[1] - 1, t[2], t[3] + 1, t[4], t[5]});
        }

        if (t[4] != 0 &&t[1] - 1 > 0 && !visited[t[1] - 1][t[2]][t[3]][t[4] + 1][t[5]]) {
            recur(k, n, reqs, new int[] {0, t[1] - 1, t[2], t[3], t[4] + 1, t[5]});
        }

        if (t[5] != 0 && t[1] - 1 > 0 && !visited[t[1] - 1][t[2]][t[3]][t[4]][t[5] + 1]) {
            recur(k, n, reqs, new int[] {0, t[1] - 1, t[2], t[3], t[4], t[5] + 1});
        }
    }
}