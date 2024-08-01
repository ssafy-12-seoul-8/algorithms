import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			StringBuilder sb = new StringBuilder()
					.append("#")
					.append(t)
					.append(" ")
					.append(System.lineSeparator());
			int n = Integer.parseInt(br.readLine());
			int[][] snail = new int[n][n];
			
			int number = 1;
			int d = 0;
			int row = 0;
			int col = 0;
			
			while (number <= n * n) {
				snail[row][col] = number++;
				
				int newRow = row + dr[d];
				int newCol = col + dc[d];
				
				if (!isInMatrix(snail, newRow, newCol) || snail[newRow][newCol] > 0) {
					d = (d + 1) % 4;
					newRow = row + dr[d];
					newCol = col + dc[d];
				}
				
				row = newRow;
				col = newCol;
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(snail[i][j])
						.append(" ");
				}
				
				if (i != n - 1) {
					sb.append(System.lineSeparator());
				}
			}
			
			System.out.println(sb);
		}
	}
	
	static boolean isInMatrix(int[][] matrix, int row, int col) {
		return row >= 0 && col >= 0
				&& row < matrix.length
				&& col < matrix[0].length;
	}
	
}