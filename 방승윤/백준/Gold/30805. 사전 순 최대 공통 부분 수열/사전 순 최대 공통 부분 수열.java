import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> A = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			A.offer(Integer.parseInt(st.nextToken()));
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Queue<Integer> B = new LinkedList<>();

		for (int i = 0; i < M; i++) {
			B.offer(Integer.parseInt(st.nextToken()));
		}

		Queue<Integer> queue = new LinkedList<>();
		int K = 0;

		while (!A.isEmpty() && !B.isEmpty()) {
			int max = 0;

			for (Integer num : A) {
				if (B.contains(num)) {
					max = Math.max(max, num);
				}
			}

			if (max == 0) {
				break;
			}

			queue.offer(max);
			K++;

			while (A.poll() != max);
			while (B.poll() != max);
		}

		StringBuilder sb = new StringBuilder();
		sb.append(K).append("\n");

		for (Integer num : queue) {
			sb.append(num).append(" ");
		}

		System.out.println(sb);
	}
}
