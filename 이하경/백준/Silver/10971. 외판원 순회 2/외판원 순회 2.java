import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, minCost;
	static int[][] cost;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		cost = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		minCost = 10_000_000;
		for (int i = 0; i < n; i++) { // 시작점
			bt(1, 1 << i, 0, i, i);
		}

		System.out.println(minCost);
	}

	static void bt(int visitCnt, int visitBit, int costSum, int prev, int start) {
		if (visitCnt == n) {
			if (cost[prev][start] != 0) {
				minCost = Math.min(minCost, costSum + cost[prev][start]);
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			if ((visitBit & 1 << i) == 0 && cost[prev][i] != 0) {
				bt(visitCnt + 1, visitBit | 1 << i, costSum + cost[prev][i], i, start);
			}
		}
	}
}
