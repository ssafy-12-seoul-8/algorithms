import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int K = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < K; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			ArrayList<Integer>[] list = new ArrayList[V + 1];

			for (int i = 1; i <= V; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				list[u].add(v);
				list[v].add(u);
			}

			int[] arr = new int[V + 1];
			boolean flag = false;

			for (int i = 1; i <= V; i++) {
				if (arr[i] != 0) {
					continue;
				}

				Queue<Integer> queue = new LinkedList<>();
				arr[i] = 1;
				queue.add(i);

				while (!queue.isEmpty()) {
					int cur = queue.poll();

					for (int next : list[cur]) {
						if (arr[next] == 0) {
							arr[next] = 3 - arr[cur];
							queue.add(next);
							continue;
						}

						if (arr[next] == arr[cur]) {
							flag = true;
							break;
						}
					}

					if (flag) {
						break;
					}
				}

				if (flag) {
					break;
				}
			}

			sb.append(flag ? "NO\n" : "YES\n");
		}

		System.out.println(sb);
	}
}
