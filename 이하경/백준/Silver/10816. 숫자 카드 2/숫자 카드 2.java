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
		nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());
			int lower = lowerIdx(0, n, target);
			int upper = upperIdx(0, n, target);
			
			sb.append(upper - lower).append(" ");
		}

		System.out.println(sb);
	}

	// target이 들어갈 수 있는 가장 왼쪽 위치 구하기 = 나보다 크거나 같은 첫번째 값의 index 구하기
	static int lowerIdx(int start, int end, int target) {
		while (start < end) {
			int mid = (start + end) / 2;
			if (nums[mid] >= target) { // 타겟보다 크거나 같을 경우 이쪽이 오른쪽 끝이 될 수 있다
				end = mid;
				continue;
			}
			// 작을 경우 무조건 여기보다 큰쪽에 왼쪽끝이 있다
			start = mid + 1;
		}
		return start;
	}

	// target이 들어갈 수 있는 가장 오른쪽 위치 구하기 - 나보다 큰 첫번째 값의 index 구하기
	static int upperIdx(int start, int end, int target) {
		while (start < end) {
			int mid = (start + end) / 2;
			if (nums[mid] > target) { // 타겟보다 클 경우, 오른쪽 끝이 될 수 있다
				end = mid;
				continue;
			}
			// 작거나 같을 경우 큰쪽에 왼쪽끝이 있다
			start = mid + 1;
		}
		return start;
	}
}
