import java.io.*;
import java.util.*;

class Solution {
	static Map<Character, Integer> map = new HashMap<>();
	
	static {
		map.put('+', 1);
		map.put('*', 2);
	}
	
	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int result = 0;
			int infixLength = Integer.parseInt(br.readLine());
			String infix = br.readLine();
			Stack<Character> stack = new Stack<>();
			Stack<Integer> intStack = new Stack<>();
			String postfix = "";
			
			for(int i = 0; i < infixLength; i++) {
				char value = infix.charAt(i);
				
				if('0' <= value && value <= '9') {
					postfix += value;
				}
				else if(value == '(') {
					stack.push(value);
				}
				else if(value == ')') {
					char popItem = stack.pop();
					while(popItem != '(') {
						postfix += popItem;
						popItem = stack.pop();
					}
				}
				else {
					while(!stack.isEmpty() && stack.peek() != '(' && map.get(stack.peek()) >= map.get(value)) {
						char popItem = stack.pop();
						
						postfix += popItem;
					}
					stack.push(value);
				}
			}
			while(!stack.isEmpty()) {
				postfix += stack.pop();
			}
			
			for(int i = 0; i < postfix.length(); i++) {
				char value = postfix.charAt(i);
				
				if('0' <= value && value <= '9') {
					intStack.push(value - '0');
				}
				else {
					int value1 = intStack.pop();
					int value2 = intStack.pop();
					int number = 0;
					if(value == '+') {
						number = value1 + value2;
					}
					else if(value == '*') {
						number = value1 * value2;
					}
					intStack.push(number);
				}
			}
			result = intStack.pop();
			
			System.out.printf("#%d %d\n", test_case, result);
		}
	}
}