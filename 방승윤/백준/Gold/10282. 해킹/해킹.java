import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			ArrayList<int[]>[] list = new ArrayList[n + 1];

			for (int i = 1; i <= n; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				list[b].add(new int[] {a, s});
			}

			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
			pq.add(new int[] {c, 0});
			boolean[] visited = new boolean[n + 1];
			int cnt = 0;
			int time = 0;

			while (!pq.isEmpty()) {
				int[] cur = pq.poll();

				if (visited[cur[0]]) {
					continue;
				}

				cnt++;
				time = cur[1];
				visited[cur[0]] = true;

				for (int[] next : list[cur[0]]) {
					pq.add(new int[] {next[0], cur[1] + next[1]});
				}
			}

			sb.append(cnt).append(" ").append(time).append("\n");
		}

		System.out.println(sb);
	}
}