import java.util.*;
import java.io.*;

public class Solution {
	static int size = 16;
	static int startR, startC, endR, endC;
	static int[] dirR = {-1, 1, 0, 0};
	static int[] dirC = {0, 0, -1, 1};
	static Queue<int[]> queue;
	static int[][] board;
	static boolean[][] visited;
	static boolean result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
	
		int T = 10;
		
		for(int tc = 0; tc < T; tc++) {
			board = new int[size][size];
			br.readLine();
			queue = new LinkedList<>();
			result = false;
			visited = new boolean[size][size];
			
			for(int i = 0; i < size; i++) {
				String[] arr = br.readLine().split("");
				
				for(int j = 0; j < size; j++) {
					board[i][j] = Integer.parseInt(arr[j]);
					if(board[i][j] == 2) {
						startR = i;
						startC = i;
					} else if(board[i][j] == 3) {
						endR = i;
						endC = j;
					}
				}
			}

			bfs();

			System.out.println("#" + (tc + 1) + " " + (result ? 1 : 0));
		}
	}
	
	static void bfs() {
		int[] start = {startR, startC};
		
		queue.offer(start);
		visited[start[0]][start[1]] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			
			for(int i = 0; i < dirR.length; i++) {
				int nextR = current[0] + dirR[i];
				int nextC = current[1] + dirC[i];
				
				if(board[nextR][nextC] == 3) {
					endR = nextR;
					endC = nextC;
					result = true;
					
					return ;
				} else if(board[nextR][nextC] == 0 && visited[nextR][nextC] == false) {
					int[] next = {nextR, nextC};
					
					queue.offer(next);
					visited[nextR][nextC] = true;
				}
			}
		}
	}
}
