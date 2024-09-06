import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k, min;
	static int[][] spin;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		spin = new int[k][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				spin[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		min = 5000;
		perm(0, 0, arr);

		System.out.println(min);
	}

	static void perm(int idx, int visitBit, int[][] arr) {
		if (idx == k) {
			min = Math.min(min, calcMin(arr));
			return;
		}

		for (int i = 0; i < k; i++) {
			if ((visitBit & (1 << i)) == 0) {
				perm(idx + 1, visitBit | (1 << i), spinArr(spin[i][0] - 1, spin[i][1] - 1, spin[i][2], arr));
			}
		}
	}

	static int[][] spinArr(int r, int c, int s, int[][] arr) {
		int[][] newArr = deepCopy(arr);

		for (int i = 1; i <= s; i++) {
			for (int j = c - i; j < c + i; j++) {
				newArr[r - i][j + 1] = arr[r - i][j];
			}
			for (int j = r - i; j < r + i; j++) {
				newArr[j + 1][c + i] = arr[j][c + i];
			}
			for (int j = c + i; j > c - i; j--) {
				newArr[r + i][j - 1] = arr[r + i][j];
			}
			for (int j = r + i; j > r - i; j--) {
				newArr[j - 1][c - i] = arr[j][c - i];
			}
		}

		return newArr;
	}

	static int calcMin(int[][] arr) {
		int tmp = 5000;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < m; j++) {
				sum += arr[i][j];
			}
			tmp = Math.min(tmp, sum);
		}
		return tmp;
	}

	static int[][] deepCopy(int[][] arr) {
		int[][] newArr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newArr[i][j] = arr[i][j];
			}
		}
		return newArr;
	}
}
