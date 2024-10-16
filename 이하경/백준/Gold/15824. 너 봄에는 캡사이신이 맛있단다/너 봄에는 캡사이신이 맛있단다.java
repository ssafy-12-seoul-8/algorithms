
// 최대, 최소만 고려하면 되므로 현재 스코발지수가 (최대가 되는 조합 개수) - (최소가 되는 조합 개수)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int DIVIDER = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] scobal = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			scobal[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(scobal);
		
		long ans = 0;
		
		for (int i = 0; i < n; i++) {
			ans += scobal[i] * (mod(2, i) - mod(2, n - 1 - i));
			ans %= DIVIDER;
		}

		if (ans < 0) {
			ans += DIVIDER;
		}

		System.out.println(ans);
	}

	// x의 y제곱을 1,000,000,007로 나눈 나머지
	static long mod(long x, int y) {
		long ret = 1;

		while (y > 0) {
			if (y % 2 == 1) {
				ret = (ret * x) % DIVIDER;
			}
			y >>= 1;
			x = (x * x) % DIVIDER;
		}

		return ret;
	}
}
