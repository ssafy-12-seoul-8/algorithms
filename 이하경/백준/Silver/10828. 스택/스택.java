import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] stack;
	static int top;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		init(n);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if (cmd.equals("push")) {
				push(Integer.parseInt(st.nextToken()));
			} else if (cmd.equals("pop")) {
				sb.append(pop()).append("\n");
			} else if (cmd.equals("size")) {
				sb.append(size()).append("\n");
			} else if (cmd.equals("empty")) {
				sb.append(isEmpty() ? 1 : 0).append("\n");
			} else {
				sb.append(top()).append("\n");
			}
		}

		System.out.println(sb);
	}

	static void init(int n) {
		stack = new int[n];
		top = -1;
	}

	static void push(int x) {
		stack[++top] = x;
	}

	static int pop() {
		if (isEmpty()) {
			return -1;
		}
		return stack[top--];
	}

	static int size() {
		return top + 1;
	}

	static boolean isEmpty() {
		return top == -1;
	}

	static int top() {
		if (isEmpty()) {
			return -1;
		}
		return stack[top];
	}

}
