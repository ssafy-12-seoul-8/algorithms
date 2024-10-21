import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] trees = new int[N];
		int maxH = 0;
		int minH = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			maxH = Math.max(maxH, trees[i]);
		}
		
		int L = 0;
		int R = maxH;
		
		while (L <= R) {
			int mid = (L + R) / 2;
			long total = 0;
			
			for (int i = 0; i < N; i++) {
				if (trees[i] > mid) {
					total += trees[i] - mid;
				}
			}
			
			if (total == M) {
				minH = mid;
				break;
			} else if (total > M) {
				minH = mid;
				L = mid + 1;
			} else if (total < M) {
				R = mid - 1;
			}
		}
		
		System.out.println(minH);
		
	}

}