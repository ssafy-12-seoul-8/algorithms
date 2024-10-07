import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());
		boolean[] S = new boolean[21];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			switch (st.nextToken()) {
			case "add":
				S[Integer.parseInt(st.nextToken())] = true;
				break;
			case "remove":
				S[Integer.parseInt(st.nextToken())] = false;
				break;
			case "check":
				if (S[Integer.parseInt(st.nextToken())]) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
			case "toggle":
				int num = Integer.parseInt(st.nextToken());
				if (S[num]) {
					S[num] = false;
				} else {
					S[num] = true;
				}
				break;
			case "all":
				Arrays.fill(S, true);
				break;
			case "empty":
				Arrays.fill(S, false);
				break;
			}
		}
		
		System.out.println(sb);
		
	}
		
}