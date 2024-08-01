import java.io.*;
import java.util.*;

public class Solution {

	static final int rooms = 100;
	static final int cases = 10;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= cases; t++) {
			br.readLine();
			
			int[][] map = new int[rooms][rooms];
			int rowMax = 0;
			int colMax = 0;
			int digMax = 0;
			int digSum = 0;
			int revDigSum = 0;
			
			for (int i = 0; i < rooms; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int rowSum = 0;
				
				for (int j = 0; j < rooms; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					rowSum += map[i][j];
					
					if (i == j) {
						digSum += map[i][j];
					}
					
					if (i + j == rooms - 1) {
						revDigSum += map[i][j];
					}
				}
				
				rowMax = Math.max(rowMax, rowSum);
			}
			
			digMax = Math.max(digSum, revDigSum);
			
			for (int i = 0; i < rooms; i++) {
				int colSum = 0;
				
				for (int j = 0; j < rooms; j++) {
					colSum += map[j][i];
				}
				
				colMax = Math.max(colSum, colMax);
			}
			
			int max = Math.max(rowMax, colMax);
			max = Math.max(digMax, max);
			
			System.out.println("#" + t + " " + max);
		}
	}
	
}