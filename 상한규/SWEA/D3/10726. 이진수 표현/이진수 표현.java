import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int resultBit = (int)Math.pow(2, N) - 1;
			boolean result = false;
			
			if((M & resultBit) == resultBit) {
				result = true;
			}
			
			System.out.printf("#%d %s\n", test_case, result ? "ON" : "OFF");
		}
	}
}
