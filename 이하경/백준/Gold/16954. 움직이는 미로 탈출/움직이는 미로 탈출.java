import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(bfs());
	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[9][8];
		visit = new boolean[9][8];

		map[0] = "........".toCharArray();
		for (int i = 1; i <= 8; i++) {
			map[i] = br.readLine().toCharArray();
		}
	}

	public static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(8, 0, 0));
		visit[8][0] = true;

		while (!q.isEmpty()) {
			Point curr = q.poll();

			for (int dx = 0; dx >= -2; dx--) {
				int nx = curr.x + dx;
				for (int dy = -1; dy <= 1; dy++) {
					int ny = curr.y + dy;
					if (canGo(nx + 1, ny, curr.time - 1) && (canGo(nx, ny, curr.time) && !visit[nx][ny])) {
						if (nx == 0) {
							return 1;
						}
						visit[nx][ny] = true;
						q.add(new Point(nx, ny, curr.time + 1));
					}
				}
			}
		}

		return 0;
	}

	static boolean canGo(int x, int y, int time) {
		return x >= 0 && x < 8 - time && y >= 0 && y < 8 && map[x][y] == '.';
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
