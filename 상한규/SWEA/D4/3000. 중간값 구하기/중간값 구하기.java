import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		int T = Integer.parseInt(br.readLine());
		long[] result = new long[T];

		for(int i = 0; i < T; i++) {
			StringTokenizer nAndFirst = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(nAndFirst.nextToken());
			long firstNumber = Long.parseLong(nAndFirst.nextToken());
			
			PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Long> minHeap = new PriorityQueue<>();
			
			// maxHeap 5 삽입
			maxHeap.offer(firstNumber);
			
			for(int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				Long one = Long.parseLong(st.nextToken());					
				Long two = Long.parseLong(st.nextToken());			
				
				// maxHeap 3, minHeap 1삽입
				maxHeap.offer(Math.max(one, two));
				minHeap.offer(Math.min(one, two));
				
				long max = maxHeap.poll();
				long min = minHeap.poll();
				
				maxHeap.offer(min);
				minHeap.offer(max);
				result[i] =(result[i] + maxHeap.peek()) %  20171109L;
			}
		}
		for(int i = 0; i < result.length; i++) {
			System.out.printf("#%d %d\n", i + 1, result[i]);
		}
	}
}
