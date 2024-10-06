import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] priCnt = new int[10];
			
			Queue<Integer> queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				int pri = Integer.parseInt(st.nextToken());
				priCnt[pri]++;
				queue.offer(pri);
			}
			
			int cnt = 1;
			
			for (int i = 9; i > 0; i--) {
				while (priCnt[i] != 0) {
					int num = queue.poll();
					M--;
					
					if (num == i && M != -1) {
						priCnt[i]--;
						cnt++;
						
						if (priCnt[i] == 0) {
							i--;
						}
						
					} else if (num == i && M == -1) {
						sb.append(cnt).append("\n");
						break;
					} else if (num != i) {
						if (M == -1) {
							M = queue.size();
						}
						
						queue.offer(num);
					}
				}
				
			}
		}
		
		System.out.println(sb);
			
	}
		
}