import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] nums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] copyArr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			copyArr[i] = arr[i];
		}

		Arrays.sort(arr);

		int idx = 0; // idx번까지 값이 들어있다
		int prev = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] != prev) {
				arr[++idx] = arr[i];
				prev = arr[i];
			}
		}
		
		for (int i = 0; i < n; i++) {
			sb.append(binarySearch(arr, 0, idx, copyArr[i])).append(" ");
		}

		System.out.println(sb);
	}

	static int binarySearch(int[] arr, int start, int end, int target) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == target) {
				return mid;
			}
			if (arr[mid] > target) {
				end = mid - 1;
				continue;
			}
			start = mid + 1;
		}
		return -1;
	}
}
