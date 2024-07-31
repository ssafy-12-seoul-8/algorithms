import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		int T = Integer.parseInt(br.readLine());
		int[] result = new int[T];
		
		for(int testIndex = 0; testIndex < T; testIndex++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] board = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer line = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(line.nextToken());
				}
			}
			
			for(int i = 0; i <= board.length - M; i++) {
				for(int j = 0; j <= board[i].length - M; j++) {
					int sum = 0;
					for(int k = i; k < i +M; k++) {
						for(int l = j; l < j + M; l++) {
							sum += board[k][l];
						}
					}
					result[testIndex] = Math.max(result[testIndex], sum);
				}
			}
		}
		for(int i = 0; i < result.length; i++) {
			System.out.printf("#%d %d\n", i + 1, result[i]);
		}

	}
}
