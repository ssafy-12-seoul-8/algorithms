import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		p = new int[n];

		for (int i = 1; i < n; i++) {
			p[i] = i;
		}

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (find(a) == find(b)) {
				System.out.println(i);
				return;
			}

			union(a, b);
		}

		System.out.println(0);
	}

	static int find(int x) {
		if (p[x] == x) {
			return x;
		}

		return p[x] = find(p[x]);
	}

	static void union(int x, int y) {
		p[find(y)] = find(x);
	}
}
