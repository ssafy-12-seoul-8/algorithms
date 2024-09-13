import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		input();
	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] map = new int[n];
		for (int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(map);

		System.out.println(binarySearch(map, 0, 1_000_000_000, c));
	}

	// canMake == true가 되는 최대 거리
	static int binarySearch(int[] map, int start, int end, int c) {
		while (start < end) {
			int mid = (start + end + 1) / 2;
			if (canMake(map, mid, c)) { // 지금 거리 되면 크거나 같은쪽만 보자
				start = mid;
				continue;
			}
			end = mid - 1;
		}
		return start;
	}

	// mid 거리 이상으로만 설치할 수 있는지
	static boolean canMake(int[] map, int mid, int c) {
		int prev = map[0];
		int make = 1;
		for (int m : map) {
			if (m - prev >= mid) { // 놓을 수 있는 경우에
				prev = m;
				make++;

				if (make == c) {
					return true;
				}
			}
		}

		return false;
	}
}
