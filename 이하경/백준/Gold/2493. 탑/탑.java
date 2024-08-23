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
		
		Deque<Tower> stack = new ArrayDeque<>();
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			int k = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty() && stack.peekFirst().height <= k) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				sb.append(0).append(" ");
			} else {
				sb.append(stack.peekFirst().index).append(" ");
			}
			stack.push(new Tower(i, k));
		}

		System.out.println(sb);
	}
}

class Tower {
	int index;
	int height;

	public Tower(int index, int height) {
		this.index = index;
		this.height = height;
	}
}
