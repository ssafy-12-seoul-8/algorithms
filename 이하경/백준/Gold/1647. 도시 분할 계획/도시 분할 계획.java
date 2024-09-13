import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 크루스칼 사용
// 프림을 사용하면 시작점 두개를 정하기가 곤란함
// 크루스칼로 n-2개 정점을 결정하면 최소비용의 두개 집단이 구해진다

public class Main {
	static int n, m;
	static int[] p;
	static PriorityQueue<Edge> edges;

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(kruskal());
	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		edges = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges.add(new Edge(a, b, c));
		}
	}

	// 최대 유지비는 1000 * 100,000
	public static int kruskal() {
		p = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}
		
		int pick = 0;
		int cost = 0;
		
		while (pick < n - 2) { // MST보다 하나 덜 뽑는다
			Edge curr = edges.poll();
			int parA = find(curr.a);
			int parB = find(curr.b);

			if (parA == parB) {
				continue;
			}

			union(parA, parB);
			pick++;
			cost += curr.w;
		}

		return cost;
	}

	// x, y는 루트 노드만 들어온다
	public static void union(int x, int y) {
		p[y] = x;
	}

	public static int find(int x) {
		if (p[x] != x) {
			p[x] = find(p[x]);
		}
		return p[x];
	}

	static class Edge implements Comparable<Edge> {
		int a, b, w;

		public Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
}
