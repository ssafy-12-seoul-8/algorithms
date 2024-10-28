import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int Q = Integer.parseInt(st.nextToken());
		int mod = Integer.parseInt(st.nextToken());
		int size = 0;
		Stack<Integer>[] stackArray = new Stack[mod];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < mod; i++) {
			stackArray[i] = new Stack<Integer>();
		}
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int operator = Integer.parseInt(st.nextToken());
			
			switch (operator) {
				case 1: {
					int num = Integer.parseInt(st.nextToken());
					int remain = num % mod;
					
					stackArray[remain].push(size++);

					break;
				}
				case 2: {
					for(int j = 0; j < mod; j++) {
						if(!stackArray[j].isEmpty() && stackArray[j].peek() == (size - 1)) {
							stackArray[j].pop();
							size--;
							
							break;
						}
					}
					
					break;
				}
				case 3: {
					int value = Integer.MAX_VALUE;
					
					for(int j = 0; j < mod; j++) {
						if(stackArray[j].isEmpty()) {
							value = -1;
							
							break;
						} else {
							value = Math.min(value, stackArray[j].peek());
						}
					}
					
					if(value != -1) {
						value = size - value;
					}

					sb.append(value).append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
