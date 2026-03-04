import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int X = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] D = new int[N + 1];
		int[] C = new int[M + 1];

		for (int i = 1; i <= N; i++) {
			D[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= M; i++) {
			C[i] = Integer.parseInt(br.readLine());
		}

		int[] T = new int[N + 1];
		Arrays.fill(T, X);
		T[0] = 0;

		for (int i = 1; i <= M; i++) {
			for (int j = N; j >= 1; j--) {
				T[j] = Math.min(T[j], T[j - 1] + D[j] * C[i]);
			}
		}

		System.out.println(T[N]);
	}
}
