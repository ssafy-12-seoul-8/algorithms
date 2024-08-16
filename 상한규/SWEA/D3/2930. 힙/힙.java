import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test_case; i++) {
			int N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
			
			sb.append("#").append(i + 1);
			
			for(int j = 0; j < N; j++) {
				String[] operator = br.readLine().split(" ");
				if(Integer.parseInt(operator[0]) == 1) {
					pq.offer(Integer.parseInt(operator[1]));
				} else {
					if(pq.isEmpty()) {
						sb.append(" ").append(-1);
					} else {
						sb.append(" ").append(pq.poll());
					}
				}
			}
			System.out.println(sb);
		}
	}	
}