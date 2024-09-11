import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] setU = new int[n];
		for (int i = 0; i < n; i++) {
			setU[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(setU);

		// x, y의 합 저장
		int[] twoSum = new int[n * (n + 1) / 2];
		int idx = -1;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				twoSum[++idx] = setU[i] + setU[j];
			}
		}
		Arrays.sort(twoSum);

		// k-z 찾기
		for (int k = n - 1; k >= 0; k--) {
			for (int z = 0; z < n; z++) {
				int target = setU[k] - setU[z];
				if (target <= 0) {
					break;
				}
				int res = Arrays.binarySearch(twoSum, target);
				if (res >= 0) {
					System.out.println(setU[k]);
					return;
				}
			}
		}
	}

}
