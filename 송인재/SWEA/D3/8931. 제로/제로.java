import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			int k = Integer.parseInt(br.readLine());
			Deque<Integer> stack = new ArrayDeque<>();
			
			for (int i = 0; i < k; i++) {
				int number = Integer.parseInt(br.readLine());
				
				if (number == 0) {
					stack.pop();
				} else {
					stack.push(number);
				}
			}
			
			long sum = 0;
			
			while (!stack.isEmpty()) {
				sum += stack.pop();
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
	
}