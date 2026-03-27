import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, max;
	static int[][] chess;
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, 1, -1 };

	// 2의 100제곱은 0이 30개
	// 2의 50제곱은 0이 15개
	// 1초에 0이 9개까지 처리 된다
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		chess = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				chess[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (n == 1) {
			System.out.println(chess[0][0]);
			return;
		}

		max = 0;
		bishop(0, 0, 0, 0, 0);
		int ans = max;
		max = 0;
		bishop(0, 1, 0, 0, 0);

		System.out.println(ans + max);
	}

	// (r,c)는 이번에 확인할 빈칸의 위치
	static void bishop(int r, int c, int leftBit, int rightBit, int cnt) {
		if (r == n - 1 && c >= n) {
			max = Math.max(max, cnt);
			return;
		}

		if (c >= n) {
			leftBit <<= 1;
			rightBit >>= 1;
			r++;
			c = n % 2 == 1 ? c - n : n + 1 - c;
		}
		
		if (isValid(r, c, leftBit, rightBit)) {
			bishop(r, c + 2, leftBit | 1 << c, rightBit | 1 << c, cnt + 1);
		}
		bishop(r, c + 2, leftBit, rightBit, cnt);
	}

	static boolean isValid(int r, int c, int leftBit, int rightBit) {
		if (chess[r][c] == 0) {
			return false;
		}
		if (((1 << c) & leftBit) != 0) {
			return false;
		}
		if (((1 << c) & rightBit) != 0) {
			return false;
		}
		return true;
	}

}
