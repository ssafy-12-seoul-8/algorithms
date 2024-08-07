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
            
            System.out.println("#" + test_case + " " + evalPostfix(infixToPostfix(expression)));

		}
		
		
        
	}
	
	public static String infixToPostfix(String infix) {
		String postfix = "";
		Stack<Character> stk = new Stack<>();
		
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			
			if (c == '+' && stk.isEmpty()) {
				stk.push(c);
			} else {
				postfix += c;
			}
		}
		
		postfix += stk.pop();
        
		return postfix;
    }
	
	public static int evalPostfix(String postfix) {
		
		Stack<Integer> stk = new Stack<>();
		
		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			if (c != '+') {
				stk.push(c - '0');
			} else {
				int result = stk.pop() + stk.pop();
				stk.push(result);
			}

		}
		
		return stk.pop();
	}
    
}