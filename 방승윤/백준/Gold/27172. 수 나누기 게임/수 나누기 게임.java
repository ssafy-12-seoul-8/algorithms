import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] visited = new boolean[1_000_001];
		int[] score = new int[1_000_001];
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			visited[num] = true;
		}

		for (int i = 0; i < N; i++) {
			int num = arr[i];

			for (int j = num; j <= 1_000_000; j += num) {
				if (visited[j]) {
					score[num]++;
					score[j]--;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			sb.append(score[arr[i]]).append(" ");
		}

		System.out.println(sb);
	}
}
