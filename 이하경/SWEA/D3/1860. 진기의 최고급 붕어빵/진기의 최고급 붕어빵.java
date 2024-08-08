import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	public static int n, m, k;
	public static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			pq = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}

			sb.append("#").append(t).append(" ").append(canBoongUh() ? "Possible" : "Impossible").append("\n");
		}
		
		System.out.println(sb);

	}
	
	public static boolean canBoongUh() {
		// 이번에 꺼낼 사람은 cnt번 사람
		int cnt = 1;
		while (!pq.isEmpty()) {
			int time = pq.poll();
			if ((time / m) * k < cnt++) {
				return false;
			}
		}
		return true;
	}
	

}