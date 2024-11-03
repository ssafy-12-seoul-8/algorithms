import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < 3; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int sh = Integer.parseInt(st.nextToken());
			int sm = Integer.parseInt(st.nextToken());
			int ss = Integer.parseInt(st.nextToken());
			int eh = Integer.parseInt(st.nextToken());
			int em = Integer.parseInt(st.nextToken());
			int es = Integer.parseInt(st.nextToken());
			
			if (ss > es) {
				es += 60;
				em--;
			}
			
			if (sm > em) {
				em += 60;
				eh--;
			}
			
			int h = eh - sh;
			int m = em - sm;
			int s = es - ss;
			
			sb.append(h).append(" ").append(m).append(" ").append(s).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
}