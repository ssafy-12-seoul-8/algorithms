import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] visited;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n + 1];
			visited = new int[n + 1];
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= n; i++) {
				if (visited[i] == 0) {
					dfs(i);
				}
			}

			sb.append(n - cnt).append("\n");
		}

		System.out.println(sb);
	}

	static void dfs(int cur) {
		visited[cur] = 1;
		int next = arr[cur];

		if (visited[next] == 0) {
			dfs(next);
		} else if (visited[next] == 1) {
			for (int v = next; v != cur; v = arr[v]) {
				cnt++;
			}

			cnt++;
		}

		visited[cur] = 2;
	}
}
