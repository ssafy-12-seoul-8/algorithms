import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
			Queue<Integer> minHeap = new PriorityQueue<>();
			int sum = 0;
			
			maxHeap.add(Integer.parseInt(st.nextToken()));
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				
				maxHeap.add(Math.min(first, second));
				minHeap.add(Math.max(first, second));
				
				if (maxHeap.peek() > minHeap.peek()) {
					minHeap.add(maxHeap.poll());
					maxHeap.add(minHeap.poll());
				}
				
				sum = (sum + maxHeap.peek()) % 20171109;
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
	
}