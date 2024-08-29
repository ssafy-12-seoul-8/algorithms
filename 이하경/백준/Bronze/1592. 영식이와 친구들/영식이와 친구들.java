import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] ballCnt = new int[n];
		
		int current = 0;
		int cnt = -1;
		while (true) {
			cnt++;
			ballCnt[current]++;
			if (ballCnt[current] == m) {
				break;
			}
			if (ballCnt[current] % 2 == 1) {
				current = (current + l) % n;
			} else {
				current = (current + n - l) % n;
			}
		}

		System.out.println(cnt);
	}
}
