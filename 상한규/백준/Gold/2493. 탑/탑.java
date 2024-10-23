import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] resultArray = new int[N];
		int index = 0;
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stackIndex = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		boolean isExist = false;
		
		while(st.hasMoreTokens()) {
			int value = Integer.parseInt(st.nextToken());

			while(true) {
				if(stack.isEmpty() || stack.peek() >= value) {
					resultArray[index] = stackIndex.size() == 0 ? 0 : stackIndex.peek() + 1;
					stack.push(value);
					stackIndex.push(index);
					
					break;
				} else {
					stack.pop();
					stackIndex.pop();
				}
			}
			index++;
		}

		for(int result : resultArray) {
			if(!isExist && result != 0) {
				isExist = true;
			}
			sb.append(result).append(" ");
		}
		if(!isExist) {
			System.out.println(0);
		} else {
			System.out.println(sb);
		}
	}
}
