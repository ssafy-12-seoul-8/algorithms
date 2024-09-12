import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] snack = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			snack[i] = Integer.parseInt(st.nextToken());
		}

		// max찾으려고 비교연산 n번 하기 vs 그냥 10억으로 두기 -> 10억으로 해도 연산 30번정도?
		System.out.println(binarySearch(snack, 0, 1_000_000_000, m));
	}

	// canGive가 true가 되는 최댓값 구하기
	public static int binarySearch(int[] arr, int start, int end, int target) {
		while (start < end) {
			int mid = (start + end + 1) / 2; // 둘 다 10억 이하라 오버플로우x
			if (canGive(arr, mid, target)) { // mid 에서 줄 수 있으면 얘가 답이거나 더 큰값이 답이다
				start = mid; // start = mid 가 들어가면 무한루프 방지를 위해 mid값 설정할때 1 더해준다
				continue;
			}
			// mid에서 줄 수 없으면 답은 mid 미만이다
			end = mid - 1;
		}
		return start;
	}

	// 조카 target명에게 나눠줄 수 있는지 여부 반환
	public static boolean canGive(int[] arr, int len, int target) {
		int cnt = 0;
		for (int a : arr) {
			cnt += a / len;
		}
		return cnt >= target;
	}
}
