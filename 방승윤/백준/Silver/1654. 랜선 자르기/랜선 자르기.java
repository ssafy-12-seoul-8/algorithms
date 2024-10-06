import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] cables = new int[K];
		int maxL = 0;
		
		for (int i = 0; i < K; i++) {
			cables[i] = Integer.parseInt(br.readLine());
			maxL = Math.max(maxL, cables[i]);
		}

		long L = 1;
		long R = maxL;
		long maxC = 0;
		
		while (L <= R) {
			long mid = (L + R) / 2;
			if (mid == 0) {
				mid++;
			}
			int cnt = 0;
			
			for (int i = 0; i < K; i++) {
				cnt += cables[i] / mid;
			}
			
			if (cnt < N) {
				R = mid - 1;
			} else if (cnt >= N) {
				maxC = mid;
				L = mid + 1;
			}
		}
		
		System.out.print(maxC);
			
	}
		
}