
// 1. 벽 위치 결정하기. 64C3 = 41,664 가지 경우 0~n*n 까지 숫자로 
// 2. 안전 영역 크기 구하기 - 바이러스 위치, 벽과 바이러스 개수 저장해두고 탐색

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n, m, wallCnt, maxSafe, tmp; // empty는 0의 개수
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static ArrayList<int[]> virus = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		input();
		combination(0, 0);
		System.out.println(maxSafe);
	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		wallCnt = 3;
		maxSafe = 0;

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					wallCnt++;
					continue;
				}
				if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
				}
			}
		}
	}

	public static void combination(int start, int pick) {
		if (pick == 3) {
			tmp = n * m - wallCnt;
			visit = new boolean[n][m];
			for (int[] v : virus) {
				dfs(v[0], v[1]);
			}
			maxSafe = Math.max(maxSafe, tmp);

			return;
		}

		int cap = n * m - 2 + pick;
		for (int i = start; i < cap; i++) {
			if (map[i / m][i % m] == 0) {
				map[i / m][i % m] = 1;
				combination(i + 1, pick + 1);
				map[i / m][i % m] = 0;
			}
		}
	}

	public static void dfs(int x, int y) {
		visit[x][y] = true;
		tmp--;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (inRange(nx, ny) && !visit[nx][ny] && map[nx][ny] == 0) {
				dfs(nx, ny);
			}
		}
	}

	public static boolean inRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}
