import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static Deque<Point> q;
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
		q = new ArrayDeque<>();
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			if (map[i][0] == 0) {
				visit[0][0] = true;
				q.addFirst(new Point(i, 0, 0));
			}
			if (map[i][m - 1] == 0) {
				visit[i][m - 1] = true;
				q.addFirst(new Point(i, m - 1, 0));
			}
		}

		for (int i = 1; i < m; i++) {
			if (map[0][i] == 0) {
				visit[0][i] = true;
				q.addFirst(new Point(0, i, 0));
			}
			if (map[n - 1][i] == 0) {
				visit[n - 1][i] = true;
				q.addFirst(new Point(n - 1, i, 0));
			}
		}

		System.out.println(bfs());
	}


	static int bfs() {
		int maxTime = 0;

		while (!q.isEmpty()) {
			Point curr = q.pollFirst();

			for (int d = 0; d < 4; d++) {
				int nx = curr.x + dx[d];
				int ny = curr.y + dy[d];

				if (!inRange(nx, ny)) {
					continue;
				}

				if (map[nx][ny] == 0 && !visit[nx][ny]) {
					visit[nx][ny] = true;
					q.addFirst(new Point(nx, ny, curr.time));
					continue;
				}
				
				if (map[nx][ny] == 1 && !visit[nx][ny]) {
					visit[nx][ny] = true;
					continue;
				}
				
				if (map[nx][ny] == 1 && visit[nx][ny]) {
					map[nx][ny] = 0;
					maxTime = curr.time + 1;
					q.addLast(new Point(nx, ny, curr.time + 1));
				}
			}
		}

		return maxTime;
	}

	static boolean inRange(int nx, int ny) {
		return nx >= 0 && nx < n && ny >= 0 && ny < m;
	}

	static class Point {
		int x, y, time;

		public Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
}
