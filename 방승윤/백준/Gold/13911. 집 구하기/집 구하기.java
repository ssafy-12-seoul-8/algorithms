import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge> {
		int v;
		int w;

		Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}

		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[] mc = new int[V + 1];
		int[] star = new int[V + 1];
		Arrays.fill(mc, Integer.MAX_VALUE);
		Arrays.fill(star, Integer.MAX_VALUE);
		ArrayList<Edge>[] edges = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[u].add(new Edge(v, w));
			edges[v].add(new Edge(u, w));
		}

		PriorityQueue<Edge> pqMc = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		boolean[] isStore = new boolean[V + 1];

		for (int i = 0; i < M; i++) {
			int v = Integer.parseInt(st.nextToken());
			pqMc.add(new Edge(v, 0));
			isStore[v] = true;
			mc[v] = 0;
		}

		PriorityQueue<Edge> pqStar = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < S; i++) {
			int v = Integer.parseInt(st.nextToken());
			pqStar.add(new Edge(v, 0));
			isStore[v] = true;
			star[v] = 0;
		}

		while (!pqMc.isEmpty()) {
			Edge curr = pqMc.poll();

			if (curr.w > mc[curr.v]) {
				continue;
			}

			for (Edge next : edges[curr.v]) {
				int dist = curr.w + next.w;

				if (dist <= x && dist < mc[next.v]) {
					mc[next.v] = dist;
					pqMc.add(new Edge(next.v, dist));
				}
			}
		}

		while (!pqStar.isEmpty()) {
			Edge curr = pqStar.poll();

			if (curr.w > star[curr.v]) {
				continue;
			}

			for (Edge next : edges[curr.v]) {
				int dist = curr.w + next.w;

				if (dist <= y && dist < star[next.v]) {
					star[next.v] = dist;
					pqStar.add(new Edge(next.v, dist));
				}
			}
		}

		int ans = Integer.MAX_VALUE;

		for (int i = 1; i <= V; i++) {
			if (isStore[i] || Math.max(mc[i], star[i]) == Integer.MAX_VALUE) {
				continue;
			}

			ans = Math.min(ans, mc[i] + star[i]);
		}

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
}