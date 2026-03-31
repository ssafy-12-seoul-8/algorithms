import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] commute = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int o = Integer.parseInt(st.nextToken());
			commute[i][0] = Math.min(h, o);
			commute[i][1] = Math.max(h, o);
		}

		int d = Integer.parseInt(br.readLine());
		Arrays.sort(commute, Comparator.comparingInt(o -> o[1]));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int ans = 0;

		for (int i = 0; i < n; i++) {
			int h = commute[i][0];
			int o = commute[i][1];
			pq.add(h);

			while (!pq.isEmpty()) {
				if (pq.peek() < o - d) {
					pq.poll();
				} else {
					break;
				}
			}

			ans = Math.max(ans, pq.size());
		}

		System.out.println(ans);
	}
}