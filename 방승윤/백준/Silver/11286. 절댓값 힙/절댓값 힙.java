import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();

    	int N = Integer.parseInt(br.readLine());
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
    		@Override
    		public int compare(Integer o1, Integer o2) {
    			if (Math.abs(o1) == Math.abs(o2)) {
    				return o1 - o2;
    			}
    			
    			return Math.abs(o1) - Math.abs(o2);
    		}
		});
    	
    	for (int i = 0; i < N; i++) {
    		int x = Integer.parseInt(br.readLine());
    		
    		if (x == 0) {	
    			sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
    			continue;
    		}
    		
    		pq.offer(x);
    	}
    	
    	System.out.println(sb);
    	
    }
    
}