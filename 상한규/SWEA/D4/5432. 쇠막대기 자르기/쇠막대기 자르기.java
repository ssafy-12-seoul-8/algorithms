import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int result = 0;
			String bracketString = br.readLine();
			char[] charArray = bracketString.toCharArray();
			Stack<Character> stack = new Stack<>();
			
			for(int j = 0; j < charArray.length; j++) {
				if(stack.isEmpty()) {
					stack.push(charArray[j]);
					continue;
				}
				if(charArray[j] == ')' && charArray[j - 1] == '(') {
					stack.pop();
					result += stack.size();
				}
				else if (charArray[j] == ')') {
					stack.pop();
					result += 1;
				}
				else {
					stack.push(charArray[j]);
				}
			}
			
			System.out.printf("#%d %d\n", i + 1, result);
		}
	}
}
