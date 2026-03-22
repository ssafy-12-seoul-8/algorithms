import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		p = new int[N + 1][3];
		boolean[] visited = new boolean[N + 1];
		int[] dp = new int[K];
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			p[i][0] = i;
			p[i][1] = 1;
			p[i][2] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = find(Integer.parseInt(st.nextToken()));
			int b = find(Integer.parseInt(st.nextToken()));

			if (a != b) {
				union(a, b);
			}
		}

		for (int i = 1; i <= N; i++) {
			int num = find(i);

			if (visited[num]) {
				continue;
			}

			visited[num] = true;

			for (int j = K - 1; j >= p[num][1]; j--) {
				dp[j] = Math.max(dp[j - p[num][1]] + p[num][2], dp[j]);
			}
		}

		System.out.println(dp[K - 1]);
	}

	static void union(int x, int y) {
		p[y][0] = x;
		p[x][1] += p[y][1];
		p[y][1] = 0;
		p[x][2] += p[y][2];
		p[y][2] = 0;
	}

	static int find(int x) {
		if (p[x][0] == x) {
			return x;
		}

		return p[x][0] = find(p[x][0]);
	}
}