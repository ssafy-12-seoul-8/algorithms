import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int len = str.length;
		int[] dp = new int[len + 1];
		boolean[][] palindrome = new boolean[len + 1][len + 1];

		for (int i = 0; i < len; i++) {
			palindrome[i][i] = true;

			for (int j = 1; j < len - i; j++) {
				if (i - j >= 0 && str[i - j] == str[i + j]) {
					palindrome[i - j][i + j] = true;
					continue;
				}

				break;
			}

			if (i + 1 < len && str[i] == str[i + 1]) {
				palindrome[i][i + 1] = true;

				for (int j = 1; j < len - i - 1; j++) {
					if (i - j >= 0 && str[i - j] == str[i + j + 1]) {
						palindrome[i - j][i + j + 1] = true;
						continue;
					}

					break;
				}
			}
		}

		for (int i = 0; i < len; i++) {
			dp[i + 1] = dp[i] + 1;

			for (int j = i; j >= 0; j--) {
				if (palindrome[j][i]) {
					dp[i + 1] = Math.min(dp[j] + 1, dp[i + 1]);
				}
			}
		}

		System.out.println(dp[len]);
	}
}