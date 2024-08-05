import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			char[] pipes = br.readLine()
					.toCharArray();
			Deque<Character> stack = new ArrayDeque<>();
			int sum = 0;
			
			for (int i = 0; i < pipes.length; i++) {
				if (stack.isEmpty()) {
					stack.push(pipes[i]);
					
					continue;
				}
				
				if (pipes[i] == '(') {
					if (stack.peek() != pipes[i]) {
						stack.pop();
					}
					
					stack.push(pipes[i]);
					
					continue;
				}
				
				if (stack.pop() != pipes[i]) {
					sum += stack.size();
					
					stack.push(pipes[i]);
					
					continue;
				}
				
				sum += 1;
				
				stack.pop();
				stack.push(pipes[i]);
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
	
}