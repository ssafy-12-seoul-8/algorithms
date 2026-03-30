import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Long[] A = new Long[N];
		List<Long> lis = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			Long num = A[i];
			int idx = Collections.binarySearch(lis, num);

			if (idx >= 0) {
				continue;
			}

			idx = -idx - 1;

			if (idx == lis.size()) {
				lis.add(num);
			} else {
				lis.set(idx, num);
			}
		}

		System.out.println(lis.size());
	}
}