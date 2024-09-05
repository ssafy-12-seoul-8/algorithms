// 치즈 문제

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		input();
		solution();
	}

	static void solution() {
		// 0일때는 모두 안전 -> 지역 1개, 100일때는 지역 0개
		int max = 1;
		for (int rain = 1; rain < 100; rain++) {
			int cnt = 0;
			visit = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visit[i][j] || map[i][j] <= rain) {
						continue;
					}
					visit[i][j] = true;
					dfs(rain, i, j);
					cnt++;
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

	static void dfs(int rain, int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] > rain && !visit[nx][ny]) {
				visit[nx][ny] = true;
				dfs(rain, nx, ny);
			}
		}
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
