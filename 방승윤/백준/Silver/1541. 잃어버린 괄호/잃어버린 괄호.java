import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		Queue<Integer> queue = new LinkedList<>();
		
		while (st.hasMoreTokens()) {
			StringTokenizer stNum = new StringTokenizer(st.nextToken(), "+");
			int num = 0;
			
			while (stNum.hasMoreTokens()) {
				num += Integer.parseInt(stNum.nextToken());
			}
			
			queue.add(num);
		}
		
		int ans = queue.poll();
		
		for (int num : queue) {
			ans -= num;
		}
		
		System.out.println(ans);
		
	}

}