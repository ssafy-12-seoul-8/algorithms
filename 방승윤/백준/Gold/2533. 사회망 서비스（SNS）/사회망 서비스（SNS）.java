import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] adj;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}

		visited[1] = true;
		int[] res = dfs(1);
		System.out.println(Math.min(res[0], res[1]));
	}

	static int[] dfs(int curr) {
		int yes = 1;
		int no = 0;

		for (int next : adj[curr]) {
			if (visited[next]) {
				continue;
			}

			visited[next] = true;
			int[] child = dfs(next);
			no += child[1];
			yes += Math.min(child[1], child[0]);
		}

		return new int[] {no, yes};
	}
}