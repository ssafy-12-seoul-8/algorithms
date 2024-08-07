import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			double N = Double.parseDouble(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			StringBuilder sb = new StringBuilder();
			Queue<String> queue1 = new LinkedList<>();
			Queue<String> queue2 = new LinkedList<>();
			
			
			for(int j = 0; j < N; j++) {
				if(j < Math.round(N / 2)) {
					queue1.offer(st.nextToken());
				}
				else {
					queue2.offer(st.nextToken());
				}
			}

			sb.append("#").append(i + 1);
			
			for(int j = 0; j < N; j++) {
				sb.append(" ").append(j % 2 == 0 ? queue1.poll() : queue2.poll());
			}
			
			System.out.println(sb);
		}
	}
}