import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(br.readLine());
    	int[][] edges = new int[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		Arrays.fill(edges[i], Integer.MAX_VALUE / 2);
    	}
    	
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		for (int j = 0; j < N; j++) {
    			int edge = Integer.parseInt(st.nextToken());
    			
    			if (edge == 1) {
    				edges[i][j] = edge;
    			}
    				
    		}
    	}
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N ; j++) {
    			for (int k = 0; k < N; k++) {
    				edges[j][k] = Math.min(edges[j][k], edges[j][i] + edges[i][k]);
    			}
    		}
    	}
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			sb.append(edges[i][j] == Integer.MAX_VALUE / 2 ? 0 : 1).append(" ");
    		}
    		
    		sb.append("\n");
    	}
    	
    	System.out.println(sb);
    	
    }
    
}