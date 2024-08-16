import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int len;
	static int[] abcd;
	static char[] original;
	static boolean possible;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			len = 1;
			abcd = new int[4];
			for (int i = 0; i < 4; i++) {
				abcd[i] = Integer.parseInt(st.nextToken());
				len += abcd[i];
			}
			original = new char[len];
			possible = true;

			if (Math.abs(abcd[1] - abcd[2]) > 1 || (abcd[1] == 0 && abcd[2] == 0 && abcd[0] != 0 && abcd[3] != 0)) {
				possible = false;
			} else if (abcd[1] > abcd[2] || (abcd[1] == abcd[2] && abcd[0] > 0)) {
				original[0] = '0'; // 0으로 시작하는것의 개수가 더 많으므로 0으로 시작하는게 와야한다
			} else {
				original[0] = '1';
			}

			int next = 0;
			while (++next < len) {
				if (original[next - 1] == '0') {
					if (abcd[0] > 0) {
						original[next] = '0';
						abcd[0]--;
					} else {
						original[next] = '1';
						abcd[1]--;
					}
				} else {
					if (abcd[3] > 0) {
						original[next] = '1';
						abcd[3]--;
					} else {
						original[next] = '0';
						abcd[2]--;
					}
				}
			}

			sb.append("#").append(t).append(" ");

			if (possible) {
				sb.append(original);
			} else {
				sb.append("impossible");
			}

			sb.append("\n");
		}

		System.out.println(sb);

	}
}
