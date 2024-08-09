import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int n, m, min, sum;
	public static char[][] flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			flag = new char[n][m];
			
			for (int i = 0; i < n; i++) {
				String input = br.readLine();
				for (int j = 0; j < m; j++) {
					flag[i][j] = input.charAt(j);;
				}
			}
	
			min = 50 * 50; // 전체 채색하는경우가 최대
			sum = colorIn(0, 'W') + colorIn(n - 1, 'R');
			backtracking(1, 'W');
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}		
		System.out.println(sb);

	}

	// row번째 줄을 color색으로 칠할 때 몇개를 바꿔야하는지
	public static int colorIn(int row, char color) {
		int cnt = 0;
		for (char c : flag[row]) {
			if (c != color) {
				cnt++;
			}
		}
		return cnt;
	}
	
	// 현재 탐색할 줄과 이전에 칠한 색을 받는다
	// 현재 줄은 이전이 W -> W, B / 이전이 B -> B, R / 이전이 R -> R 로 칠할수있다
	public static void backtracking(int row, char prevColor) {
		if (row == n - 1) { // 마지막 줄에 오면 끝
			min = Math.min(min, sum);
			return;
		}
		if (row == n - 2 && prevColor == 'W') { // 아래에서 두번째인데 B가 안나온경우 B로 칠한다
			int cnt = colorIn(n - 2, 'B');
			sum += cnt;
			backtracking(n - 1, 'B');
			sum -= cnt;
		} else if (prevColor == 'W') {
			int cnt = colorIn(row, 'W');
			sum += cnt;
			backtracking(row + 1, 'W');
			sum -= cnt;
			
			cnt = colorIn(row, 'B');
			sum += cnt;
			backtracking(row + 1, 'B');
			sum -= cnt;
		} else if (prevColor == 'B') {
			int cnt = colorIn(row, 'B');
			sum += cnt;
			backtracking(row + 1, 'B');
			sum -= cnt;
			
			cnt = colorIn(row, 'R');
			sum += cnt;
			backtracking(row + 1, 'R');
			sum -= cnt;
		} else {
			int cnt = colorIn(row, 'R');
			sum += cnt;
			backtracking(row + 1, 'R');
			sum -= cnt;
		}
	}
}