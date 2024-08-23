import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Deque<Integer> stack = new ArrayDeque<>();
		int n = Integer.parseInt(br.readLine());

		int num = 1;
		boolean flag = true;
		for (int i = 0; i < n; i++) {

			int k = Integer.parseInt(br.readLine());
			while (num < k) {
				stack.push(num++);
				sb.append("+").append("\n");
			}
			if (num == k) {
				sb.append("+").append("\n").append("-").append("\n");
				num++;
				continue;
			}
			int peek = stack.pop();
			if (peek == k) {
				sb.append("-").append("\n");
			} else {
				flag = false;
				break;
			}
		}

		System.out.println(flag ? sb : "NO");
	}
}
