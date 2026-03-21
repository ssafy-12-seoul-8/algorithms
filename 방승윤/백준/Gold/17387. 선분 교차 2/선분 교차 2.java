import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[][] L = new long[2][4];

		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 4; j++) {
				L[i][j] = Long.parseLong(st.nextToken());
			}
		}

		System.out.println(isCross(L[0][0], L[0][1], L[0][2], L[0][3], L[1][0], L[1][1], L[1][2], L[1][3]) ? 1 : 0);
	}

	static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		long s = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);

		if (s > 0) {
			return 1;
		} else if (s == 0) {
			return 0;
		} else {
			return -1;
		}
	}

	static boolean isCross(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
		int s1 = ccw(x1, y1, x2, y2, x3, y3);
		int s2 = ccw(x1, y1, x2, y2, x4, y4);
		int s3 = ccw(x3, y3, x4, y4, x1, y1);
		int s4 = ccw(x3, y3, x4, y4, x2, y2);

		if (s1 * s2 == 0 && s3 * s3 == 0) {
			return Math.max(x1, x2) >= Math.min(x3, x4) && Math.min(x1, x2) <= Math.max(x3, x4)
				&& Math.max(y1, y2) >= Math.min(y3, y4) && Math.min(y1, y2) <= Math.max(y3, y4);
		}

		return s1 * s2 <= 0 && s3 * s4 <= 0;
	}
}
