
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] lis = new int[n + 1]; // 길이가 i인 부분수열 중 마지막 값의 최소
		int end = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int key = Integer.parseInt(st.nextToken());
			if (key > lis[end]) {
				lis[++end] = key;
				continue;
			}
			int idx = binarySearch(lis, 0, end, key);
			lis[idx] = key;
		}
		
		System.out.println(end);

	}

	// a가 들어갈 위치 = a보다 크거나 같은 숫자가 처음으로 나오는 위치
	static int binarySearch(int[] arr, int start, int end, int key) {
		while (start < end) {
			int mid = (start + end) / 2;
			if (key <= arr[mid]) { // 크거나 같은 숫자가 나오면 더 큰쪽은 볼필요x
				end = mid;
				continue;
			}
			start = mid + 1;
		}
		return end;
	}
}
