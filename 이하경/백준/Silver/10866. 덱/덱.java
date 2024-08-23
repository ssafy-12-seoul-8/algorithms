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
		Deque<Integer> deque = new ArrayDeque<>();

	
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			switch (cmd) {
			case "push_front":
				deque.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				deque.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.pollFirst()).append("\n");
				}
				break;
			case "pop_back":
				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.pollLast()).append("\n");
				}
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				sb.append(deque.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front":
				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.peekFirst()).append("\n");
				}
				break;
			default:
				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.peekLast()).append("\n");
				}
				break;
			}

		}

		System.out.println(sb);
	}
}
