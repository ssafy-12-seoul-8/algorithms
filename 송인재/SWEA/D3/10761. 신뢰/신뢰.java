import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] robots = new int[] {1, 1};
			int[] robotTime = new int[] {0, 0};
			int time = 0;
			
			for (int i = 0; i < n; i++) {
				int current = st.nextToken().equals("B") ? 0 : 1;
				int bell = Integer.parseInt(st.nextToken());
				int timeDiff = time - robotTime[current];
				int diff = Math.abs(bell - robots[current]);
				
				if (timeDiff < diff) {
					time += diff - timeDiff;
				}
				
				time++;
				robotTime[current] = time;
				robots[current] = bell;
			}
			
			System.out.println("#" + t + " " + time);
		}
	}
	
}