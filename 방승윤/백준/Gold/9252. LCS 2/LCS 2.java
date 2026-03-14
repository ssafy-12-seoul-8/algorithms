import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();
		int[][] dp = new int[A.length + 1][B.length + 1];

		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= B.length; j++) {
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					continue;
				}

				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		int i = A.length;
		int j = B.length;

		while (i > 0 && j > 0) {
			if (A[i - 1] == B[j - 1]) {
				sb.append(A[i - 1]);
				i--;
				j--;
				continue;
			}

			if (dp[i -1][j] > dp[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}

		System.out.println(dp[A.length][B.length]);
		System.out.println(sb.reverse());
	}
}
