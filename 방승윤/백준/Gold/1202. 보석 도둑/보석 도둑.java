import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] jewel = new int[N][2];
		int[] C = new int[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewel[i][0] = Integer.parseInt(st.nextToken());
			jewel[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < K; i++) {
			C[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(jewel, Comparator.comparingInt(o -> o[0]));
		Arrays.sort(C);
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		int idx = 0;
		long ans = 0;

		for (int i = 0; i < K; i++) {

			while (idx < N && C[i] >= jewel[idx][0]) {
				pq.add(jewel[idx++][1]);
			}

			if (!pq.isEmpty()) {
				ans += pq.poll();
			}
		}

		System.out.println(ans);
	}
}
