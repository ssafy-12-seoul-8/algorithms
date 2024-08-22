import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final short RIGHT = 1;
	static final short LEFT = 2;
	static final short UP = 3;
	static final short DOWN = 4;
	static final int[] dr = { 0, 0, 0, -1, 1 };
	static final int[] dc = { 0, 1, -1, 0, 0 };

	static class Dice {
		int up;
		int bottom;
		int right;
		int left;
		int forward;
		int backward;

		void move(int direction) {
			int newUp = up;
			int newDown = bottom;
			int newRight = right;
			int newLeft = left;
			int newForward = forward;
			int newBackward = backward;

			switch (direction) {
			case RIGHT:
				newUp = left;
				newDown = right;
				newRight = up;
				newLeft = bottom;
				break;
			case LEFT:
				newUp = right;
				newDown = left;
				newRight = bottom;
				newLeft = up;
				break;
			case UP:
				newUp = backward;
				newDown = forward;
				newForward = up;
				newBackward = bottom;
				break;
			case DOWN:
				newUp = forward;
				newDown = backward;
				newForward = bottom;
				newBackward = up;
				break;
			default:
				break;
			}

			up = newUp;
			bottom = newDown;
			right = newRight;
			left = newLeft;
			forward = newForward;
			backward = newBackward;
		}
	}

	static int n, m, row, col, k;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		Dice dice = new Dice();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < k; i++) {
			int move = Integer.parseInt(st.nextToken());
			int newRow = row + dr[move];
			int newCol = col + dc[move];

			if (!isInMap(newRow, newCol)) {
				continue;
			}

			row = newRow;
			col = newCol;
			dice.move(move);

			if (map[row][col] == 0) {
				map[row][col] = dice.bottom;
			} else {
				dice.bottom = map[row][col];
				map[row][col] = 0;
			}

			sb.append(dice.up).append("\n");
		}

		System.out.println(sb);
	}

	static boolean isInMap(int row, int col) {
		return row >= 0 && row < map.length && col >= 0 && col < map[0].length;
	}

}
