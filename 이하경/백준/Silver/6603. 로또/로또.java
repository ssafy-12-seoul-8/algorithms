import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int[] set, pick;
	static StringBuilder sb = new StringBuilder();

	// k < 13 이므로 최대 12C6 = 924
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());

			if (k == 0) {
				break;
			}

			set = new int[k];
			pick = new int[6];
			for (int i = 0; i < k; i++) {
				set[i] = Integer.parseInt(st.nextToken());
			}

			perm(0, 0);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void perm(int start, int sidx) {
		if (sidx == 6) {
			for (int p : pick) {
				sb.append(p).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < k; i++) {
			pick[sidx] = set[i];
			perm(i + 1, sidx + 1);
		}
	}
}
