import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int result = 0;
			int N = Integer.parseInt(br.readLine());
			
			if(N == 1) {
				result = Integer.parseInt(br.readLine());

				System.out.printf("#%d %d\n", i + 1 , result);
				continue;
			}
			
			String[][] board = new String[N][N];
			
			Queue<Integer> queue = new LinkedList<>();
			
			for(int j = 0; j < N; j++) {
				board[j] = br.readLine().split("");
				
				for(int k = 0; k < N; k++) {
					queue.offer(Integer.parseInt(board[j][k]));
				}
				
				if(j < N /2) {
					for(int k = j; k < N / 2; k++) {
						queue.poll();
					}
					
					for(int k = 0; k < 1 + j * 2; k++) {
						result += queue.poll();
					}
					
					for(int k = j; k < N / 2; k++) {
						queue.poll();
					}
				} else if(j == N / 2) {
					for(int k = 0; k < N; k++) {
						result += queue.poll();
					}
				} else {
					for(int k =  N - j - 1; k < N / 2; k++) {
						queue.poll();
					}
					
					for(int k = 0; k < 1 + (N - j - 1) * 2; k++) {
						result += queue.poll();
					}
					
					for(int k = N - j - 1; k < N / 2; k++) {
						queue.poll();
					}
				}
			}
			
			System.out.printf("#%d %d\n", i + 1 , result);
		}
	}
}