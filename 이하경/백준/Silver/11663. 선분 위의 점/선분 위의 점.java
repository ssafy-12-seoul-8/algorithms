import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] point = new int[n];
		for (int i = 0; i < n; i++) {
			point[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(point);
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			sb.append(upperBound(point, end) - lowerBound(point, start)).append("\n");
		}

		System.out.println(sb);
	}

	// target보다 크거나같은 값이 처음 나오는 위치
	static int lowerBound(int[] arr, int target) {
		int start = 0;
		int end = arr.length;

		while (start < end) {
			int mid = (start + end) / 2;

			if (arr[mid] == target) {
				return mid;
			}

			if (arr[mid] < target) {
				start = mid + 1;
				continue;
			}

			end = mid;
		}

		return end;
	}

	// target보다 큰 값이 처음 나오는 위치
	static int upperBound(int[] arr, int target) {
		int start = 0;
		int end = arr.length;

		while (start < end) {
			int mid = (start + end) / 2;

			if (arr[mid] > target) {
				end = mid;
				continue;
			}

			start = mid + 1;
		}

		return end;
	}
}
