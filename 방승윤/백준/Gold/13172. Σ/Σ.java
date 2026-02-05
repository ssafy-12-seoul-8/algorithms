import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final long X = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		long sum = 0;

		for (int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long N = Integer.parseInt(st.nextToken());
			long S = Integer.parseInt(st.nextToken());
			long inverseN = modPow(N, X - 2);

			sum = (sum + (S * inverseN)) % X;
		}

		System.out.println(sum);
	}

	static long modPow(long base, long exp) {
		long result = 1;

		while (exp > 0) {
			if (exp % 2 == 1) {
				result = (result * base) % X;
			}

			base = (base * base) % X;
			exp /= 2;
		}

		return result;
	}
}
