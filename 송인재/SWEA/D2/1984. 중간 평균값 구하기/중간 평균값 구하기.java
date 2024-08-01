import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			int max = 0;
			int min = Integer.MAX_VALUE;
			List<Integer> nums = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			while (st.hasMoreTokens()) {
				int current = Integer.parseInt(st.nextToken());
				
				nums.add(current);
				
				max = Math.max(max, current);
				min = Math.min(min, current);
			}
			
			final int finalMax = max;
			final int finalMin = min;
			
			
			int sum = nums.stream()
					.filter(num -> num != finalMax && num != finalMin)
					.reduce(0, Integer::sum);
			int answer = (sum + 4) / 8;
			
			System.out.println("#" + t + " " + answer);
		}
		
	}
	
}