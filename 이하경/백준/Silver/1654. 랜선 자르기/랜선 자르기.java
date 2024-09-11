import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int k, n;
	static int[] lans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		lans = new int[k];
		for (int i = 0; i < k; i++) {
			lans[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(parametricSearch());
	}

	// canMake가 true가 되는 최댓값 = 가장 오른쪽 값
	static long parametricSearch() {
		long start = 1;
		long end = Integer.MAX_VALUE;

		while (start < end) {
			long mid = (start + end + 1) / 2;
			if (canMake(mid)) { // mid보다 작은쪽은 볼 필요 없다. mid는 답보다 크거나같다
				start = mid;
				continue;
			}
			// mid가 너무 컸나봐..
			end = mid - 1;
		}
		return start;
	}

	static boolean canMake(long len) {
		int cnt = 0; // k~2k 사이에서 시작해서 점점 늘어나거나 줄어드니까 int형
		for (int i = 0; i < k; i++) {
			cnt += lans[i] / len;
		}
		return cnt >= n;
	}

}
