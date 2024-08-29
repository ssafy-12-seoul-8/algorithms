import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static boolean[][] isSom;
	static boolean[] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		isSom = new boolean[5][5];
		visited = new boolean[1 << 25];

		for (int i = 0; i < 5; i++) {
			String input = br.readLine();
			for (int j = 0; j < 5; j++) {
				isSom[i][j] = input.charAt(j) == 'S' ? true : false;
			}
		}
		
		cnt = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (isSom[i][j]) {
					find(1, 0, idxToBit(i, j));
				} else {
					find(0, 1, idxToBit(i, j));
				}
			}
		}

		System.out.println(cnt);

	}

	static void find(int sCnt, int yCnt, int visitBit) {
		if (yCnt >= 4) {
			return;
		}

		if (sCnt + yCnt == 7) {
			cnt++;
			return;
		}

		// 현재 표시된 비트 찾기
		for (int i = 0; i < 25; i++) {
			if ((visitBit & (1 << i)) != 0) {
				int x = bitToXidx(i);
				int y = bitToYidx(i);

				for (int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					// 현재 포함되지도 않고, 넣은 결과도 방문한 적 없을때
					if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && (visitBit & idxToBit(nx, ny)) == 0
							&& !visited[visitBit | idxToBit(nx, ny)]) {
						visited[visitBit | idxToBit(nx, ny)] = true;
						if (isSom[nx][ny]) {
							find(sCnt + 1, yCnt, visitBit | idxToBit(nx, ny));
						} else {
							find(sCnt, yCnt + 1, visitBit | idxToBit(nx, ny));
						}
					}

				}
			}
		}
	}

	static int idxToBit(int x, int y) {
		return 1 << ((x * 5) + y);
	}

	static int bitToXidx(int bit) {
		return bit / 5;
	}

	static int bitToYidx(int bit) {
		return bit % 5;
	}
}