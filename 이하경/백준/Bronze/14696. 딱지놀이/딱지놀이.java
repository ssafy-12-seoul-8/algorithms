import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for (int n = 0; n < N; n++) {
			int[] cnt = new int[4];
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < a; i++) {
				cnt[4 - Integer.parseInt(st.nextToken())]++;
			}
			
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < b; i++) {
				cnt[4 - Integer.parseInt(st.nextToken())]--;
			}
			
			char win = 'D';
			
			for (int i = 0; i < 4; i++) {
				if (cnt[i] > 0) {
					win = 'A';
					break;
				}
				if (cnt[i] < 0) {
					win = 'B';
					break;
				}
			}
			
			sb.append(win).append("\n");
			
		}
		
		System.out.println(sb);

	}

}