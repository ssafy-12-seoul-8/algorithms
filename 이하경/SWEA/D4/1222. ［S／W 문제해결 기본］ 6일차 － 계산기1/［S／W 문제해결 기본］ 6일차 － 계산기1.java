import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	static int n;
	static Map<Character, Integer> priority = new HashMap<>();
	
	static {
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('(', 0);
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	for (int t = 1; t <= 10 ; t++) {
    		n = Integer.parseInt(br.readLine());
    		String expression = br.readLine();
			
    		sb.append("#").append(t).append(" ").append(evaluate(inToPost(expression))).append("\n");
		}
    	
    	System.out.println(sb);
    }
    
    public static String inToPost (String infix) {
    	StringBuilder postfix = new StringBuilder();
    	Deque<Character> stack = new ArrayDeque<>();
    	
    	for (int i = 0; i < n; i++) {
			char c = infix.charAt(i);
			
			if (c >= '0' && c <= '9') { // 피연산자인 경우
				postfix.append(c);
			} else if (c == '(') {
				stack.push('(');
			} else if (c == ')') {
				char top = stack.pop();
				while (top != '(') {
					postfix.append(top);
					top = stack.pop();
				}
			} else { // 괄호가 아닌 연산자인 경우
				// pop 할 기준 넣어주기
				while (!stack.isEmpty() && priority.get(stack.peek()) >= priority.get(c)) {
					postfix.append(stack.pop());
				}
				stack.push(c);
			}
		}
    	
    	while (!stack.isEmpty()) {
    		postfix.append(stack.pop());
    	}
    	
    	return postfix.toString();
    }
    
    public static int evaluate (String postfix) {
    	Deque<Integer> stack = new ArrayDeque<>();
    	
    	int m = postfix.length();
    	for (int i = 0; i < m; i++) {
    		char c = postfix.charAt(i);
			// 숫자라면 stack에 넣기
    		if (c >= '0' && c <= '9') {
    			stack.add(c - '0');
    		} else {
    			int num2 = stack.pop();
    			int num1 = stack.pop();
    			int res = 0;
 
    			if (c == '+') {
    				res = num1 + num2;
	    		} else if (c == '-') {
	    			res = num1 - num2;
	    		} else if (c == '*') {
	    			res = num1 * num2;
	    		} else if (c == '/') {
	    			res = num1 / num2;
	    		}
    			
    			stack.push(res);
    		}
		}
    	
    	return stack.pop();

    }
    
}
