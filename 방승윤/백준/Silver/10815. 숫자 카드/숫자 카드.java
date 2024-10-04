import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		one: for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int L = 0;
			int R = N - 1;
			
			while (L <= R) {
				int mid = (L + R) / 2;
				
				if (arr[mid] < num) {
					L = mid + 1;
				} else if (arr[mid] > num) {
					R = mid - 1;
				} else {
					sb.append("1 ");
					continue one;
				}
			}
			
			sb.append("0 ");
			
		}
		
		System.out.println(sb);
		
	}

}