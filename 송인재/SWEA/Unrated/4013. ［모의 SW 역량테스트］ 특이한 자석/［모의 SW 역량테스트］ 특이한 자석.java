import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static final int[][] magnetics = new int[4][8];
	static final int[][] current = new int[4][2];
	static final int CLOCK = 1;
	static final int ANTICLOCK = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			int k = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < 8; j++) {
					magnetics[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			current[0] = new int[] {-1, 2};
			current[1] = new int[] {6, 2};
			current[2] = new int[] {6, 2};
			current[3] = new int[] {6, -1};
			
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken()) - 1;
				int direction = Integer.parseInt(st.nextToken());
				int prevWait = direction == CLOCK ? turnClock(index, 0) : turnAntiClock(index, 0);
				int nextWait = direction == CLOCK ? turnClock(index, 1) : turnAntiClock(index, 1);
				
				changeMag(index, direction == CLOCK ? ANTICLOCK : CLOCK, -1);
				changeMag(index, direction == CLOCK ? ANTICLOCK : CLOCK, 1);
				
				current[index][0] = prevWait;
				current[index][1] = nextWait;
			}
			
			System.out.println("#" + t + " " + getSum());
		}
	}
	
	static int getSum() {
		int sum = 0;
		
		for (int i = 0; i < 4; i++) {
			int index = current[i][0] == -1 ? current[i][1] - 2 : current[i][0] + 2;
			
			if (index < 0) {
				index += 8;
			} else if (index > 7) {
				index -= 8;
			}
			
			sum += magnetics[i][index] << i;
		}
		
		return sum;
	}
	
	static void changeMag(int index, int direction, int next) {
		if (index + next < 0 || index + next > 3) {
			return;
		}
		
		int nextCompare = next == -1 ? current[index + next][1] : current[index + next][0];
		int thisCompare = next == -1 ? current[index][0] : current[index][1];
		
		if (magnetics[index + next][nextCompare] != magnetics[index][thisCompare]) {
			int prevWait = direction == CLOCK ? turnClock(index + next, 0) : turnAntiClock(index + next, 0);
			int nextWait = direction == CLOCK ? turnClock(index + next, 1) : turnAntiClock(index + next, 1);
			
			changeMag(index + next, direction == CLOCK ? ANTICLOCK : CLOCK, next);
			
			current[index + next][0] = prevWait;
			current[index + next][1] = nextWait;
		}
	}
	
	static int turnClock(int index, int leftRight) {
		if (current[index][leftRight] == -1) {
			return -1;
		}
		
		if (current[index][leftRight] == 0) {
			return 7;
		}
		
		return current[index][leftRight] - 1;
	}
	
	static int turnAntiClock(int index, int leftRight) {
		if (current[index][leftRight] == -1) {
			return -1;
		}
		
		if (current[index][leftRight] == 7) {
			return 0;
		}
		
		return current[index][leftRight] + 1;
	}
	
}
