import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int[] pop = new int[n + 1]; // 인기도
		long[] acc = new long[n + 1]; // 인기도 누적합, 최대 1000 * 100,000
		long[] sqrtAcc = new long[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
			acc[i] = acc[i - 1] + pop[i];
			sqrtAcc[i] = sqrtAcc[i - 1] + pop[i] * pop[i]; // 최대 1000*1000*100,000
		}

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());

			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			long sum = ((acc[r] - acc[l - 1]) * (acc[r] - acc[l - 1]) - (sqrtAcc[r] - sqrtAcc[l - 1])) / 2;

			sb.append(sum).append("\n");
		}

		System.out.println(sb);
	}
}
