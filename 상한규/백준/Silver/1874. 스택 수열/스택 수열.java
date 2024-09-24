import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int currentValue = 0;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int targetValue = Integer.parseInt(br.readLine());
			
			if(targetValue <= currentValue && !stack.isEmpty() && stack.peek() != targetValue) {
				sb = new StringBuilder().append("NO").append("\n");
				
				break;
			} else {
				while(currentValue < targetValue) {
					stack.push(++currentValue);
					sb.append("+").append("\n");
				}
				
				if(stack.peek() == targetValue) {
					stack.pop();
					sb.append("-").append("\n");
				}
			}
		}
		System.out.print(sb);
	}
}