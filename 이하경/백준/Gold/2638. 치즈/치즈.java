import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean[][] visit;
	static int[][] map; // 0은 내부, 1은 치즈
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int cheeseCnt = 0;

	public static void main(String[] args) throws Exception {
		input();
		solve();
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				cheeseCnt += map[i][j];
			}
		}
	}

	static void solve() {
		int time = 0;
		while (cheeseCnt > 0) {
			time++;
			visit = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				if (map[i][0] == 0 && !visit[i][0]) {
					checkTouch(i, 0);
				}
				if (map[i][m - 1] == 0 && !visit[i][m - 1]) {
					checkTouch(i, m - 1);
				}
			}

			for (int i = 1; i < m; i++) {
				if (map[0][i] == 0 && !visit[0][i]) {
					checkTouch(0, i);
				}
				if (map[n - 1][i] == 0 && !visit[n - 1][i]) {
					checkTouch(n - 1, i);
				}
			}
		}
		System.out.println(time);
	}


	static void checkTouch(int x, int y) {
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!inRange(nx, ny)) {
				continue;
			}

			if (map[nx][ny] == 0 && !visit[nx][ny]) {
				checkTouch(nx, ny);
				continue;
			}

			if (map[nx][ny] == 1 && !visit[nx][ny]) {
				visit[nx][ny] = true;
				continue;
			}

			if (map[nx][ny] == 1 && visit[nx][ny]) {
				map[nx][ny] = 0;
				cheeseCnt--;
			}
		}
	}

	static boolean inRange(int nx, int ny) {
		return nx >= 0 && nx < n && ny >= 0 && ny < m;
	}
}
