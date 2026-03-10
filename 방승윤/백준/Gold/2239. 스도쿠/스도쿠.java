import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int[][] field = new int[9][9];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			String line = br.readLine();

			for (int j = 0; j < 9; j++) {
				field[i][j] = line.charAt(j) - '0';
			}
		}

		sudoku(0);
	}

	static void sudoku(int depth) {
		if (depth == 81) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(field[i][j]);
				}

				sb.append("\n");
			}

			System.out.println(sb);
			System.exit(0);
		}

		int x = depth / 9;
		int y = depth % 9;

		if (field[x][y] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (verify(x, y, i)) {
					field[x][y] = i;
					sudoku(depth + 1);
					field[x][y] = 0;
				}
			}

			return;
		}

		sudoku(depth + 1);
	}

	static boolean verify(int x, int y, int num) {
		for (int i = 0; i < 9; i++) {
			if (field[i][y] == num || field[x][i] == num || field[(x / 3) * 3 + i / 3][(y / 3) * 3 + i % 3] == num) {
				return false;
			}
		}

		return true;
	}
}