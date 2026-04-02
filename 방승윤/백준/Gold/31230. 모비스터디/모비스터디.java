import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static class Edge implements Comparable<Edge> {
		int u;
		int v;
		long w;

		Edge(int u, int v, long w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		public int compareTo(Edge o) {
			return Long.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		ArrayList<Edge>[] conn = new ArrayList[N + 1];
		ArrayList<Integer>[] prev = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			conn[i] = new ArrayList<>();
			prev[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Integer.parseInt(st.nextToken());
			conn[a].add(new Edge(a, b, c));
			conn[b].add(new Edge(b, a, c));
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Long[] costs = new Long[N + 1];
		Arrays.fill(costs, Long.MAX_VALUE);
		pq.add(new Edge(0, A, 0L));

		while (!pq.isEmpty()) {
			Edge curr = pq.poll();

			if (curr.w > costs[curr.v]) {
				continue;
			}

			prev[curr.v].add(curr.u);

			if (curr.w == costs[curr.v]) {
				continue;
			}

			costs[curr.v] = curr.w;

			for (Edge next : conn[curr.v]) {
				long cost = curr.w + next.w;

				if (cost < costs[next.v]) {
					pq.add(new Edge(curr.v, next.v, cost));
				}
			}
		}

		TreeSet<Integer> treeSet = new TreeSet<>();
		Queue<Integer> queue = new LinkedList<>();
		treeSet.add(B);
		queue.add(B);

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int next : prev[cur]) {
				if (next == 0) {
					continue;
				}

				queue.add(next);
				treeSet.add(next);
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(treeSet.size()).append("\n");

		for (int city : treeSet) {
			sb.append(city).append(" ");
		}

		System.out.println(sb);
	}
}