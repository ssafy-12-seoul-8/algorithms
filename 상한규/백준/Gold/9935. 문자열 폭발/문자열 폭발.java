import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] targetArray = br.readLine().toCharArray();
		char[] bombArray = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < targetArray.length; i++) {
			stack.push(targetArray[i]);
			if(targetArray[i] == bombArray[bombArray.length - 1] && stack.size() >= bombArray.length) {
				boolean isSame = true;
				
				for(int j = bombArray.length - 1; j >= 0 ; j--) {
					if(stack.get(stack.size() - (bombArray.length - 1 - j) - 1) != bombArray[j]) {
						isSame = false;
						
						break;
					}
				}
				
				if(isSame) {
					for(int j = 0; j < bombArray.length; j++) {
						stack.pop();
					}
				}
			}
		}
		
		if(stack.isEmpty()) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			for(char value : stack) {
				sb.append(value);
			}
			System.out.println(sb);
		}
	}
}
