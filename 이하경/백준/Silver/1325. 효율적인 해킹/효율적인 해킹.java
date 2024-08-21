import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> trust;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		trust = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			trust.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); // u가 v를 신뢰 v를 해킹하면 u도 해킹 가능
			int v = Integer.parseInt(st.nextToken());
			trust.get(v).add(u); // v를 통해 u를 해킹 가능
		}

		int[] hackCnt = new int[n + 1];

		int max = 1;
		for (int i = 1; i <= n; i++) {
			hackCnt[i] = hack(i);
			max = Math.max(max, hackCnt[i]);
		}

		for (int i = 1; i <= n; i++) {
			if (hackCnt[i] == max) {
				sb.append(i).append(" ");
			}
		}
		
		System.out.println(sb);
		
	}

	static int hack(int k) {
		int[] q = new int[n];
		int start = 0;
		int end = 0;
		q[end++] = k;
		boolean[] visit = new boolean[n + 1];
		visit[k] = true;
		int cnt = 1;

		while (start < end) {
			int cur = q[start++];

			for (int next : trust.get(cur)) {
				if (!visit[next]) {
					visit[next] = true;
					cnt++;
					q[end++] = next;
				}
			}
		}

		return cnt;
	}
}
