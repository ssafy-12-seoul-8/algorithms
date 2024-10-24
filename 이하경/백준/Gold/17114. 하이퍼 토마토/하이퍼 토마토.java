import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, O, P, Q, R, S, T, U, V, W, left;
	static int[][][][][][][][][][][] box;
	static int[] dm = { 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	static int[] dn = { 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	static int[] d0 = { 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	static int[] dp = { 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	static int[] dq = { 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	static int[] dr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	static int[] ds = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0 };
	static int[] dt = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0 };
	static int[] du = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0 };
	static int[] dv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0 };
	static int[] dw = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1 };

	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(bfs());
	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		O = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		left = M * N * O * P * Q * R * S * T * U * V * W;
		box = new int[M][N][O][P][Q][R][S][T][U][V][W];

		for (int w = 0; w < W; w++) {
			for (int v = 0; v < V; v++) {
				for (int u = 0; u < U; u++) {
					for (int t = 0; t < T; t++) {
						for (int s = 0; s < S; s++) {
							for (int r = 0; r < R; r++) {
								for (int q = 0; q < Q; q++) {
									for (int p = 0; p < P; p++) {
										for (int o = 0; o < O; o++) {
											for (int n = 0; n < N; n++) {
												st = new StringTokenizer(br.readLine());
												for (int m = 0; m < M; m++) {
													int tomato = Integer.parseInt(st.nextToken());
													box[m][n][o][p][q][r][s][t][u][v][w] = tomato;

													if (tomato == 1) {
														queue.add(new int[] { m, n, o, p, q, r, s, t, u, v, w });
														left--;
														continue;
													}

													if (tomato == -1) {
														left--;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}

			}
		}
	}

	// 익은 마지막 날짜 반환. 모두 익지 못하면 -1 반환
	static int bfs() {
		int day = 0;

		while (!queue.isEmpty()) {
			int size = queue.size(); // 현재 날짜의 토마토 개수
			day++; // 다음에 나오는 토마토가 익는 날짜

			while (size-- > 0) {
				int[] curr = queue.poll();

				for (int d = 0; d < 22; d++) {
					int nm = curr[0] + dm[d];
					int nn = curr[1] + dn[d];
					int no = curr[2] + d0[d];
					int np = curr[3] + dp[d];
					int nq = curr[4] + dq[d];
					int nr = curr[5] + dr[d];
					int ns = curr[6] + ds[d];
					int nt = curr[7] + dt[d];
					int nu = curr[8] + du[d];
					int nv = curr[9] + dv[d];
					int nw = curr[10] + dw[d];

					if (isValid(nm, nn, no, np, nq, nr, ns, nt, nu, nv, nw)) {
						box[nm][nn][no][np][nq][nr][ns][nt][nu][nv][nw] = day;
						queue.add(new int[] { nm, nn, no, np, nq, nr, ns, nt, nu, nv, nw });
						left--;
					}
				}
			}
		}

		if (left != 0) {
			return -1;
		}

		return day - 1;
	}

	static boolean isValid(int m, int n, int o, int p, int q, int r, int s, int t, int u, int v, int w) {
		return m >= 0 && m < M && n >= 0 && n < N && o >= 0 && o < O && p >= 0 && p < P && q >= 0 && q < Q && r >= 0
				&& r < R && s >= 0 && s < S && t >= 0 && t < T && u >= 0 && u < U && v >= 0 && v < V
				&& w >= 0 && w < W && box[m][n][o][p][q][r][s][t][u][v][w] == 0;
	}
}
