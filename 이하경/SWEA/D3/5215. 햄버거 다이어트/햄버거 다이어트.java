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
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int[] maxTaste = new int[l + 1];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int taste = Integer.parseInt(st.nextToken());
				int cal = Integer.parseInt(st.nextToken());
				for (int j = l - cal; j >= 0; j--) {
					maxTaste[j + cal] = Math.max(maxTaste[j + cal], maxTaste[j] + taste);
				}
			}
			sb.append("#").append(t).append(" ").append(maxTaste[l]).append("\n");
		}
		System.out.println(sb);
	}
}

