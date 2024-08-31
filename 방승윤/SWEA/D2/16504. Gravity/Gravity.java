import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
    public static void main(String[] args) throws Exception {
		
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuffer sb = new StringBuffer();
    	
    	int T = Integer.parseInt(st.nextToken());
    	
    	for (int tc = 1; tc <= T; tc++) {
    		
    		st = new StringTokenizer(br.readLine());
    		int N = Integer.parseInt(st.nextToken());
    		
    		int[] block = new int[N];
    		int level = 0;
    		int diff = 0;
    		
    		st = new StringTokenizer(br.readLine());
    		
    		for (int i = 0; i < N; i++) {
    			block[i] = Integer.parseInt(st.nextToken());
    		}
    		
    		int[] rotatedBlock = new int[100];
    		
    		for (int i = N - 1; i >= 0; i--) {
    			for (int j = 0; j < block[i]; j++) {
    				if (diff < N - 1 - i - rotatedBlock[j]) {
    					diff = N - 1 - i - rotatedBlock[j];     					
    				}
    				rotatedBlock[j]++;
    			}
    		}
    		
    		sb.append("#").append(tc).append(" ").append(diff).append("\n");
    		
    	}
    	
    	System.out.println(sb);
    	
	}
    
}