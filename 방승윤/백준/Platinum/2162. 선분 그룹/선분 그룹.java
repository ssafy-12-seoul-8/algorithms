import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] lines;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int group = N;
		lines = new int[N][5];
		int[] cnt = new int[N];
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			lines[i][0] = i;
			
			for (int j = 1; j < 5; j++) {
				lines[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (find(i) == find(j)) {
					continue;
				} else if (isCross(i, j)) {
					lines[find(j)][0] = find(i);
					group--;
				}
			}
		}
		
		int maxG = 0;
		
		for (int i = 0; i < N; i++) {
			maxG = Math.max(++cnt[find(i)], maxG);
		}
		
		sb.append(group).append("\n").append(maxG);
		
		System.out.print(sb);
		
	}

	static boolean isCross(int x, int y) {

		int[] a = {lines[x][1], lines[x][2]};
		int[] b = {lines[x][3], lines[x][4]};
		int[] c = {lines[y][1], lines[y][2]};
		int[] d = {lines[y][3], lines[y][4]};
		
		long[] ab = {b[0] - a[0], b[1] - a[1]};
		long[] ac = {c[0] - a[0], c[1] - a[1]};
		long[] ad = {d[0] - a[0], d[1] - a[1]};
		
		long[] cd = {d[0] - c[0], d[1] - c[1]};
		long[] ca = {a[0] - c[0], a[1] - c[1]};
		long[] cb = {b[0] - c[0], b[1] - c[1]};
		
		if ((ab[0] * ac[1] - ab[1] * ac[0]) * (ab[0] * ad[1] - ab[1] * ad[0]) <= 0 && (cd[0] * ca[1] - cd[1] * ca[0]) * (cd[0] * cb[1] - cd[1] * cb[0]) <= 0) {
			if ((ab[0] * ac[1] - ab[1] * ac[0]) * (ab[0] * ad[1] - ab[1] * ad[0]) == 0 || (cd[0] * ca[1] - cd[1] * ca[0]) * (cd[0] * cb[1] - cd[1] * cb[0]) == 0) {
				return Math.min(a[0], b[0]) <= Math.max(c[0], d[0]) && Math.max(a[0], b[0]) >= Math.min(c[0], d[0]) && Math.min(a[1],  b[1]) <= Math.max(c[1], d[1]) && Math.max(a[1],  b[1]) >= Math.min(c[1], d[1]);
			}
			
			return true;
		}
		
		return false;
		
	}
	
	static int find(int x) {
		
		if (lines[x][0] == x) {
			return x;
		}
		
		return lines[x][0] = find(lines[x][0]);
		
	}
	
}