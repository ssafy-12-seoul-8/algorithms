import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt = 0;
		int maxFruits = 0;
		int fruit = 0;
		int prevFruit = 0;
		int prevCnt = 0;
		int[] fruits = new int[2];
		
		for (int i = 0; i < N; i++) {
			fruit = Integer.parseInt(st.nextToken());
			
			if (fruit != fruits[0] && fruit != fruits[1]) {
				if (prevFruit == fruits[0]) {
					fruits[1] = fruit;
				} else {
					fruits[0] = fruit;
				}
				
				cnt = prevCnt + 1;
				prevCnt = 1;
			} else {
				if (fruit == fruits[0]) {
					if (fruits[0] == prevFruit) {
						prevCnt++;
					} else {
						prevCnt = 1;
					}
					
					cnt++;
				} else {
					if (fruits[1] == prevFruit) {
						prevCnt++;
					} else {
						prevCnt = 1;
					}
					
					cnt++;
				}
			}
			
			prevFruit = fruit;
			maxFruits = Math.max(maxFruits, cnt);
		}
		
		System.out.print(maxFruits);
		
	}
	
}