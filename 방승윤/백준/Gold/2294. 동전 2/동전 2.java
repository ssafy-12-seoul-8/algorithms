import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] coin = new boolean[10001];
		int[] cnt = new int[K + 1];
		
		Arrays.fill(cnt, Integer.MAX_VALUE);
		cnt[0] = 0;
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num <= K) {
				coin[num] = true;
			}
		}
		
		for (int i = 1; i <= K; i++) {
			if (coin[i]) {
				for (int j = i; j <= K; j++) {
					if (cnt[j - i] != Integer.MAX_VALUE) {
						cnt[j] = Math.min(cnt[j - i] + 1, cnt[j]);
					}
				}
			}
		}
		
		if (cnt[K] == Integer.MAX_VALUE) {
			cnt[K] = -1;
		}
		
		System.out.println(cnt[K]);

	}

}