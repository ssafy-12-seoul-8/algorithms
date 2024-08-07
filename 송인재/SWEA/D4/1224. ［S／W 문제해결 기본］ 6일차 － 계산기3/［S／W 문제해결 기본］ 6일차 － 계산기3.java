import java.io.*;
import java.util.*;

class Solution {
	
	static final int cases = 10;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<String> stack = new ArrayDeque<>();
		Queue<String> postfix = new LinkedList<>();
		
		for (int t = 1; t <= cases; t++) {
			int n = Integer.parseInt(br.readLine());
			char[] eq = br.readLine()
					.toCharArray();
			
			for (int i = 0; i < n; i++) {
				if (eq[i] == '+') {
					while (!stack.isEmpty() && !stack.peek().equals("(")) {
						postfix.add(stack.pop());
					}
				}
				
				if (eq[i] == ')') {
					while (!stack.isEmpty()) {
						String next = stack.pop();
						
						if (next.equals("(")) {
							break;
						}
						
						postfix.add(next);
					}
					
					continue;
				}
				
				if (eq[i] == '*') {
					while (!stack.isEmpty() && !stack.peek().equals("(") && !stack.peek().equals("+")) {
						postfix.add(stack.pop());
					}
				}
				
				stack.push(String.valueOf(eq[i]));
			}
			
			while (!stack.isEmpty()) {
				postfix.add(stack.pop());
			}
			
			while (!postfix.isEmpty()) {
				String nextStr = postfix.poll();
				char next = nextStr.charAt(0);
				
				if (next >= '0' && next <= '9') {
					stack.push(nextStr);
					
					continue;
				}

				int first = Integer.parseInt(stack.pop());
				int second = Integer.parseInt(stack.pop());
				
				stack.push(String.valueOf(next == '*' ? first * second : first + second));
			}
			
			System.out.println("#" + t + " " + stack.pop());
			stack.clear();
		}
	}
	
}