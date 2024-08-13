import java.io.*;
import java.util.*;

public class Solution {
	
	static int d, w, k, min;
	static int[][] cells;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			cells = new int[d][w];
			
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < w; j++) {
					cells[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			combination(0, 0);
			
			System.out.println("#" + t + " " + min);
		}
	}
	
	static void combination(int index, int count) {
		if (testCells()) {
			min = Math.min(min, count);
			
			return;
		}
		
		for (int i = index; i < d; i++) {
			int[] temp = cells[i];
			cells[i] = new int[w];
			
			combination(i + 1, count + 1);
			
			for (int j = 0; j < w; j++) {
				cells[i][j] = 1;
			}
			
			combination(i + 1, count + 1);
			
			cells[i] = temp;
		}
	}
	
	static boolean testCells() {
		for (int i = 0; i < w; i++) {
			if (!dfs(1, i, 1)) {
				return false;
			}
		}
		
		return true;
	}
	
	static boolean dfs(int row, int col, int count) {
		if (count == k) {
			return true;
		}
		
		if (row == d) {
			return false;
		}
		
		if (cells[row][col] == cells[row - 1][col]) {
			return dfs(row + 1, col, count + 1);
		} else {
			return dfs(row + 1, col, 1);
		}
	}
	
}
