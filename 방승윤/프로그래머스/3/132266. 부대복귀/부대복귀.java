import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            adj[road[0]].add(road[1]);
            adj[road[1]].add(road[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(destination);
        int[] dists = new int[n + 1];
        Arrays.fill(dists, -1);
        int dist = 0;
        dists[destination] = dist;
        
        while (!queue.isEmpty()) {
            dist++;
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                
                for (int to : adj[curr]) {
                    if (dists[to] == -1) {
                        dists[to] = dist;
                        queue.add(to);
                    }
                }
            }
        }
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dists[sources[i]];
        }
        
        return answer;
    }
}