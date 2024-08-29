import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] matrix;
	static int[] dx = { 0, 0, 1, 1 };
	static int[] dy = { 0, 1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(pooling(n, 0, 0));
	}

	static int pooling(int size, int startX, int startY) {
		if (size == 1) {
			return matrix[startX][startY];
		}

		int[] tmp = new int[4];
		int nextSize = size / 2;
		for (int i = 0; i < 4; i++) {
			tmp[i] = pooling(nextSize, startX + dx[i] * nextSize, startY + dy[i] * nextSize);
		}
		Arrays.sort(tmp);
		return tmp[2];
	}
	
}
