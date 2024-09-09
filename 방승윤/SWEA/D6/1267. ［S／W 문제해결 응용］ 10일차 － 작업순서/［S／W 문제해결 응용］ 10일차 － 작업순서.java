import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
	
	public static void main(String[] args) throws Exception {

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			
			st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int[][] adjArr = new int[V + 1][V + 1];
			int[] degree = new int[V + 1];
			
			sb.append("#").append(tc);
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < E; i++) {
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				adjArr[A][B] = 1;
				degree[B]++; 
			}
			
			Queue<Integer> queue = new LinkedList<>();
			
			for (int i = 1; i < V + 1; i++) {
				if (degree[i] == 0) {
					queue.add(i);
				}
			}
			
			while (!queue.isEmpty()) {
				int curr = queue.poll();
				
				sb.append(" ").append(curr);
				
				for (int i = 1; i < V + 1; i++) {
					if (adjArr[curr][i] != 0) {
						degree[i]--;
						adjArr[curr][i] = 0;
						
						if (degree[i] == 0) {
							queue.add(i);
						}
					}
				}
			}
			
			sb.append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
}