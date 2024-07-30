import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		int T = 10;
		int[] result = new int[T];

		for(int i = 0; i < T; i++) {
			int count = 0;
			int[] boxArray = new int[100];
			int dumpCount = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				int value = Integer.parseInt(st.nextToken());
				boxArray[count++] = value;
			}
			Arrays.sort(boxArray);
			
			while(dumpCount != 0) {
				if(boxArray[0] < boxArray[boxArray.length - 1]) {
					boxArray[0]++;
					boxArray[boxArray.length - 1]--;
					Arrays.sort(boxArray);
					dumpCount--;
				}
				else {
					break;
				}
			}
			result[i] =  boxArray[boxArray.length - 1] - boxArray[0];
		}
		for(int i = 0; i < result.length; i++) {
			System.out.printf("#%d %d\n", i + 1, result[i]);
		}
	}
}
