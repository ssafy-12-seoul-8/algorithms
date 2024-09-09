import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution {
	
	static int V, E;
	static int[][] adjArr;
	static int[] degree;
	static boolean[] visited;
	static Stack<Integer> answer;
	
	public static void main(String[] args) throws Exception {

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adjArr = new int[V + 1][V + 1];
			degree = new int[V + 1];
			visited = new boolean[V + 1];
			answer = new Stack<>();
			
			sb.append("#").append(tc);
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < E; i++) {
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				adjArr[A][B] = 1;
				degree[B]++; 
			}
			
			for (int i = 1; i <= V; i++) {
				if (degree[i] == 0) {
					dfs(i);
				}
			}
			
			while (!answer.empty()) {
				sb.append(" ").append(answer.pop());
			}
			
			sb.append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	static void dfs(int curr) {
		
		visited[curr] = true;
		
		for (int i = 1; i < V + 1; i++) {
			if (adjArr[curr][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
		
		answer.push(curr);
		
	}
	
}