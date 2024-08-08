import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			StringBuilder sb = new StringBuilder();
			
			sb.append("#").append(i + 1);

			for(int j = 0; j < N; j++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
			
			while(!pq.isEmpty()) {
				sb.append(" ").append(pq.poll());
			}
			
			
			
			
			System.out.println(sb);
		}
	}
}