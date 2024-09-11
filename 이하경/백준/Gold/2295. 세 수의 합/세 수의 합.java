import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] setU = new int[n];
		for (int i = 0; i < n; i++) {
			setU[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(setU);

		for (int k = n - 1; k > 0; k--) {
			for (int a = 0; a < k; a++) {
				for (int b = a; b < k; b++) {
					int c = setU[k] - setU[a] - setU[b];
					if (c < 0) {
						break;
					}
					int bs = binarySearch(setU, b, k, c);
					if (bs >= 0) {
						System.out.println(setU[k]);
						return;
					}
				}
			}
		}
		
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
