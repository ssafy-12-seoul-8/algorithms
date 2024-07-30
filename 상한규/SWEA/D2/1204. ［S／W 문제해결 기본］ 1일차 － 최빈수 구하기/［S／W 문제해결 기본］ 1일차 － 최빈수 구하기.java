import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		int T = Integer.parseInt(br.readLine());
		int[] result = new int[T];

		for(int i = 0; i < T; i++) {
			int[] array = new int[1000];
			int modeNumber = 0;
			int countNumber = 0;
			int testNumber = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				int value = Integer.parseInt(st.nextToken());
				array[value] += 1;
			}
			
			for(int j = 0; j < array.length; j++) {
				if(array[j] >= countNumber) {
					countNumber = array[j];
					modeNumber = j;
				}
			}
			
			result[i] = modeNumber;
		}
		for(int i = 0; i < result.length; i++) {
			System.out.printf("#%d %d\n", i + 1, result[i]);
		}
	}
}
