import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
    static int min = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= cases; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] heights = new int[n];
            boolean[] visited = new boolean[n];
            st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < n; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
                min += heights[i];
            }
            
            combine(b, heights, visited, 0, 0);
            
            int answer = min - b;
            
            System.out.println("#" + t + " " + answer);
            
            min = 0;
        }
    }
    
    static void combine(int b, int[] heights, boolean[] visited, int current, int sum) {
        if (sum >= b) {
            min = Math.min(sum, min);
            
            return;
        }
        
        for (int i = current; i < heights.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            visited[i] = true;
            
            combine(b, heights, visited, i, sum + heights[i]);
            
            visited[i] = false;
        }
    }

}