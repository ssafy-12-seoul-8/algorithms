import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		int T = Integer.parseInt(br.readLine());
		int[] result = new int[T];

		for(int i = 0; i < T; i++) {
			int count = 0;
			int max = 0;
			int min = Integer.MAX_VALUE;
			long sum = 0;
			float average = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				int value = Integer.parseInt(st.nextToken());
				sum += value;
				count++;
				max = Math.max(max, value);
				min = Math.min(min, value);
			}
			
			average = (float)(sum - min - max) / (count - 2);
			result[i] = Math.round(average);

		}
		for(int i = 0; i < result.length; i++) {
			System.out.printf("#%d %d\n", i + 1, result[i]);
		}
	}
}
