// 병합정렬과 비슷한 아이디어를 쓰고싶다
// 근데 1500개는 직접 비교가 안되는데 범위 넘은경우??
// 맨 앞에 매우 작은값을 넣어서 절대 선택되지 않게 하자

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] table = new int[n + 1][n];
		int[] pointer = new int[n]; // i번에 든 값은 i번 열의 포인터
		
		Arrays.fill(table[0], -1_000_000_000);
		Arrays.fill(pointer, n);
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		while (cnt < n) {
			int max = -1_000_000_000;
			int maxIdx = -1;
			
			for (int i = 0; i < n; i++) {
				if (table[pointer[i]][i] > max) {
					max = table[pointer[i]][i];
					maxIdx = i;
				}
			}
			
			pointer[maxIdx]--;
			cnt++;
			
			if (cnt == n) {
				System.out.println(max);
				break;
			}
		}
	}
}
