import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			boolean result = true;
			int count = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			for(int j = 0; j < N; j++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
			
			for(int j = 0; j < N; j++) {
				int time = pq.poll();
				if((time / M) * K >= count + 1) {
					count++;
				} else {
					result = false;
					break;
				}
			}
			
			
			
			System.out.printf("#%d %s\n", i + 1 , result ? "Possible" : "Impossible");
		}
	}
}