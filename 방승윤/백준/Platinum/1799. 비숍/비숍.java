import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1, -1, 1, 1};
	static int[] dc = {-1, 1, -1, 1};
	static int N;
	static int max;
	static boolean[][] arr;
	static int[][] impossible;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new boolean[N][N];
		impossible = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					arr[i][j] = true;
				}
			}
		}

		dfs(0, 0, 0);
		int ans = max;
		max = 0;
		dfs(0, 1, 0);
		System.out.println(ans + max);
	}

	static void dfs(int r, int c, int cnt) {
		if (c >= N) {
			r++;
			c = c % 2 == 0 ? 1 : 0;
		}

		if (r >= N) {
			max = Math.max(max, cnt);
			return;
		}

		if (impossible[r][c] != 0 || !arr[r][c]) {
			dfs(r, c + 2, cnt);
			return;
		}

		dfs(r, c + 2, cnt);
		int dist = Math.max(Math.max(r, (N - 1) - r), Math.max(c, (N - 1) - c));

		for (int i = 1; i <= dist; i++) {
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d] * i;
				int nc = c + dc[d] * i;

				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					impossible[nr][nc]++;
				}
			}
		}

		dfs(r, c + 2, cnt + 1);

		for (int i = 1; i <= dist; i++) {
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d] * i;
				int nc = c + dc[d] * i;

				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					impossible[nr][nc]--;
				}
			}
		}
	}
}