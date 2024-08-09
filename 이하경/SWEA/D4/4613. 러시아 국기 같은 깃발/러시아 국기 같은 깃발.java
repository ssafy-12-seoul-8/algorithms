import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	public static int n, m, min, sum;
	public static int[][] flag, memoColorIn;
	public static Map<Character, Integer> map = new HashMap<>();
	
	static {
		map.put('W', 0);
		map.put('B', 1);
		map.put('R', 2);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			flag = new int[n][m];
			
			// W는 0, B는 1, R은 2
			for (int i = 0; i < n; i++) {
				String input = br.readLine();
				for (int j = 0; j < m; j++) {
					flag[i][j] = map.get(input.charAt(j));
				}
			}

			memoColorIn = new int[n][3];
			for (int[] memo : memoColorIn) {
				Arrays.fill(memo, -1);
			}
	
			min = 50 * 50; // 전체 채색하는경우가 최대
			sum = colorIn(0, 0) + colorIn(n - 1, 2);
			backtracking(1, 0);
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}		
		System.out.println(sb);

	}

	// row번째 줄을 color색으로 칠할 때 몇개를 바꿔야하는지
	public static int colorIn(int row, int color) {
		if (memoColorIn[row][color] != -1) {
			return memoColorIn[row][color];
		}
		int cnt = 0;
		for (int c : flag[row]) {
			if (c != color) {
				cnt++;
			}
		}
		memoColorIn[row][color] = cnt;
		return cnt;
	}
	
	// 현재 탐색할 줄과 이전에 칠한 색을 받는다
	// 현재 줄은 이전이 W -> W, B / 이전이 B -> B, R / 이전이 R -> R 로 칠할수있다
	public static void backtracking(int row, int prevColor) {
		if (row == n - 1) { // 마지막 줄에 오면 끝
			min = Math.min(min, sum);
			return;
		}
		if (row == n - 2 && prevColor == 0) { // 아래에서 두번째인데 B가 안나온경우 B로 칠한다
			int cnt = colorIn(n - 2, 1);
			sum += cnt;
			backtracking(n - 1, 1);
			sum -= cnt;
		} else {
			int cnt = colorIn(row, prevColor);
			sum += cnt;
			backtracking(row + 1, prevColor);
			sum -= cnt;
			
			if (prevColor < 2) {
				cnt = colorIn(row, prevColor + 1);
				sum += cnt;
				backtracking(row + 1, prevColor + 1);
				sum -= cnt;
				
			}
			
		}
	}
}
