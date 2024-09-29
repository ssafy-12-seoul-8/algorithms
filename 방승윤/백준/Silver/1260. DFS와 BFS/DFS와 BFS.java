import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, V;
	static boolean[] visited;
	static boolean[][] edge;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		edge = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edge[a][b] = true;
			edge[b][a] = true;
		}
		
		visited[V] = true;
		
		dfs(V);
		
		sb.append("\n");
		
		Arrays.fill(visited, false);
		
		bfs(V);
		
		System.out.println(sb);

	}

	static void dfs(int curr) {
		
		sb.append(curr).append(" ");
		
		visited[curr] = true;
		
		for (int i = 1; i <= N; i++) {
			if (edge[curr][i] && !visited[i]) {
				dfs(i);
			}
		}
		
	}
	
	static void bfs(int curr) {
		
		sb.append(curr).append(" ");
		
		visited[curr] = true;
		
		for (int i = 1; i <= N; i++) {
			if (edge[curr][i] && !visited[i]) {
				queue.offer(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			
			if (!visited[temp]) {
				bfs(temp);
			}
		}
		
	}

}