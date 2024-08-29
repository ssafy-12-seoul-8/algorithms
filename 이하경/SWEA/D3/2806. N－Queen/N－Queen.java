import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static boolean[][] visit;
	static int n;
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			visit = new boolean[n][n];
			
			int cnt = 0;
			for (int i = 0; i < n / 2; i++) {
				visit[0][i] = true;
				cnt += 2 * nQueen(1);
				visit[0][i] = false;
			}
			if (n % 2 == 1) {
				int mid = n / 2;
				visit[0][mid] = true;
				cnt += nQueen(1);
				visit[0][mid] = false;
			}

			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	static int nQueen(int level) {
		if (level == n) {
			return 1;
		}

		int ret = 0;
		for (int i = 0; i < n; i++) { // level번 행의 i번 열에 놓는다
			if (isValid(level, i)) {
				visit[level][i] = true;
				ret += nQueen(level + 1);
				visit[level][i] = false;
			}
		}
		return ret;
	}

	static boolean isValid(int x, int y) {
		for (int i = 0; i < 8; i++) { // 8방향 탐색
			int nx = x + dx[i];
			int ny = y + dy[i];

			while (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (visit[nx][ny]) {
					return false;
				}
				nx += dx[i];
				ny += dy[i];
			}
		}

		return true;
	}

}

