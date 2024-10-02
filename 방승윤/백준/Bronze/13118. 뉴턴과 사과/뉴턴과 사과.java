import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] p = new int[4];
		int collide = 0;
		
		for (int i = 0; i < 4; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		int apple = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < 4; i++) {
			if (p[i] == apple) {
				collide = i + 1;
			}
		}
		
		System.out.println(collide);

	}

}