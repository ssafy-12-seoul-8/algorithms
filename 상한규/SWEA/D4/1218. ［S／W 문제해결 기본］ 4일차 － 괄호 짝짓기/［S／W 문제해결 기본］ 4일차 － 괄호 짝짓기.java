import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		List<Character> startBracket = new ArrayList<>(Arrays.asList('(', '[', '{', '<'));
		List<Character> endBracket = new ArrayList<>(Arrays.asList(')', ']', '}', '>'));
		
		for(int i = 0; i < T; i++) {
			int length = Integer.parseInt(br.readLine());
			boolean result = true;
			char[] charArray = br.readLine().toCharArray();
			
			Stack<Character> stack = new Stack<>();

			
			for(int j = 0; j < length; j++) {
				if(stack.isEmpty()) {
					stack.push(charArray[j]);
					continue;
				}
				
				char peekValue = stack.peek();
				int bracketIndex = startBracket.indexOf(peekValue);
				
				if(endBracket.get(bracketIndex) == charArray[j]) {
					stack.pop();
				}
				else if(endBracket.get(bracketIndex) != charArray[j] && endBracket.contains(charArray[j])) {
					result = false;
					break;
				}
				else {
					stack.push(charArray[j]);
				}
			}
			
			System.out.printf("#%d %d\n", i + 1, result ? 1 : 0);
		}
	}
}
