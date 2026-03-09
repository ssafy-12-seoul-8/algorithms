import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] conn = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			conn[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			conn[U].add(V);
			conn[V].add(U);
		}

		int[] parent = new int[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		parent[R] = R;
		queue.add(R);
		Stack<Integer> order = new Stack<>();

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			order.add(cur);

			for (int next : conn[cur]) {
				if (parent[next] == 0) {
					parent[next] = cur;
					queue.add(next);
				}
			}
		}

		int[] size = new int [N + 1];
		Arrays.fill(size, 1);

		while (!order.isEmpty()) {
			int cur = order.pop();

			if (cur == R) {
				continue;
			}

			int p = parent[cur];
			size[p] += size[cur];
		}

		for (int i = 0; i < Q; i++) {
			sb.append(size[Integer.parseInt(br.readLine())]).append("\n");
		}

		System.out.println(sb);
	}
}
