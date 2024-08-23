import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] deque = new int[2 * n + 1];
		int head = n, tail = n;

	
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			switch (cmd) {
			case "push_front":
				deque[head--] = Integer.parseInt(st.nextToken());
				break;
			case "push_back":
				deque[++tail] = Integer.parseInt(st.nextToken());
				break;
			case "pop_front":
				if (head == tail) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque[++head]).append("\n");
				}
				break;
			case "pop_back":
				if (head == tail) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque[tail--]).append("\n");
				}
				break;
			case "size":
				sb.append(tail - head).append("\n");
				break;
			case "empty":
				sb.append(head == tail ? 1 : 0).append("\n");
				break;
			case "front":
				if (head == tail) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque[head + 1]).append("\n");
				}
				break;
			default:
				if (head == tail) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque[tail]).append("\n");
				}
				break;
			}

		}

		System.out.println(sb);
	}
}
