import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] room;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sub = Integer.parseInt(st.nextToken());
		int sis = Integer.parseInt(st.nextToken());

		bfs(sub, sis);
	}

	static void bfs(int subin, int sis) {
		if (subin == sis) {
			System.out.println(0);
			System.out.println(subin);
			return;
		}

		int prev[] = new int[200_001];
		Queue<Integer> q = new LinkedList<>();
		q.add(subin);
		prev[subin] = 1; // 다시 쓸 일 없으니까 0만 아니면 됨

		while (!q.isEmpty()) {
			int cur = q.poll();
			
			int[] nexts = { cur - 1, cur + 1, cur * 2 };
			for (int next : nexts) {
				if (next >= 0 && next < 200_001 && prev[next] == 0) {
					if (next == sis) {
						Deque<Integer> stack = new ArrayDeque<>();
						stack.push(next);
						stack.push(cur);

						while (cur != subin) {
							cur = prev[cur] - 1;
							stack.push(cur);
						}

						StringBuilder sb = new StringBuilder();
						sb.append(stack.size() - 1).append("\n");
						while (!stack.isEmpty()) {
							sb.append(stack.pop()).append(" ");
						}

						System.out.println(sb);
					}
					prev[next] = cur + 1;
					q.add(next);
				}
			}

		}
	}
}
