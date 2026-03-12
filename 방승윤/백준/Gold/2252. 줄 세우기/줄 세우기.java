import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] arrayLists = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			arrayLists[i] = new ArrayList<>();
		}

		int[] cnt = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			arrayLists[l].add(r);
			cnt[r]++;
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (cnt[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur).append(" ");

			for (int next : arrayLists[cur]) {
				if (--cnt[next] == 0) {
					queue.add(next);
				}
			}
		}

		System.out.println(sb);
	}
}
