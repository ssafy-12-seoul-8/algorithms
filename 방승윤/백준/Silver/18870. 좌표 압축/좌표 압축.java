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
		int[] sortedArr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sortedArr[i] = arr[i];
		}
		
		Arrays.sort(sortedArr);
		
		int idx = 0;
		int prev = sortedArr[0];
		
		for (int i = 1; i < N; i++) {
			if (sortedArr[i] != prev) {
				sortedArr[++idx] = sortedArr[i];
				prev = sortedArr[i];
			}
		}
		
		for (int i = 0; i < N; i++) {
			int L = 0;
			int R = idx;
			
			while (L <= R) {
				int mid = (L + R) / 2;
				
				if (arr[i] == sortedArr[mid]) {
					sb.append(mid).append(" ");
					break;
				} else if (arr[i] < sortedArr[mid]) {
					R = mid - 1;
				} else {
					L = mid + 1;
				}
			}
		}
		
		System.out.println(sb);

	}

}