import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String text = br.readLine();
		int K = Integer.parseInt(br.readLine());
		Stack<Character> frontStack = new Stack<>();
		Stack<Character> backStack = new Stack<>();
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < text.length(); i++) {
			frontStack.push(text.charAt(i));
		}
		
		for(int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			switch (st.nextToken()) {		
				case "L": {
					if(!frontStack.isEmpty()) {
						backStack.push(frontStack.pop());
					}
					
					break;
				}
				case "D": {
					if(!backStack.isEmpty()) {
						frontStack.push(backStack.pop());
					}
					
					break;
				}
				case "B": {
					if(!frontStack.isEmpty()) {
						frontStack.pop();
					}

					break;
				}
				case "P": {
					char value = st.nextToken().charAt(0);
					frontStack.push(value);

					break;
				}
			}
		}

		
		while(!frontStack.isEmpty()) {
			result.append(frontStack.pop());
		}
		
		result = result.reverse();

		while(!backStack.isEmpty()) {
			result.append(backStack.pop());
		}
		System.out.println(result);
	}
}
