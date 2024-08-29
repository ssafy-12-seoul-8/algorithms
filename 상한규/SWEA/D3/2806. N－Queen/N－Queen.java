import java.util.*;
import java.io.*;

public class Solution {
	static int N, result;
	static int[] column;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			result = 0;
			column = new int[N];
			
			recur(0);
			
			System.out.printf("#%d %d\n", tc + 1, result);
		}
	}
	
	static void recur(int count) {
		if(count == N) {
			result++;
			
			return ;
		} else {
			for(int i = 0; i < N; i++) {
				if(check(count, i)) {
					column[count] = i;
					
					recur(count + 1);
				}
			}
		}
	}
	static boolean check(int r, int c) {
		for(int i = 0; i < r; i++) {
			if(column[i] == c || Math.abs(column[i] - c) == Math.abs(i - r)) {
				return false;
			}
		}
		return true;
	}
}
