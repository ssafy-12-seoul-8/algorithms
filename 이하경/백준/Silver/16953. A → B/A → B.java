import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        System.out.println(operation(a, b));
    }
    
    public static int operation(int a, int b) {
    	Queue<int[]> q = new LinkedList<>();
    	q.offer(new int[] { a, 0 });
    	
    	while (!q.isEmpty()) {
    		int[] cur = q.poll();
    		int num = cur[0];
    		int cnt = cur[1];
    		
    		if (num <= 500_000_000) {
    			int next = num * 2;
    			
    			if (next == b) {
    				return cnt + 2;
    			}
    			
    			q.offer(new int[] { next, cnt + 1 });
    		}
    		if (num <= 100_000_000) {
    			int next = num * 10 + 1;
    			
    			if (next == b) {
    				return cnt + 2;
    			}
    			
    			q.offer(new int[] { next, cnt + 1 });
    		}
    	}
    	
    	return -1;
    	
    }
}
