import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] field = new int[R][C];
		boolean flag = false;
		int air = 0;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < C; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());

				if (field[i][j] == -1 && !flag) {
					air = i;
					flag = true;
				}
			}
		}

		for (int t = 0; t < T; t++) {
			int[][] spread = new int[R][C];

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					int unit = field[i][j] / 5;

					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];

						if (nx < 0 || nx >= R || ny < 0 || ny >= C || (ny == 0 && (nx == air || nx == air + 1))) {
							continue;
						}

						spread[nx][ny] += unit;
						spread[i][j] -= unit;
					}
				}
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					field[i][j] += spread[i][j];
				}
			}

			field[air - 1][0] = 0;

			for (int i = air - 2; i >= 0; i--) {
				field[i + 1][0] = field[i][0];
			}

			for (int i = 1; i < C; i++) {
				field[0][i - 1] = field[0][i];
			}

			for (int i = 1; i <= air; i++) {
				field[i - 1][C - 1] = field[i][C - 1];
			}

			for (int i = C - 2; i > 0; i--) {
				field[air][i + 1] = field[air][i];
			}

			field[air][1] = 0;
			field[air + 2][0] = 0;

			for (int i = air + 3; i < R; i++) {
				field[i - 1][0] = field[i][0];
			}

			for (int i = 1; i < C; i++) {
				field[R - 1][i - 1] = field[R - 1][i];
			}

			for (int i = R - 2; i >= air + 1; i--) {
				field[i + 1][C - 1] = field[i][C - 1];
			}

			for (int i = C - 2; i > 0; i--) {
				field[air + 1][i + 1] = field[air + 1][i];
			}

			field[air + 1][1] = 0;
		}

		int dust = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (field[i][j] == -1) {
					continue;
				}

				dust += field[i][j];
			}
		}

		System.out.println(dust);
	}
}
