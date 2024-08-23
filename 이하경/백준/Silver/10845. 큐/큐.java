import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] q = new int[n];
		int front = -1, back = -1;

	
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			if (cmd.equals("push")) {
				q[++back] = Integer.parseInt(st.nextToken());
			} else if (cmd.equals("pop")) {
				if (front == back) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q[++front]).append("\n");
				}
			} else if (cmd.equals("size")) {
				sb.append(back - front).append("\n");
			} else if (cmd.equals("empty")) {
				sb.append(front == back ? 1 : 0).append("\n");
			} else if (cmd.equals("front")) {
				if (front == back) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q[front + 1]).append("\n");
				}
			} else {
				if (front == back) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q[back]).append("\n");
				}
			}

		}

		System.out.println(sb);
	}
}
