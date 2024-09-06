import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] next = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			next[i] = new ArrayList<>();
		}

		int[] prevCnt = new int[n + 1]; // 나보다 앞에있는 사람이 몇명 남았는지 저장
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			next[a].add(b);
			prevCnt[b]++;
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (prevCnt[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr).append(" ");

			for (int b : next[curr]) {
				prevCnt[b]--;
				if (prevCnt[b] == 0) {
					q.offer(b);
				}
			}
		}

		System.out.println(sb);
	}
}
