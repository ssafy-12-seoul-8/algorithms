import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			Deque<Character> stack = new ArrayDeque<>();
			char[] line = br.readLine().toCharArray();
			String result = "YES";

			for (int j = 0; j < line.length; j++) {
				if (line[j] == '(') {
					stack.push(line[j]);

					continue;
				}

				if (stack.isEmpty() || stack.peek() != '(') {
					result = "NO";

					break;
				}

				stack.pop();
			}

			if (!stack.isEmpty()) {
				result = "NO";
			}

			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}

}
