import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		boolean[] rowCut = new boolean[r];
		boolean[] colCut = new boolean[c];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			
			if (dir == 0) { // 가로로 자르는 = 세로를 자르는
				colCut[idx] = true;
			} else {
				rowCut[idx] = true;
			}
		}
		
		int rowMax = 0;
		int cut = 0;
		for (int i = 1; i < r; i++) { // 0번과 r번은 자르는 의미가 없다
			if (rowCut[i]) {
				rowMax = Math.max(rowMax, i - cut);
				cut = i;
			}
		}
		rowMax = Math.max(rowMax, r - cut); // 마지막으로 자른 위치가 cut이므로 마지막 조각의 크기

		int colMax = 0;
		cut = 0;
		for (int i = 0; i < c; i++) {
			if (colCut[i]) {
				colMax = Math.max(colMax, i - cut);
				cut = i;
			}
		}
		colMax = Math.max(colMax, c - cut);
		
		System.out.println(rowMax * colMax);

	}

}
