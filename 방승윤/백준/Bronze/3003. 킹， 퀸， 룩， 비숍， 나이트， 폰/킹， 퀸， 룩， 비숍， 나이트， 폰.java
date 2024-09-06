import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int[] num = new int[6];
		int[] cnt = {1, 1, 2, 2, 2, 8};
		
		for (int i = 0; i < 6; i++) {
			num[i] = cnt[i] - Integer.parseInt(st.nextToken());
		}
				
		for (int answer : num) {
			sb.append(answer).append(" ");
		}
		
		System.out.println(sb);
		
	}
	
}
