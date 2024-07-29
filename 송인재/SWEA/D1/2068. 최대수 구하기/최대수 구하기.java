import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Integer> nums = new ArrayList<>();
			
			while (st.hasMoreTokens()) {
				nums.add(Integer.parseInt(st.nextToken()));
			}
			
			System.out.println("#" + t + " " + Collections.max(nums));
		}
	}
	
}
