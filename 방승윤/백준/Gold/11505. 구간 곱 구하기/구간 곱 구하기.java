import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;
	static int MOD = 1_000_000_007;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int S = 1;

		while (S < N) {
			S *= 2;
		}

		tree = new long[S * 2];

		for (int i = S; i < S + N; i++) {
			int num = Integer.parseInt(br.readLine());
			tree[i] = num;
		}

		for (int i = S - 1; i > 0; i--) {
			int left = i * 2;
			int right = i * 2 + 1;
			tree[i] = (tree[left] * tree[right]) % MOD;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 1) {
				b += S - 1;
				tree[b] = c;
				b /= 2;

				while (b > 0) {
					tree[b] = (tree[b * 2] * tree[b * 2 + 1]) % MOD;
					b /= 2;
				}

				continue;
			}

			sb.append(multi(1, 1, S, b, c)).append("\n");
		}

		System.out.println(sb);
	}

	static long multi(int node, int l, int r, int targetL, int targetR) {
		if (l > targetR || r < targetL) {
			return 1;
		}

		if (l >= targetL && r <= targetR) {
			return tree[node];
		}

		int left = node * 2;
		int right = node * 2 + 1;
		int mid = (l + r) / 2;
		return (multi(left, l, mid, targetL, targetR) * multi(right, mid + 1, r, targetL, targetR)) % MOD;
	}
}