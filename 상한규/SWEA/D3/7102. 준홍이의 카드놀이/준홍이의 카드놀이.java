import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			System.out.printf("#%d ",i + 1);
			if(N == M) {
				System.out.print(N + 1);
			}
			else {
				int max = Math.max(N, M);
				int min = Math.min(N, M);
				
				for(int j = min + 1; j <= max + 1; j++) {
					System.out.printf("%d ", j);
				}
			}
			System.out.println();
		}
	}
}