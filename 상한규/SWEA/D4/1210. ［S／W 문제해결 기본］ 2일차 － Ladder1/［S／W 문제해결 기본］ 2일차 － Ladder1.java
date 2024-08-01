import java.io.*;
import java.util.*;

public class Solution {
	static int SIZE = 100;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		String line = br.readLine();
		
		while(line != null) {
			int T = Integer.parseInt(line);
			int result = 0;
			int[][] board = new int[SIZE][SIZE];
			int[] dirR = {-1, 1};

			for(int i = 0; i < SIZE; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < SIZE; j++) {
					int value = Integer.parseInt(st.nextToken());
					board[i][j] = value;
				}
			}
			
			for(int i = 0; i < SIZE; i++) {
				if(board[0][i] == 1) {
					int currentC = 0;
					int currentR = i;
					while(currentC < SIZE - 1) {
						loop : for(int dirIndex = 0; dirIndex < dirR.length; dirIndex++) {
							int nextR = currentR + dirR[dirIndex];
							
							if(nextR >= 0 && nextR < SIZE && board[currentC][nextR] == 1) {
								while(nextR >= 0 && nextR < SIZE && board[currentC][nextR] == 1) {
									nextR += dirR[dirIndex];
								}
								currentR = nextR - dirR[dirIndex];
								break loop;
							}
						}
						currentC++;
					}
					if(board[currentC][currentR] == 2) {
						result = i;
						break;
					}
				}
			}
			
			System.out.printf("#%d %d\n", T, result);
			line = br.readLine();
		}
	}
}
