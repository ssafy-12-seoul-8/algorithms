import java.util.*;
import java.io.*;

public class Solution{
	static Map<Integer, Integer> map = new HashMap<>();
	static int maxIndex = 1;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 5;
		
		map.put(0, 0);
		map.put(1, 1);
		
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			if(!map.containsKey(N) && maxIndex < N) {
				for(int i = maxIndex + 1; i <= N; i++) {
					map.put(i, (map.get(i - 2) + map.get(i - 1)));
				}
				maxIndex = N;
			}
			
			System.out.println(map.get(N));
		}
	}
}
