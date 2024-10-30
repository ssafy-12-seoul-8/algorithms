import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] scores;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		scores = new int[n];
		for (int i = 0; i < n; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(binarySearch());
	}

	// 나눌 수 있는 점수 중 최댓값
	public static int binarySearch() {
		int start = 0;
		int end = n * 20;
		
		while (start < end) {
			int mid = (start + end + 1) / 2;

			if (canSplit(mid)) {
				start = mid;
				continue;
			}
			
			end = mid - 1;
		}

		return start;
	}

	public static boolean canSplit(int mid) {
		int cnt = 0;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += scores[i];

			if (sum >= mid) {
				cnt++;
				sum = 0;
			}
		}

		return cnt >= k;
	}
}
