import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int result = 0;
			int current = 0;
			String[] splitArray = br.readLine().split("");
			int[] bitArray = new int[splitArray.length];
			
			for(int j = 0; j < splitArray.length; j++) {
				bitArray[j] = Integer.parseInt(splitArray[j]);
			}
			
			for(int j = 0; j < bitArray.length; j++) {
				if(current != bitArray[j]) {
					result++;
					current = current == 0 ? 1 : 0;
				}
			}
			
			System.out.printf("#%d %d\n", i + 1, result);
		}
	}
}