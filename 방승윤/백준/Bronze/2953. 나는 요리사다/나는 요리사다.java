import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int highScore = 0;
		int person = 0;
		
		for (int tc = 1; tc <= 5; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int tmp = 0;
			
			for (int i = 0; i < 4; i++) {
				tmp += Integer.parseInt(st.nextToken());
			}
			
			if (tmp > highScore) {
				highScore = tmp;
				person = tc;
			}
		}
		
		System.out.println(person + " " + highScore);
		
	}
	
}