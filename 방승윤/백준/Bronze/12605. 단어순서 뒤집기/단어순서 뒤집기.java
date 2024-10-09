import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<String> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			sb.append("Case #").append(i + 1).append(": ");
			
			st = new StringTokenizer(br.readLine());
			
			while (st.hasMoreTokens()) {
				stack.push(st.nextToken());
			}
			
			while (!stack.isEmpty()) {
				sb.append(stack.pop()).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}