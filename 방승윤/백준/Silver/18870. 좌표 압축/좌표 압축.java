import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashSet<Integer> set = new HashSet<>();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			set.add(arr[i]);
		}
		
		Integer[] sortedArr = new Integer[set.size()];
		set.toArray(sortedArr);
		Arrays.sort(sortedArr);
		
		for (int i = 0; i < N; i++) {
			int L = 0;
			int R = sortedArr.length - 1;
			
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