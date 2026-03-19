import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] lis = new int[N];
		int len = 0;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			int L = 0;
			int R = len;

			while (L < R) {
				int mid = (L + R) / 2;

				if (lis[mid] < num) {
					L = mid + 1;
				} else {
					R = mid;
				}
			}

			len = Math.max(len, L + 1);
			lis[L] = num;
		}

		System.out.println(len);
	}
}
