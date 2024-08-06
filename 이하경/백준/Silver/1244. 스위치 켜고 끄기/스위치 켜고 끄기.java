import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		boolean[] sw = new boolean[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			sw[i] = st.nextToken().equals("1") ? true : false;
		}
		
		int m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if (gender == 1) {
				int now = num;
				while (now <= n) {
					sw[now] = !sw[now];
					now += num;
				}
			} else {
				sw[num] = !sw[num];
				int f = num - 1, r = num + 1;
				while (f > 0 && r <= n) {
					if (sw[f] == sw[r]) {
						sw[f] = !sw[f];
						sw[r] = !sw[r];
						f--;
						r++;
					} else {
						break;
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			sb.append(sw[i] ? 1 : 0).append(" ");
			if (i % 20 == 0) {
				sb.append("\n");
			}
		}
		
		System.out.println(sb);

	}

}