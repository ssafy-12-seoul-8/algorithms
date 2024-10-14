// 1. 벽 위치 결정하기. 64C3 = 41,664 가지 경우 0~n*n 까지 숫자로 
// 2. 안전 영역 크기 구하기 - 바이러스 위치, 벽과 바이러스 개수 저장해두고 탐색

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, empty, maxSafe, size; // empty는 0의 개수
	static int[][] map;
	static int[] wall;
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
		size = n * m;
		empty = -3;
		maxSafe = 0;

		map = new int[n][m];
		wall = new int[3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					empty++;
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
			maxSafe = Math.max(maxSafe, findSafeSize());
			return;
		}

		for (int i = start; i < size; i++) {
			if (map[i / m][i % m] == 0) {
				wall[pick] = i;
				combination(i + 1, pick + 1);
			}
		}
	}

	public static int findSafeSize() {
		int safeSize = empty;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[n][m];

		for (int[] point : virus) {
			q.add(point);
			visit[point[0]][point[1]] = true;
		}

		for (int w : wall) {
			visit[w / m][w % m] = true;
		}

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = curr[0] + dx[d];
				int ny = curr[1] + dy[d];

				if (inRange(nx, ny) && !visit[nx][ny] && map[nx][ny] == 0) {
					visit[nx][ny] = true;
					q.add(new int[] { nx, ny });
					safeSize--;
				}
			}
		}
		return safeSize;
	}

	public static boolean inRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}
