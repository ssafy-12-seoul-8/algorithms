import java.io.*;
import java.util.*;

public class Solution {
	
	static final int total = 1000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			br.readLine();
			
			int[] scoreCounts = new int[101];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < total; i++) {
				scoreCounts[Integer.parseInt(st.nextToken())]++;
			}
			
			int maxCount = 0;
			int maxScore = 0;
			
			for (int i = 1; i <= 100; i++) {
				if (maxCount <= scoreCounts[i]) {
					maxCount = scoreCounts[i];
					maxScore = i;
				}
			}
			
			System.out.println("#" + t + " " + maxScore);
		}
		
	}
	
}
