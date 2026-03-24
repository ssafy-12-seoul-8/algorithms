import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int high;
	static int ans;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		high = 0;
		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				high = Math.max(high, arr[i][j]);
			}
		}

		do2048(0, arr);
		System.out.println(ans);
	}

	static void do2048(int depth, int[][] arr) {
		if (ans == high * Math.pow(2, 5)) {
			return;
		}

		if (depth == 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ans = Math.max(ans, arr[i][j]);
				}
			}

			return;
		}

		do2048(depth + 1, move(arr));

		for (int d = 0; d < 3; d++) {
			rotate(arr);
			do2048(depth + 1, move(arr));
		}
	}

	static int[][] move(int[][] arr) {
		int[][] temp = new int[N][N];
		boolean[][] lock = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int y = j;
				int block = arr[i][j];

				while (true) {
					int ny = y - 1;

					if (ny < 0) {
						temp[i][y] = block;
						break;
					}

					if (temp[i][ny] == 0) {
						y = ny;
						continue;
					}

					if (temp[i][ny] == block && !lock[i][ny]) {
						temp[i][ny] = block * 2;
						lock[i][ny] = true;
						break;
					}

					temp[i][y] = block;
					break;
				}
			}
		}

		return temp;
	}

	static int[][] rotate(int[][] arr) {
		int[][] temp = new int[N][N];

		for (int i = 0; i < N; i++) {
			System.arraycopy(arr[i], 0, temp[i], 0, N);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[j][i] = temp[i][N - 1 - j];
			}
		}

		return arr;
	}
}