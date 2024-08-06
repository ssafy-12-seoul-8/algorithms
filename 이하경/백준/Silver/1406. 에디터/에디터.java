import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Character> leftStack = new ArrayDeque<>();
		Deque<Character> rightStack = new ArrayDeque<>();

		String init = br.readLine();
		int n = init.length();
		
		for (int i = 0; i < n; i++) {
			leftStack.push(init.charAt(i));
		}

		int m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < m; i++) {
			String input = br.readLine();
			char cmd = input.charAt(0);
			
			if (cmd == 'L') {
				if (!leftStack.isEmpty()) {
					rightStack.push(leftStack.pop());
				}
			} else if (cmd == 'D') {
				if (!rightStack.isEmpty()) {
					leftStack.push(rightStack.pop());
				}
			} else if (cmd == 'B') {
				if (!leftStack.isEmpty()) {
					leftStack.pop();
				}
			} else {
				leftStack.push(input.charAt(2));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (!leftStack.isEmpty()) {
			sb.append(leftStack.pollLast());
		}
		
		while (!rightStack.isEmpty()) {
			sb.append(rightStack.pollFirst());
		}
		
		System.out.println(sb);

	}

}
