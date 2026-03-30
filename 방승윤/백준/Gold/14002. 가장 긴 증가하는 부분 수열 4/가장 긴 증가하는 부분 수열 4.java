import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Long[] A = new Long[N];
		int[] lisIdx = new int[N];
		List<Long> lis = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			Long num = A[i];
			int idx = Collections.binarySearch(lis, num);

			if (idx >= 0) {
				lisIdx[i] = idx;
				continue;
			}

			idx = -idx - 1;
			lisIdx[i] = idx;

			if (idx == lis.size()) {
				lis.add(num);
			} else {
				lis.set(idx, num);
			}
		}

		sb.append(lis.size()).append("\n");
		int idx = lis.size() - 1;

		for (int i = N - 1; i >= 0; i--) {
			if (lisIdx[i] == idx) {
				lisIdx[i] = -1;
				idx--;
			}
		}

		for (int i = 0; i < N; i++) {
			if (lisIdx[i] == -1) {
				sb.append(A[i]).append(" ");
			}
		}

		System.out.println(sb);
	}
}