import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		p = new int[G + 1];

		for (int i = 1; i <= G; i++) {
			p[i] = i;
		}

		for (int i = 1; i <= P; i++) {
			int g = Integer.parseInt(br.readLine());

			if (find(g) == 0) {
				System.out.println(i - 1);
				return;
			}

			union(find(g), find(g) - 1);
		}

		System.out.println(P);
	}

	static void union(int x, int y) {
		p[find(x)] = find(y);
	}

	static int find(int x) {
		if (p[x] == x) {
			return x;
		}

		return p[x] = find(p[x]);
	}
}
