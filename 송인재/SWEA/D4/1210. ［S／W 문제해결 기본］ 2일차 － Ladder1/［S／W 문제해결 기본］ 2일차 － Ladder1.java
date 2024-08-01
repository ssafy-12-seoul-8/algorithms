import java.io.*;
import java.util.*;

public class Solution {

	static final int rooms = 100;
	static final int cases = 10;
	
	static final int[] dr = {-1, 0, 0};
	static final int[] dc = {0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= cases; t++) {
			br.readLine();
			
			int[][] map = new int[rooms][rooms];
			int col = 0;
			
			for (int i = 0; i < rooms; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < rooms; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if (map[i][j] == 2) {
						col = j;
					}
				}
			}
			
			int row = rooms - 1;
			int d = 0;
			
			while (row > 0) {
				if (d == 0) {
					if (col > 0 && map[row][col - 1] == 1) {
						d = 1;
					} else if (col < rooms - 1 && map[row][col + 1] == 1) {
						d = 2;
					}
				} else {
					if (col <= 0 || col >= rooms - 1 || map[row + dr[d]][col + dc[d]] != 1) {
						d = 0;
					}
				}
				
				row += dr[d];
				col += dc[d];
			}
			
			System.out.println("#" + t + " " + col);
		}
	}
	
}