import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] currPerm = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			currPerm[i] = Integer.parseInt(st.nextToken());
		}

		int end = -1;
		int next = currPerm[n];
		for (int i = n - 1; i > 0; i--) {
			if (currPerm[i] < next) {
				end = i;
				break;
			}
			next = currPerm[i];
		}

		if (end == -1) {
			System.out.println(-1);
			return;
		}

		boolean[] used = new boolean[n + 1];
		for (int i = 1; i < end; i++) {
			used[currPerm[i]] = true;
			sb.append(currPerm[i]).append(" ");
		}

		for (int i = currPerm[end] + 1; i <= n; i++) {
			if (!used[i]) {
				used[i] = true;
				sb.append(i).append(" ");
				break;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (!used[i]) {
				sb.append(i).append(" ");
			}
		}

		System.out.println(sb);
	}
}
