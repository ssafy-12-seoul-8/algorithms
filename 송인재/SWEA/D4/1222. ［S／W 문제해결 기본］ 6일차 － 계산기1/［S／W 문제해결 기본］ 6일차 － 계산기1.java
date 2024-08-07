import java.io.*;
import java.util.*;

class Solution {
	
	static final int cases = 10;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Character> firstStack = new ArrayDeque<>();
		Deque<Character> secondStack = new ArrayDeque<>();
		
		for (int t = 1; t <= cases; t++) {
			int n = Integer.parseInt(br.readLine());
			char[] eq = br.readLine()
					.toCharArray();
			
			for (int i = 0; i < n; i++) {
				if (eq[i] == '+') {
					while (!firstStack.isEmpty()) {
						secondStack.push(firstStack.pop());
					}
				}
				
				firstStack.push(eq[i]);
			}
			
			while (!secondStack.isEmpty()) {
				firstStack.push(secondStack.pop());
			}
			
			int sum = 0;
			
			while (!firstStack.isEmpty()) {
				if (firstStack.peek() != '+') {
					secondStack.push(firstStack.pop());
					
					continue;
				}
				
				while (!secondStack.isEmpty()) {
					sum += secondStack.pop() - '0';
				}
				
				firstStack.pop();
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
	
}