import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int[] dwarf = new int[9];
	static boolean[] visitedDwarf = new boolean[9];
	static StringBuilder sb = new StringBuilder();
	static boolean find;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		
		findReal(0, 0);
		
		System.out.println(sb);
		
	}
	
	static void findReal(int idx, int sum) {
		
		if (find) {
			return;
		}

		if (idx == 7 && sum == 100) {
			for (int i = 0; i < 9; i++) {
				if (visitedDwarf[i]) {
					sb.append(dwarf[i]).append("\n");
				}
			}
			
			find = true;
			
			return;
		} else if (sum > 100 || idx == 7) {
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (!visitedDwarf[i]) {
				visitedDwarf[i] = true;
				findReal(idx + 1, sum + dwarf[i]);
				visitedDwarf[i] = false;
			}
		}
		
	}
	
}