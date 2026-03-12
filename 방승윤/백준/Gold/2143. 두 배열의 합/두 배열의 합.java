import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int[] a = new int[n * (n + 1) / 2];
		int idx = 0;

		for (int i = 0; i < n; i++) {
			a[idx++] = A[i];

			for (int j = i + 1; j < n; j++) {
				a[idx] = a[idx++ - 1] + A[j];
			}
		}

		int m = Integer.parseInt(br.readLine());
		int[] B = new int[m];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		HashMap<Integer, Integer> b = new HashMap<>();

		for (int i = 0; i < m; i++) {
			int sum = B[i];
			b.put(sum, b.getOrDefault(sum, 0) + 1);

			for (int j = i + 1; j < m; j++) {
				sum += B[j];
				b.put(sum, b.getOrDefault(sum, 0) + 1);
			}
		}

		long ans = 0;

		for (int i = 0; i < n * (n + 1) / 2; i++) {
			ans += b.getOrDefault(T - a[i], 0);
		}

		System.out.println(ans);
	}
}
