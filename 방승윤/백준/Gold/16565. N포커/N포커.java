import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int MOD = 10_007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] C = new int[53][53];

		for (int i = 0; i <= 52; i++) {
			C[i][0] = 1;
			for (int j = 1; j <= i; j++) {
				C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
			}
		}

		int ans = 0;

		for (int i = 1; i <= N / 4; i++) {
			int cnt = (C[13][i] * C[52 - (i * 4)][N - (i * 4)]) % MOD;

			if (i % 2 == 0) {
				ans = (ans - cnt) % MOD;
			} else {
				ans = (ans + cnt) % MOD;
			}
		}

		System.out.println((ans + MOD) % MOD);
	}
}