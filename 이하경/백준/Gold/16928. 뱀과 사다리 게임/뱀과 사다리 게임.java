import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// ladder[i]는 i번 위치에서 사다리로 이동하는 위치
		int[] ladder = new int[101];
		int[] visit = new int[101];

		for (int i = 0; i < n + m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			ladder[u] = v;
		}

		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		visit[1] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 1; i <= 6; i++) {
				int next = cur + i;
				if (next < 100 && visit[next] == 0) {
					if (ladder[next] != 0) {
						next = ladder[next];
					}
					if (visit[next] == 0) {
						visit[next] = visit[cur] + 1;
					}
					q.offer(next);
				} else if (next == 100) {
					System.out.println(visit[cur] + 1);
					return;
				}

			}
		}
	}
}
