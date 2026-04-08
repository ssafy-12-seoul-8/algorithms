import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] tree;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int S = 1;

		while (S < N) {
			S *= 2;
		}

		tree = new int[S * 2][2];

		for (int i = S; i < S + N; i++) {
			int num = Integer.parseInt(br.readLine());
			tree[i][0] = num;
			tree[i][1] = num;
		}

		for (int i = S - 1; i > 0; i--) {
			int left = i * 2;
			int right = i * 2 + 1;
			tree[i][0] = Math.min(tree[left][0], tree[right][0]);
			tree[i][1] = Math.max(tree[left][1], tree[right][1]);
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[] ans = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
			find(1, 1, S, a, b, ans);
			sb.append(ans[0]).append(" ").append(ans[1]).append("\n");
		}

		System.out.println(sb);
	}

	static void find(int node, int l, int r, int targetL, int targetR, int[] ans) {
		if (l > targetR || r < targetL) {
			return;
		}

		if (l >= targetL && r <= targetR) {
			ans[0] = Math.min(ans[0], tree[node][0]);
			ans[1] = Math.max(ans[1], tree[node][1]);
			return;
		}

		int left = node * 2;
		int right = node * 2 + 1;
		int mid = (l + r) / 2;
		find(left, l, mid, targetL, targetR, ans);
		find(right, mid + 1, r, targetL, targetR, ans);
	}
}