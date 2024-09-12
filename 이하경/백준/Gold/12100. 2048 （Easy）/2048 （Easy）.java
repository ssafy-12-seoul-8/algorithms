import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, max;
	static int[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		board = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bt(0);
		System.out.println(max);
	}

	static void printBoard() {
		for (int[] b : board) {
			System.out.println(Arrays.toString(b));
		}
		System.out.println();
	}

	//
	public static void bt(int step) {
		if (step == 5) {
			max = Math.max(max, findMax());
			return;
		}

		int[][] originalArr = board;

		moveUp();
		bt(step + 1);
		board = originalArr;

		moveDown();
		bt(step + 1);
		board = originalArr;

		moveLeft();
		bt(step + 1);
		board = originalArr;

		moveRight();
		bt(step + 1);
		board = originalArr;
	}

	public static int findMax() {
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, board[i][j]);
			}
		}
		return max;
	}

	public static void moveUp() {
		int[][] newArr = new int[n][n];
		for (int j = 0; j < n; j++) {
			int idx = -1; // 숫자가 들어갈 자리
			int prev = 0;
			for (int i = 0; i < n; i++) {
				if (board[i][j] == 0) {
					continue;
				}
				if (prev == 0) {
					prev = board[i][j];
					continue;
				}
				if (prev == board[i][j]) {
					newArr[++idx][j] = 2 * prev;
					prev = 0;
					continue;
				}
				newArr[++idx][j] = prev;
				prev = board[i][j];
			}
			newArr[++idx][j] = prev;
		}
		board = newArr;
	}

	public static void moveDown() {
		int[][] newArr = new int[n][n];
		for (int j = 0; j < n; j++) {
			int idx = n;
			int prev = 0;
			for (int i = n - 1; i >= 0; i--) {
				if (board[i][j] == 0) {
					continue;
				}
				if (prev == 0) {
					prev = board[i][j];
					continue;
				}
				if (prev == board[i][j]) {
					newArr[--idx][j] = 2 * prev;
					prev = 0;
					continue;
				}
				newArr[--idx][j] = prev;
				prev = board[i][j];
			}
			newArr[--idx][j] = prev;
		}
		board = newArr;
	}

	public static void moveLeft() {
		int[][] newArr = new int[n][n];
		for (int i = 0; i < n; i++) {
			int idx = -1;
			int prev = 0;
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0) {
					continue;
				}
				if (prev == 0) {
					prev = board[i][j];
					continue;
				}
				if (prev == board[i][j]) {
					newArr[i][++idx] = 2 * prev;
					prev = 0;
					continue;
				}
				newArr[i][++idx] = prev;
				prev = board[i][j];
			}
			newArr[i][++idx] = prev;
		}
		board = newArr;
	}

	public static void moveRight() {
		int[][] newArr = new int[n][n];
		for (int i = 0; i < n; i++) {
			int idx = n;
			int prev = 0;
			for (int j = n - 1; j >= 0; j--) {
				if (board[i][j] == 0) {
					continue;
				}
				if (prev == 0) {
					prev = board[i][j];
					continue;
				}
				if (prev == board[i][j]) {
					newArr[i][--idx] = 2 * prev;
					prev = 0;
					continue;
				}
				newArr[i][--idx] = prev;
				prev = board[i][j];
			}
			newArr[i][--idx] = prev;
		}
		board = newArr;
	}

}
