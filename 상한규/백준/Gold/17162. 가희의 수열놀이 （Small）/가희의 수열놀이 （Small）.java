import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int Q = Integer.parseInt(st.nextToken());
		int mod = Integer.parseInt(st.nextToken());
		Stack<Integer> mainStack = new Stack<>();
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
					
					stackArray[remain].push(mainStack.size());
					mainStack.push(remain);
					
					break;
				}
				case 2: {
					if(!mainStack.isEmpty()) {
						int remain = mainStack.pop();
						
						stackArray[remain].pop();
					}
					
					break;
				}
				case 3: {
					int index = Integer.MAX_VALUE;
					
					for(int j = 0; j < mod; j++) {
						if(stackArray[j].isEmpty()) {
							index = -1;
							
							break;
						} else {
							index = Math.min(index, stackArray[j].peek());
						}
					}
					
					if(index != -1) {
						index = mainStack.size() - index;
					}

					sb.append(index).append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
