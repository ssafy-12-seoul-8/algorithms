import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
		List<Integer> lis = new ArrayList<>();
		int[] lisIdx = new int[n];

		for (int i = 0; i < n; i++) {
			int B = arr[i][1];
			int idx = -(Collections.binarySearch(lis, B) + 1);

			if (idx == lis.size()) {
				lis.add(B);
			} else {
				lis.set(idx, B);
			}

			lisIdx[i] = idx;
		}

		sb.append(n - lis.size());
		int idx = lis.size() - 1;
		boolean[] cut = new boolean[n];

		for (int i = n - 1; i >= 0; i--) {
			if (lisIdx[i] == idx) {
				idx--;
			} else {
				cut[i] = true;
			}
		}

		for (int i = 0; i < n; i++) {
			if (cut[i]) {
				sb.append("\n").append(arr[i][0]);
			}
		}

		System.out.println(sb);
	}
}