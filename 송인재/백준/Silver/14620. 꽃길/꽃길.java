import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	
	static int cost = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] price = new int[n][n];
		boolean[][] possessed = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				price[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(price, possessed, n - 2, 0, 3, 0);
		
		System.out.println(cost == Integer.MAX_VALUE ? 0 : cost);
	}
	
	static void combination(int[][] price, boolean[][] possessed, int n, int index, int left, int sum) {
		if (left == 0) {
			if (sum == 0) {
				return;
			}
			
			cost = Math.min(cost, sum);
			
			return;
		}

		for (int i = index; i < n * n; i++) {
			int row = i / n + 1;
			int col = i % n + 1;
			
			if (!isPossessable(possessed, row, col)) {
				continue;
			}
			
			possessed[row][col] = true;
			int currentCost = price[row][col];
			
			for (int j = 0; j < 4; j++) {
				int newRow = row + dr[j];
				int newCol = col + dc[j];
				
				currentCost += price[newRow][newCol];
				possessed[newRow][newCol] = true;
			}
			
			combination(price, possessed, n, i + 1, left - 1, sum + currentCost);
			
			for (int j = 0; j < 4; j++) {
				possessed[row + dr[j]][col + dc[j]] = false;
			}
			
			possessed[row][col] = false;
		}
	}
	
	static boolean isPossessable(boolean[][] possessed, int row, int col) {
		if (possessed[row][col]) {
			return false;
		}
		
		for (int i = 0; i < 4; i++) {
			int newRow = row + dr[i];
			int newCol = col + dc[i];
			
			if (possessed[newRow][newCol]) {
				return false;
			}
		}
		
		return true;
	}
	
}