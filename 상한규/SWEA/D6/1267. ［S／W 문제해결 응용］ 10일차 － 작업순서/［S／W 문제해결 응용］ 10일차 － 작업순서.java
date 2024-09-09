import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		int T = 10;
		
		for(int tc = 0; tc < T; tc++) {
			StringBuilder result = new StringBuilder();
			result.append("#").append(tc + 1).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int[][] adjArray = new int[V + 1][V + 1];
			int[] degree = new int[V + 1];
			Queue<Integer> queue = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < E; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				adjArray[a][b] = 1;
				degree[b]++;
			}
			
			for(int i = 1; i < V + 1; i++) {
				if(degree[i] == 0) {
					queue.offer(i);
				}
			}
			
			while(!queue.isEmpty()) {
				int curr = queue.poll();
				result.append(curr).append(" ");

				for(int i = 1; i < V + 1; i++) {
					if(adjArray[curr][i] != 0) {
						adjArray[curr][i] = 0;
						degree[i]--;
						

						if(degree[i] == 0) {
							queue.offer(i);
						}
					}
				}
			}
			
			System.out.println(result);
		}
	}
}
