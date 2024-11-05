import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Map<Integer, Integer> map = new HashMap<>();
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		
		for(int tc = 0; tc < T; tc++) {
			int Q = Integer.parseInt(br.readLine());
			minHeap.clear();
			maxHeap.clear();
			map.clear();
			
			for(int to = 0; to < Q; to++) {
				st = new StringTokenizer(br.readLine());
				String operator = st.nextToken();
				
				if(operator.equals("I")) {
					int value = Integer.parseInt(st.nextToken());
					
					minHeap.offer(value);
					maxHeap.offer(value);

					map.put(value, map.get(value) == null ? 1 : map.get(value) + 1);
				} else if(operator.equals("D")) {
					int action = Integer.parseInt(st.nextToken());
					
					if(action == 1) {
						while(!maxHeap.isEmpty()) {
							int value = maxHeap.peek();
							
							if(map.get(value) > 0) {
								maxHeap.poll();
								map.put(value, map.get(value) - 1);
								
								break;
							} else {
								maxHeap.poll();
							}
						}
					} else if(action == -1) {
						while(!minHeap.isEmpty()) {
							int value = minHeap.peek();
							
							if(map.get(value) > 0) {
								minHeap.poll();
								map.put(value, map.get(value) - 1);
								
								break;
							} else {
								minHeap.poll();
							}
						}
						
					}
				}
			}

			while(!maxHeap.isEmpty()) {
				int value = maxHeap.peek();
				
				if(map.get(value) > 0) {
					sb.append(value + " ");
					
					break;
				} else {
					maxHeap.poll();
				}
			}
			
			while(!minHeap.isEmpty()) {
				int value = minHeap.peek();
				
				if(map.get(value) > 0) {
					sb.append(value + " ");
					
					break;
				} else {
					minHeap.poll();
				}
			}

			if(maxHeap.isEmpty() && minHeap.isEmpty()) {
				sb.append("EMPTY");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
