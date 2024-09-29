import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		int[] cnt = new int[K + 1];
		
		cnt[0] = 1;

		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = coin[i]; j <= K; j++) {
				cnt[j] +=  cnt[j - coin[i]];
			}
		}
		
		System.out.println(cnt[K]);

	}

}