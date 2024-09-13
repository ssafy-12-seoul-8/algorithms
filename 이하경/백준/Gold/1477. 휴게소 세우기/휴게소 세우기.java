import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, l;
	static int[] rest;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		rest = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			rest[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(rest);

		System.out.println(binarySearch(1, l - 1));
	}

	// canMake == true인 구간길이의 최솟값
	// log(L)
	static int binarySearch(int start, int end) {
		while (start < end) {
			int mid = (start + end) / 2;

			if (canMake(mid)) { // mid 이하에 답이 있다
				end = mid;
				continue;
			}
			start = mid + 1;
		}
		return start;
	}

	// 모든 휴게소의 거리가 mid 이하인지 확인
	// mid에 따라 다르지만 다 확인하면 최대 L
	static boolean canMake(int mid) {
		int prev = 0;
		int make = 0;

		int i = 0;
		while (i < rest.length) {
			if (rest[i] - prev > mid) { // 거리가 mid보다 크면
				prev += mid;
				make++;
				continue;
			}
			// mid보다 작거나 같으면
			prev = rest[i];
			i++;
		}
		while (l - prev > mid) {
			prev += mid;
			make++;
		}
		if (make > m) {
			return false;
		}
		return true;
	}
}
