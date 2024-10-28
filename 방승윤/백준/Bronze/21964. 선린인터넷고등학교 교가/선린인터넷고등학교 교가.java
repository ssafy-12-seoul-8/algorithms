import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		for (int i = N - 5; i < N; i++) {
			sb.append(str.charAt(i));
		}
		
		System.out.println(sb);
		
	}
	
}