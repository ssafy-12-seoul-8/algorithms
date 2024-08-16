import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[] a = new int[n];
			int[] b = new int[m];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}

			int max = Integer.MIN_VALUE;
			if (n > m) {
				for (int i = 0; i <= n - m; i++) { // a의 idx
					int sum = 0;
					for (int j = 0; j < m; j++) { // b의 idx
						sum += a[i + j] * b[j];
					}
					max = Math.max(max, sum);
				}
			} else {
				for (int j = 0; j <= m - n; j++) {
					int sum = 0;
					for (int i = 0; i < n; i++) {
						sum += a[i] * b[j + i];
					}
					max = Math.max(max, sum);
				}
			}

			sb.append(max).append("\n");

		}

		System.out.println(sb);
	}
}
