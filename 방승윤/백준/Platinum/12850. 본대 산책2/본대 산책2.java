import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int MOD = 1_000_000_007;
	static long[][] matrix ={
		{0, 1, 1, 0, 0, 0, 0, 0},
		{1, 0, 1, 1, 0, 0, 0, 0},
		{1, 1, 0, 1, 1, 0, 0, 0},
		{0, 1, 1, 0, 1, 1, 0, 0},
		{0, 0, 1, 1, 0, 1, 1, 0},
		{0, 0, 0, 1, 1, 0, 0, 1},
		{0, 0, 0, 0, 1, 0, 0, 1},
		{0, 0, 0, 0, 0, 1, 1, 0}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int D = Integer.parseInt(br.readLine());
		System.out.println(pow(matrix, D)[0][0]);
	}

	public static long[][] multi(long[][] A, long[][] B) {
		long[][] C = new long[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < 8; k++) {
					C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
				}
			}
		}

		return C;
	}

	static long[][] pow(long[][] A, int exp) {
		long[][] res = new long[8][8];

		for (int i = 0; i < 8; i++) {
			res[i][i] = 1;
		}

		while (exp > 0) {
			if (exp % 2 == 1) {
				res = multi(res, A);
			}

			A = multi(A, A);
			exp /= 2;
		}

		return res;
	}
}