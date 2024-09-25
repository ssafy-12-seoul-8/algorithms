import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[] code;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		code = br.readLine().toCharArray();

		int[] dp = new int[code.length];
		if (isValid(0)) {
			dp[0] = 1;
		} else {
			System.out.println(0);
			return;
		}

		if (code.length > 1) {
			if (isValid(1)) {
			dp[1] += 1;
			}
			if (isTwoDecValid(1)) {
				dp[1] += 1;
			}
			if (dp[1] == 0) {
				System.out.println(0);
				return;
			}
		}

		for (int i = 2; i < dp.length; i++) {
			if (isValid(i)) {
				dp[i] += dp[i - 1];
			}
			if (isTwoDecValid(i)) {
				dp[i] += dp[i - 2];
			}
			if (dp[i] == 0) {
				System.out.println(0);
				return;
			}
			dp[i] %= 1_000_000;
		}

		System.out.println(dp[dp.length - 1]);
	}

	static boolean isValid(int i) {
		return code[i] > '0';
	}

	static boolean isTwoDecValid(int i) {
		if (code[i - 1] == '1') {
			return true;
		}
		if (code[i - 1] == '2' && code[i] <= '6') {
			return true;
		}
		return false;
	}
}
