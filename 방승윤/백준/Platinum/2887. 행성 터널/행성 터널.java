import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[] p;

	static class Planet {
		int id;
		int x;
		int y;
		int z;

		Planet(int id, int x, int y, int z) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static class Edge {
		int a;
		int b;
		int w;

		Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Planet[] planets = new Planet[N];
		ArrayList<Edge> edges = new ArrayList<>();
		p = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			planets[i] = new Planet(i, x, y, z);
			p[i] = i;
		}

		Arrays.sort(planets, (o1, o2) -> o1.x - o2.x);

		for (int i = 0; i < N - 1; i++) {
			edges.add(new Edge(planets[i].id, planets[i + 1].id, planets[i + 1].x - planets[i].x));
		}

		Arrays.sort(planets, (o1, o2) -> o1.y - o2.y);

		for (int i = 0; i < N - 1; i++) {
			edges.add(new Edge(planets[i].id, planets[i + 1].id, planets[i + 1].y - planets[i].y));
		}

		Arrays.sort(planets, (o1, o2) -> o1.z - o2.z);

		for (int i = 0; i < N - 1; i++) {
			edges.add(new Edge(planets[i].id, planets[i + 1].id, planets[i + 1].z - planets[i].z));
		}

		Collections.sort(edges, (o1, o2) -> o1.w - o2.w);
		long cost = 0;

		for (Edge edge : edges) {
			if (find(edge.a) == find(edge.b)) {
				continue;
			}

			cost += edge.w;
			p[find(edge.a)] = find(edge.b);
		}

		System.out.println(cost);
	}

	static int find(int x) {
		if (p[x] == x) {
			return x;
		}

		return p[x] = find(p[x]);
	}
}