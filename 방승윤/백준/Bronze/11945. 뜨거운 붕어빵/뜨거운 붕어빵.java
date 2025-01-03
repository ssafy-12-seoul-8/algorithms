import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0 ; i < N; i++) {
			String str = br.readLine();
			
			for (int j = M - 1; j >= 0; j--) {
				sb.append(str.charAt(j));
			}
			
			sb.append("\n");
		}
		
		
		System.out.println(sb);
		
	}
	
}