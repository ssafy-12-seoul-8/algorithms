import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		tree = new long[N * 4];
		int s = 1;

		while (s < N) {
			s *= 2;
		}

		for (int i = s; i < s + N; i++) {
			long num = Long.parseLong(br.readLine());
			tree[i] = num;
		}

		for (int i = s - 1; i > 0; i--) {
			int left = i * 2;
			int right = i * 2 + 1;
			tree[i] = tree[left] + tree[right];
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == 1) {
				long c = Long.parseLong(st.nextToken());
				b += s - 1;
				tree[b] = c;
				b /= 2;

				while (b > 0) {
					int left = b * 2;
					int right = b * 2 + 1;
					tree[b] = tree[left] + tree[right];
					b /= 2;
				}

				continue;
			}

			int c = Integer.parseInt(st.nextToken());
			sb.append(sum(1, 1, s, b, c)).append("\n");
		}

		System.out.println(sb);
	}

	static long sum(int node, int l, int r, int targetL, int targetR) {
		if (targetL > r || targetR < l) {
			return 0;
		}

		if (targetL <= l && targetR >= r) {
			return tree[node];
		}

		int mid = (l + r) / 2;

		return sum(node * 2, l, mid, targetL, targetR) + sum(node * 2 + 1, mid + 1, r, targetL, targetR);
	}
}