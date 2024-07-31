import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		int T = Integer.parseInt(br.readLine());
		int[][][] result = new int[T][][];
		int[] dirR = {1, 0, -1, 0};
		int[] dirC = {0, -1, 0, 1};
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] array = new int[N][N];
			int value = 1;
			int dir = 0;
			int r = 0;
			int c = 0;

			array[c][r] = value++;
			
			while(true) {
				int newC = c + dirC[dir];
				int newR = r + dirR[dir];
				
				if(value == array.length * array[0].length + 1) {
					break;
				}
				
				if(newC >= 0 && newC < array.length && newR >= 0 && newR <array[0].length && array[newC][newR] == 0) {
					array[newC][newR] = value++;
					c = newC;
					r = newR;
				}
				else {
					dir = (dir + 1) % 4;
				}
				
			}
			result[i] = array;
		}
		
		for(int i = 0; i < result.length; i++) {
			System.out.printf("#%d\n", i + 1);
			for(int j = 0; j < result[i].length; j++) {
				for(int k = 0; k < result[i].length; k++) {
					System.out.print(result[i][j][k]);
					System.out.print(" ");
				}
				System.out.println();
			}
		}

	}
}
