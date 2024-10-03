import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		one: for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int L = 0;
			int R = N - 1;
			
			while (L <= R) {
				int mid = (L + R) / 2;
				
				if (num == A[mid]) {
					sb.append("1\n");
					continue one;
				} else if (num < A[mid]) {
					R = mid - 1;
				} else {
					L = mid + 1;
				}
			}
			
			sb.append("0\n");
		}

		System.out.println(sb);

	}

}