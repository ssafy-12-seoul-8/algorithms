import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		int[] B = new int[n];
		int[] C = new int[n];
		int[] D = new int[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}

		int[] AB = new int[n * n];
		int[] CD = new int[n * n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				AB[i * n + j] = A[i] + B[j];
				CD[i * n + j] = C[i] + D[j];
			}
		}

		Arrays.sort(AB);
		Arrays.sort(CD);
		int ab = 0;
		int cd = n * n - 1;
		long ans = 0;

		while (ab < n * n && cd >= 0) {
			int sum = AB[ab] + CD[cd];

			if (sum == 0) {
				int cntAB = 0;
				int cntCD = 0;
				int curAB = AB[ab];
				int curCD = CD[cd];

				while (ab < n * n && AB[ab] == curAB) {
					cntAB++;
					ab++;
				}

				while (cd >= 0 && CD[cd] == curCD) {
					cntCD++;
					cd--;
				}

				ans += (long) cntAB * cntCD;
				continue;
			}

			if (sum >= 0) {
				cd--;
			} else {
				ab++;
			}
		}

		System.out.println(ans);
	}
}
