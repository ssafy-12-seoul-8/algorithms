import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int SIZE = 5;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[SIZE][SIZE];
		int[] indices = new int[SIZE * SIZE + 1];
		int indexNumber = 0;

		for (int i = 0; i < SIZE; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < SIZE; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				indices[map[i][j]] = indexNumber++;
			}
		}

		int winsAt = 0;

		outer: for (int i = 0; i < SIZE; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < SIZE; j++) {
				int call = Integer.parseInt(st.nextToken());

				if (wins(map, indices, call)) {
					winsAt = i * 5 + j + 1;

					break outer;
				}
			}
		}

		System.out.println(winsAt);
	}

	static boolean wins(int[][] map, int[] indices, int call) {
		int index = indices[call];
		int row = index / SIZE;
		int col = index % SIZE;
		map[row][col] = 0;
		int bingoCount = 0;
		int rowCount = 0;
		int colCount = 0;
		int digCount = 0;
		int revDigCount = 0;

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (map[i][j] == 0) {
					rowCount++;

					if (SIZE - 1 - i == j) {
						revDigCount++;
					}

					if (i == j) {
						digCount++;
					}
				}

				if (map[j][i] == 0) {
					colCount++;
				}
			}
			
			if (rowCount == 5) {
				bingoCount++;
			}

			if (colCount == 5) {
				bingoCount++;
			}
			
			rowCount = 0;
			colCount = 0;
		}

		if (digCount == 5) {
			bingoCount++;
		}

		if (revDigCount == 5) {
			bingoCount++;
		}

		return bingoCount >= 3;
	}

}
