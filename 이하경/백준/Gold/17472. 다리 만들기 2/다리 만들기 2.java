import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int INF = 500;
	static int n, m, k;
	static int[][] map, bridges;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		input();
		solution();
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
			}
		}
	}

	static void solution() {
		int next = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					checkIsland(i, j, ++next);
				}
			}
		}

		k = next; // 섬의 끝 번호
		makeBridge();

		System.out.println(prim());

	}

	// 연결된 섬을 k로 표시한다
	// 섬이 "직사각형 모양이다" 라는 말이 없는데 그림은 다 직사각형이고 흠...
	static void checkIsland(int r, int c, int k) {
		map[r][c] = k;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 1) {
				checkIsland(nr, nc, k);
			}
		}
	}

	// 모든 행, 열 탐색하며 가능한 모든 다리 만들기
	static void makeBridge() {
		bridges = new int[k + 1][k + 1];

		for (int i = 0; i < n; i++) {
			int prev = 0;
			int idx = -1;
			for (int j = 0; j < m; j++) { // 행 방향으로
				int curr = map[i][j];
				if (curr == 0) {
					continue;
				}
				if (prev == curr) {
					idx = j;
					continue;
				}
				if (prev != 0) {
					int dist = j - idx - 1;
					if (dist >= 2 && (bridges[prev][curr] == 0 || bridges[prev][curr] > dist)) {
						bridges[prev][curr] = dist;
						bridges[curr][prev] = dist;
					}
				}
				prev = curr;
				idx = j;
			}
		}

		for (int i = 0; i < m; i++) {
			int prev = 0;
			int idx = -1;
			for (int j = 0; j < n; j++) { // 열 방향으로
				int curr = map[j][i];
				if (curr == 0) {
					continue;
				}
				if (prev == curr) {
					idx = j;
					continue;
				}
				if (prev != 0) {
					int dist = j - idx - 1;
					if (dist >= 2 && (bridges[prev][curr] == 0 || bridges[prev][curr] > dist)) {
						bridges[prev][curr] = dist;
						bridges[curr][prev] = dist;
					}
				}
				prev = curr;
				idx = j;
			}
		}

	}

	static int prim() {
		int[] dist = new int[k + 1];
		Arrays.fill(dist, INF);
		boolean[] visit = new boolean[k + 1];

		int pick = 1; // 섬이 2~k번이므로 섬은 k-1개
		int ans = 0;
		dist[2] = 0;
		for (int i = 3; i <= k; i++) {
			if (bridges[2][i] != 0) {
				dist[i] = bridges[2][i];
			}
		}

		while (pick < k - 1) {
			int min = INF;
			int minIdx = -1;
			for (int i = 3; i <= k; i++) {
				if (!visit[i] && dist[i] < min) {
					min = dist[i];
					minIdx = i;
				}
			}

			if (minIdx == -1) {
				return -1;
			}

			visit[minIdx] = true;
			pick++;
			ans += dist[minIdx];

			for (int i = 3; i <= k; i++) {
				if (bridges[minIdx][i] != 0) {
					dist[i] = Math.min(dist[i], bridges[minIdx][i]);
				}
			}
		}

		return ans;
	}

}
