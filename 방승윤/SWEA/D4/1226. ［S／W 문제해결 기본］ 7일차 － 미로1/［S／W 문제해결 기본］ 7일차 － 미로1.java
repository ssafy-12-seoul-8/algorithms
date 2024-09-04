import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	static int answer;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] maze = new int[16][16];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			
			br.readLine();
			
			int startR = 0;
			int startC = 0;
			
			for (int i = 0; i < 16; i++) {
				String[] str = br.readLine().split("");
				for (int j = 0; j < 16; j++) {
					maze[i][j] = Integer.parseInt(str[j]);
					if (maze[i][j] == 2) {
						startR = i;
						startC = j;
					} else if (maze[i][j] == 3) {
					}
				}
			}
			
			isPossible(startR, startC);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			answer = 0;
		}
		
		System.out.println(sb);
		
	}
	
	static void isPossible(int r, int c) {
		
		if (maze[r][c] == 3) {
			answer = 1;
			return;
		}
		
		maze[r][c] = 1;
		
		for (int i = 0; i < 4; i++) {
			if (r + dr[i] >= 0 && r + dr[i] < 16 && c + dc[i] >= 0 && c + dc[i] < 16 && (maze[r + dr[i]][c + dc[i]] == 0 || maze[r + dr[i]][c + dc[i]] == 3)) {
				isPossible(r + dr[i], c + dc[i]);
			}
		}
		
	}
	
}