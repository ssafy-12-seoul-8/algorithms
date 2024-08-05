import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int K = Integer.parseInt(br.readLine());
			int[] stack = new int[K];
			int index = -1;
			int result = 0;
			
			for(int j = 0; j < K; j++) {
				int value = Integer.parseInt(br.readLine());
				
				if(value != 0) {
					stack[++index] = value;
				}
				else {
					stack[index--] = value;
				}
			}
			
			for(int j = 0; j < stack.length; j++) {
				result += stack[j];
			}
			
			System.out.printf("#%d %d\n", i + 1, result);
		}
	}
}
