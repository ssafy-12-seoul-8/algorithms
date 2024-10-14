import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		StringTokenizer stNum = new StringTokenizer(st.nextToken(), "+");
		int ans = 0;
		
		while (stNum.hasMoreTokens()) {
			ans += Integer.parseInt(stNum.nextToken());
		}
		
		while (st.hasMoreTokens()) {
			stNum = new StringTokenizer(st.nextToken(), "+");
			
			while (stNum.hasMoreTokens()) {
				ans -= Integer.parseInt(stNum.nextToken());
				
			}
		}
		
		System.out.println(ans);
		
	}

}