import java.io.*;
import java.util.*;

class Solution {
	
	static final int cases = 10;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Character, Character> map = new HashMap<>();
		
		map.put('(', ')');
		map.put('{', '}');
		map.put('<', '>');
		map.put('[', ']');
		
		for (int t = 1; t <= cases; t++) {
			int n = Integer.parseInt(br.readLine());
			char[] brackets = br.readLine()
					.toCharArray();
			Deque<Character> stack = new ArrayDeque<>();
			int index = 1;
			
			stack.push(brackets[0]);
			
			while (!stack.isEmpty()) {
				if (map.containsKey(brackets[index])) {
					stack.push(brackets[index++]);
					
					continue;
				}
				
				if (brackets[index++] == map.get(stack.pop())) {
					continue;
				}
				
				break;
			}
			
			int answer = stack.isEmpty() ? 1 : 0;
			
			System.out.println("#" + t + " " + answer);
		}
	}
	
}