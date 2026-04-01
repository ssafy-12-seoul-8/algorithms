import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] scoville = new int[N];

		for (int i = 0; i < N; i++) {
			scoville[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(scoville);
		long[] pow = new long[N];
		pow[0] = 1;

		for (int i = 1; i < N; i++) {
			pow[i] = (pow[i - 1] * 2) % MOD;
		}

		long sum = 0;

		for (int i = 0; i < N; i++) {
			sum = (sum + (pow[i] - 1) * scoville[i]) % MOD;
			sum = (sum - (pow[N - 1 - i] - 1) * scoville[i]) % MOD;
		}

		System.out.println(sum);
	}
}