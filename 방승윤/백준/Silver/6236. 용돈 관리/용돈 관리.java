import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] cost = new int[N];
		int money = 0;
		int total = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			
			total += temp;
			cost[i] = temp;
			money = Math.max(cost[i], money);
		}
		
		money = Math.max(money, (int) Math.ceil((double) total / M));
		
		while (true) {
			int temp = money;
			int cnt = 1;
			
			for (int i = 0; i < N; i++) {
				if (temp >= cost[i]) {
					temp -= cost[i];
				} else {
					temp = money - cost[i];
					cnt++;
				}
				if (cnt > M) {
					money++;
					break;
				}
			}
			if (cnt <= M) {
				break;
			}
		}
		
		System.out.println(money);
		
	}
	
}