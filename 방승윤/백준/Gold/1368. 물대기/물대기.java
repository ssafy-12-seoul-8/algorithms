import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int u;
		int v;
		int w;

		Node(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		p = new int[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			p[i] = i;
			pq.add(new Node(0, i, Integer.parseInt(br.readLine())));
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				int w = Integer.parseInt(st.nextToken());

				if (j > i) {
					pq.add(new Node(i, j, w));
				}
			}
		}

		int ans = 0;
		int cnt = 0;

		while (cnt < N) {
			Node curr = pq.poll();
			int u = find(curr.u);
			int v = find(curr.v);

			if (u == v) {
				continue;
			}

			p[u] = v;
			ans += curr.w;
			cnt++;
		}

		System.out.println(ans);
	}

	static int[] p;

	static int find(int x) {
		if (x == p[x]) {
			return x;
		}

		return p[x] = find(p[x]);
	}
}