import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < T; tc++) {
        	int k = Integer.parseInt(br.readLine());
        	PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        	PriorityQueue<Integer> maxPQ = new PriorityQueue<>(new Comparator<Integer>() {
        		@Override
        		public int compare(Integer o1, Integer o2) {
        			if (o2 > o1) {
        				return 1;
        			} else if (o2 == o1) {
        				return 0;
        			} else {
        				return -1;
        			}
        		}
			});
        	PriorityQueue<Integer> checkMin = new PriorityQueue<>();
        	PriorityQueue<Integer> checkMax = new PriorityQueue<>(new Comparator<Integer>() {
        		@Override
        		public int compare(Integer o1, Integer o2) {
        			if (o2 > o1) {
        				return 1;
        			} else if (o2 == o1) {
        				return 0;
        			} else {
        				return -1;
        			}
        		}
        	});
        	
        	for (int i = 0; i < k; i++) {
        		st = new StringTokenizer(br.readLine());
        		
        		if (st.nextToken().equals("I")) {
        			int num = Integer.parseInt(st.nextToken());
        			minPQ.offer(num);
        			maxPQ.offer(num);
        		} else if(checkMax.size() != maxPQ.size() || checkMin.size() != minPQ.size()) {
        			if (st.nextToken().equals("1")) { 
        				while (!checkMax.isEmpty() && maxPQ.peek().equals(checkMax.peek())) {
        					maxPQ.poll();
        					checkMax.poll();
        				}
        				
        				checkMin.offer(maxPQ.poll());
        			} else {
        				while (!checkMin.isEmpty() && minPQ.peek().equals(checkMin.peek())) {
        					minPQ.poll();
        					checkMin.poll();
        				}
        				
        				checkMax.offer(minPQ.poll());
        			}
        		}
        	}
        	while (!checkMax.isEmpty() && maxPQ.peek().equals(checkMax.peek())) {
				maxPQ.poll();
				checkMax.poll();
			}
        	
        	while (!checkMin.isEmpty() && minPQ.peek().equals(checkMin.peek())) {
				minPQ.poll();
				checkMin.poll();
			}
        	
        	if (maxPQ.isEmpty()) {
        		sb.append("EMPTY\n");
        	} else {
        		sb.append(maxPQ.poll()).append(" ").append(minPQ.poll()).append("\n");
        	}
        }
        
        System.out.println(sb);
        
    }
    
}