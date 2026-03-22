import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<int[]>[] list = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			list[A].add(new int[] {B, 1 - C});
			list[B].add(new int[] {A, 1 - C});
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		boolean[] visited = new boolean[N + 1];
		pq.add(new int[] {0, 0});
		int low = 0;

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			if (visited[cur[0]]) {
				continue;
			}

			visited[cur[0]] = true;
			low += cur[1];

			for (int[] next : list[cur[0]]) {
				if (visited[next[0]]) {
					continue;
				}

				pq.add(new int[] {next[0], next[1]});
			}
		}

		pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
		visited = new boolean[N + 1];
		pq.add(new int[] {0, 0});
		int high = 0;

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			if (visited[cur[0]]) {
				continue;
			}

			visited[cur[0]] = true;
			high += cur[1];

			for (int[] next : list[cur[0]]) {
				if (visited[next[0]]) {
					continue;
				}

				pq.add(new int[] {next[0], next[1]});
			}
		}

		System.out.println(high * high - low * low);
	}
}