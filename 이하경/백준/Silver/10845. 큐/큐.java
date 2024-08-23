import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> q = new ArrayDeque<>();

	
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			if (cmd.equals("push")) {
				q.offer(Integer.parseInt(st.nextToken()));
			} else if (cmd.equals("pop")) {
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q.poll()).append("\n");
				}
			} else if (cmd.equals("size")) {
				sb.append(q.size()).append("\n");
			} else if (cmd.equals("empty")) {
				sb.append(q.isEmpty() ? 1 : 0).append("\n");
			} else if (cmd.equals("front")) {
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q.peekFirst()).append("\n");
				}
			} else {
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q.peekLast()).append("\n");
				}
			}

		}

		System.out.println(sb);
	}
}
