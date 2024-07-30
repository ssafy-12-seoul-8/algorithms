import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		int[] resultArray = new int[10];
		
		for(int i = 0; i < 10; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] buildings = new int[N];
			int index = 2;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				 buildings[j] = Integer.parseInt(st.nextToken());
			}

			while(index < N - 2) {
				int[] compareArray = new int[5];
				int compareIndex = 0;
				for(int k = index - 2; k <= index + 2; k++) {
					compareArray[compareIndex++] = buildings[k];
				}
				Arrays.sort(compareArray);
				if(compareArray[compareArray.length - 1] == buildings[index]) {
					resultArray[i] += buildings[index] - compareArray[compareArray.length - 2];
					index += 3;
				}
				else {
					index++;
				}
			}
		}
		for(int i = 0; i < resultArray.length; i++) {
			System.out.printf("#%d %d\n", i + 1, resultArray[i]);
		}
	}
}
