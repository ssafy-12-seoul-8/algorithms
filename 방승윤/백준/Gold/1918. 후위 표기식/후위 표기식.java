import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] expression = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();

		for (char word : expression) {
			if (word >= 'A' && word <= 'Z') {
				sb.append(word);
				continue;
			}

			if (stack.isEmpty()) {
				stack.push(word);
				continue;
			}

			if (word == '(') {
				stack.push(word);
				continue;
			}

			if (word == ')') {
				while (true) {
					if (stack.peek() == '(') {
						stack.pop();
						break;
					}

					sb.append(stack.pop());
				}

				continue;
			}

			if (word == '+' || word == '-') {
				if (stack.peek() == '*' || stack.peek() == '/') {
					sb.append(stack.pop());
				}

				if (!stack.isEmpty() && (stack.peek() == '+' || stack.peek() == '-')) {
					sb.append(stack.pop());
				}

				stack.push(word);
				continue;
			}

			if (word == '*' || word == '/') {
				if (stack.peek() == '*' || stack.peek() == '/') {
					sb.append(stack.pop());
				}

				stack.push(word);
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb);
	}
}
