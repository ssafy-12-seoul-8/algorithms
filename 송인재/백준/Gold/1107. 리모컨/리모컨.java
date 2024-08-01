import java.io.*;
import java.util.*;

public class Main {
	
	static int min = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nStr = br.readLine();
		int n = Integer.parseInt(nStr);
		int m = Integer.parseInt(br.readLine());
		boolean[] broken = new boolean[10];
		
		if (m > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < m; i++) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		min = Math.abs(n - 100);
		
		permutation(broken, "", n, nStr.length());
		
		System.out.println(min);
	}
	
	static void permutation(boolean[] broken, String selected, int n, int r) {
		if (selected.length() >= r - 1 && selected.length() <= r + 1 && !selected.isBlank()) {
			min = Math.min(min, Math.abs(Integer.parseInt(selected) - n) + selected.length());
			
			if (selected.length() == r + 1) {
				return;
			}
		}
		
		for (int i = 0; i < broken.length; i++) {
			if (broken[i]) {
				continue;
			}
			
			permutation(broken, selected + i, n, r);
		}
	}
	
}