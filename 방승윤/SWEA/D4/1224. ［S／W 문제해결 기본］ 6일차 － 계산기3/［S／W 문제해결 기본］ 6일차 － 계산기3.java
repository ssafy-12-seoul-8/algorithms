import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{

            int N = sc.nextInt();
            String expression = sc.next();
            
            System.out.println("#" + test_case + " " + evaluate(expression));

		}
		    
	}
	
	public static int evaluate(String expression) {
		String postfix = infixToPostfix(expression);
		return evalPostfix(postfix);
	}
	
	
	public static Map<Character, Integer> map = new HashMap<>();
	
	static {
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
	}
	
	public static String infixToPostfix(String infix) {
		String postfix = "";
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			
			if (c >= '0' && c <= '9') {
				postfix += c;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				char popItem = stack.pop();
				while (popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();
				}
			} else {
				while (!stack.isEmpty() && stack.peek() != '(' && map.get(stack.peek()) >= map.get(c)) {
					char popItem = stack.pop();
					postfix += popItem;
				}
				stack.push(c);
			}
		}
		
		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}
        
		return postfix;
    }
	
	public static int evalPostfix(String postfix) {
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			if (c >= '0' && c <= '9') {
				stack.push(c - '0');
			} else {
				int num1 = stack.pop();
				int num2 = stack.pop();
				int result;
				
				if (c == '+') {
					result = num2 + num1;
				} else if (c == '-') {
					result = num2 - num1;
				} else if (c == '*') {
					result = num2 * num1;
				} else {
					result = num2 / num1;
				}
				
				stack.push(result);
			}
			
		}
		
		return stack.pop();
	}
    
}