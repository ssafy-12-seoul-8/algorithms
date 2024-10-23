import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		
		for(int i = 0; i < K; i++) {
			int value = Integer.parseInt(br.readLine());
			
			if(value == 0) {
				stack.pop();
			} else {
				stack.push(value);
			}
		}
		
		while(!stack.isEmpty()) {
			result += stack.pop();
		}
		
		System.out.println(result);
	}
}
