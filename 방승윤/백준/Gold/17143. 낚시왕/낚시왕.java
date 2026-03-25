import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R;
	static int C;
	static int M;
	static int ans;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[R + 1][C + 1][5];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());

			if (d == 0 || d == 1) {
				s %= (R - 1) * 2;
			} else {
				s %= (C - 1) * 2;
			}

			arr[r][c][0] = s;
			arr[r][c][1] = d;
			arr[r][c][2] = z;
		}

		for (int i = 1; i <= C; i++) {
			king(i);
			move();
		}

		System.out.println(ans);
	}

	static void move() {
		int[][][] temp = new int[R + 1][C + 1][5];

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				int z = arr[i][j][2];

				if (z == 0) {
					continue;
				}

				int r = i;
				int c = j;
				int s = arr[i][j][0];
				int d = arr[i][j][1];

				while (s != 0) {
					if ((d == 0 && r == 1) || (d == 1 && r == R)) {
						d = 1 - d;
					}

					if ((d == 2 && c == C) || (d == 3 && c == 1)) {
						d = 5 - d;
					}

					int dist = 0;

					if (d == 0 || d == 1) {
						dist = (d == 0) ? r - 1 : R - r;
					} else {
						dist = (d == 3) ? c - 1 : C - c;
					}

					if (dist >= s) {
						r += dx[d] * s;
						c += dy[d] * s;
						s = 0;
					} else {
						r += dx[d] * dist;
						c += dy[d] * dist;
						s -= dist;
					}
				}

				if (z > temp[r][c][2]) {
					temp[r][c][0] = arr[i][j][0];
					temp[r][c][1] = d;
					temp[r][c][2] = z;
				}
			}
		}

		arr = temp;
	}

	static void king(int c) {
		for (int r = 1; r <= R; r++) {
			if (arr[r][c][2] != 0) {
				ans += arr[r][c][2];
				Arrays.fill(arr[r][c], 0);
				return;
			}
		}
	}
}