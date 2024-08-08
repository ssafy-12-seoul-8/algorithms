import java.io.*;
import java.util.*;

class Solution {
	static final int SIZE = 9;
	
	
	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			boolean result = true;
			int[][] board = new int[SIZE][SIZE];
			
			for(int j = 0; j < SIZE; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k = 0; k < SIZE; k++) {
					board[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			for(int j = 0; j < SIZE; j++) {
				int[] countArray = new int[10];
				for(int k = 0; k < SIZE; k++) {
					if(countArray[board[j][k]] < 1) {
						countArray[board[j][k]]++;
					}
					else {
						result = false;
						break;
					}
				}
			}
			
			for(int j = 0; j < SIZE; j++) {
				int[] countArray = new int[10];
				for(int k = 0; k < SIZE; k++) {
					if(countArray[board[k][j]] < 1) {
						countArray[board[k][j]]++;
					}
					else {
						result = false;
						break;
					}
				}
			}
			
			int[][] sumArray = new int[3][3];
			
			for(int j = 0; j < SIZE; j++) {
				for(int k = 0; k < SIZE; k++) {
					sumArray[j/3][k/3] += board[j][k];
				}
			}
			
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					if(sumArray[j][k] != 45) {
						result = false;
						break;
					}
				}
			}
			
			System.out.printf("#%d %d\n", i + 1 , result ? 1 : 0);
		}
	}
}