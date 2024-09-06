import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, startIdx, score;
	static int[] seq;
	static int[][] res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		res = new int[n][9];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				res[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		seq = new int[9];
		score = 0;
		pick(0, 1);

		System.out.println(score);
	}

	// 선수 9명의 순서를 정하는 함수
	static void pick(int sidx, int visitBit) {
		if (sidx == 9) {
			startIdx = 0;
			score = Math.max(score, getScore());
			return;
		}

		if (sidx == 3) {
			pick(sidx + 1, visitBit);
			return;
		}

		for (int i = 0; i < 9; i++) {
			if ((visitBit & 1 << i) == 0) {
				seq[sidx] = i;
				pick(sidx + 1, visitBit | 1 << i);
			}
		}
	}

	static int getScore() {
		int tmp = 0;
		for (int i = 0; i < n; i++) { // 이닝 수
			int out = 0;
			int baseBit = 0;
			while (out < 3) {
				baseBit |= 1; // 타석의 선수를 표시
				baseBit <<= res[i][seq[startIdx]];
				if (res[i][seq[startIdx]] == 0) {
					out++;
				}
				startIdx = (startIdx + 1) % 9;
				if (baseBit >= (1 << 4)) {
					tmp += Integer.bitCount(baseBit & ~((1 << 4) - 1));
				}
				baseBit &= ((1 << 4) - 1);
			}
		}
		return tmp;
	}
}
