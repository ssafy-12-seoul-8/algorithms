import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] weigh = new int[n];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				weigh[i] = Integer.parseInt(st.nextToken());
				sum += weigh[i];
			}

			int weighA = 0;
			int weighB = 0;
			boolean[] used = new boolean[n];

			int cnt = backtracking(weigh, used, weighA, weighB, 0, n);

			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}

		System.out.println(sb);
	}

	// 어떤 무게추를 어디에 올릴지 결정
	static int backtracking(int[] weigh, boolean[] used, int weighA, int weighB, int k, int n) {
		if (k == n) {
			return 1;
		}

		int cnt = 0;
		// i번 무게추 사용가능한지 확인하고 올리기
		for (int i = 0; i < n; i++) {
			if (!used[i]) {
				weighB += weigh[i];
				used[i] = true;
				cnt += backtracking(weigh, used, weighA, weighB, k + 1, n);
				weighB -= weigh[i];

				weighA += weigh[i];
				if (weighA <= weighB) {
					cnt += backtracking(weigh, used, weighA, weighB, k + 1, n);
				}
				weighA -= weigh[i];
				used[i] = false;
			}
		}
		
		return cnt;
	}

}
