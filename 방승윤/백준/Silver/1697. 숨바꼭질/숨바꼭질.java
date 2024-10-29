import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[K + 2];
		Queue<Integer> queue = new LinkedList<>();
		
		if (N >= K) {
			System.out.println(N - K);
		} else {
			int time = 0;
			queue.offer(N);
			visited[N] = true;

			while (true) {
				int repeat = queue.size();
				
				for (int i = 0; i < repeat; i++) {
					int num = queue.poll();
					if (num == K) {
						System.out.println(time);
						return;
					}
					
					if (num - 1 >= 0 && !visited[num - 1]) {
						visited[num - 1] = true;
						queue.offer(num - 1);
					}
					
					if (num + 1 <= K && !visited[num + 1]) {
						visited[num + 1] = true;
						queue.offer(num + 1);
					}
					
					if (num * 2 <= K + 1 && !visited[num * 2]) {
						visited[num * 2] = true;
						queue.offer(num * 2);
					}
				}
				
				time++;
			}
			
		}

	}

}