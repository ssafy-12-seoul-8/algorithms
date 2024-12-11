import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	int[][] field = new int[n][m];
    	boolean[][] visited = new boolean[n][m];
    	Queue<int[]> queue = new LinkedList<>();
    	
    	for (int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		for (int j = 0; j < m; j++) {
    			int num = Integer.parseInt(st.nextToken());
    			
    			field[i][j] = num;
    			
    			if (num == 2) {
    				queue.offer(new int[] {i, j});
    				field[i][j] = 0;
    				visited[i][j] = true;
    			}
    			
    			if (num == 0) {
    				visited[i][j] = true;
    			}
    		}
    	}
    	
    	int[] dr = {1, -1, 0, 0};
    	int[] dc = {0, 0, 1, -1};
    	int d = 1;
    	
    	while (!queue.isEmpty()) {
    		int repeat = queue.size();
    		
    		for (int i = 0; i < repeat; i++) {
    			int[] curr = queue.poll();
    			
    			for (int j = 0; j < 4; j++) {
    				int nr = curr[0] + dr[j];
    				int nc = curr[1] + dc[j];
    				
    				if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
    					field[nr][nc] = d;
    					queue.offer(new int[] {nr, nc});
    					visited[nr][nc] = true;
    				}
    			}
    		}
    		
    		d++;
    	}
    	
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < m; j++) {
    			if (field[i][j] == 0) {
    				sb.append("0 ");
    				continue;
    			}
    			
    			if (!visited[i][j]) {
    				sb.append("-1 ");
    				continue;
    			}
    			
    			sb.append(field[i][j]).append(" ");
    		}
    		
    		sb.append("\n");
    	}
    	
    	System.out.println(sb);
    	
    }
    
}