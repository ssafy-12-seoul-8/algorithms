import java.io.*;
import java.util.*;

public class Main {
	
	static final int rowCol = 19;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[rowCol + 2][rowCol + 2];
		
		for (int i = 1; i <= rowCol; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= rowCol; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] first = getFirst(map);
		
		if (first == null) {
			System.out.println(0);
		} else {
			System.out.println(map[first[0]][first[1]] + "\n" + first[0] + " " + first[1]);
		}
	}
	
	static int[] getFirst(int[][] map) {
		for (int i = 1; i <= rowCol; i++) {
			for (int j = 1; j <= rowCol; j++) {
				if (map[j][i] != 0 && (searched(map, j, i, 1, 0)
						|| searched(map, j, i, 0, 1)
						|| searched(map, j, i, 1, 1)
						|| searched(map, j, i, -1, 1))) {
					return new int[] {j, i};
				}
			}
		}
		
		return null;
	}
	
	static boolean searched(int[][] map, int row, int col, int rowMove, int colMove) {
		int count = 0;
		
		for (int i = 0; i < 5; i++) {
			int newRow = row + rowMove * i;
			int newCol = col + colMove * i;
			
			if (newRow < 0 || newCol < 0 || newRow >= rowCol + 1 || newCol >= rowCol + 1) {
				break;
			}
			
			if (map[row][col] == map[newRow][newCol]) {
				count++;
			}
		}
		
		if (count != 5) {
			return false;
		}
		
		int prevRow = row - rowMove;
		int prevCol = col - colMove;
		int nextRow = row + 5 * rowMove;
		int nextCol = col + 5 * colMove;
		
		if (map[row][col] == map[prevRow][prevCol]) {
			count++;
		}
		
		if (nextRow >= 0 && map[nextRow][nextCol] == map[row][col]) {
			count++;
		}
		
		return count == 5;
	}
}