import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		sb.append("<");
		
		while (!q.isEmpty()) {
			for (int i = 0; i < k - 1; i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll()).append(", ");
		}

		sb.setLength(sb.length() - 2);
		sb.append(">");

		System.out.println(sb);
	}

}
