import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static char[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int x, y, d, h, w;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			map = new char[h][w];
			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			findTank();

			int n = Integer.parseInt(br.readLine());
			String cmd = br.readLine();
			
			for (int i = 0; i < n; i++) {
				char c = cmd.charAt(i);
				if (c == 'U') {
					move(0);
				} else if (c == 'R') {
					move(1);
				} else if (c == 'D') {
					move(2);
				} else if (c == 'L') {
					move(3);
				} else { // S인경우
					shoot();
				}
			}

			checkTank();

			sb.append("#").append(t).append(" ");

			for (char[] m : map) {
				sb.append(m).append("\n");
			}

		}
		System.out.println(sb);
	}

	// 전차 위치와 방향 찾고, 평지로 바꿔줌
	static void findTank() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j] == '^') {
					x = i;
					y = j;
					d = 0;
					map[i][j] = '.';
					return;
				}
				if (map[i][j] == '>') {
					x = i;
					y = j;
					d = 1;
					map[i][j] = '.';
					return;
				}
				if (map[i][j] == 'v') {
					x = i;
					y = j;
					d = 2;
					map[i][j] = '.';
					return;
				}
				if (map[i][j] == '<') {
					x = i;
					y = j;
					d = 3;
					map[i][j] = '.';
					return;
				}
			}
		}
	}

	static void move(int nd) {
		d = nd;
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == '.') {
			x = nx;
			y = ny;
		}
	}

	static void shoot() {
		int nx = x + dx[d];
		int ny = y + dy[d];

		while (nx >= 0 && nx < h && ny >= 0 && ny < w) {
			if (map[nx][ny] == '*') {
				map[nx][ny] = '.';
				return;
			}
			if (map[nx][ny] == '#') {
				return;
			}
			nx += dx[d];
			ny += dy[d];
		}
	}

	static void checkTank() {
		if (d == 0) {
			map[x][y] = '^';
			return;
		}
		if (d == 1) {
			map[x][y] = '>';
			return;
		}
		if (d == 2) {
			map[x][y] = 'v';
			return;
		}
		if (d == 3) {
			map[x][y] = '<';
			return;
		}
	}
}

