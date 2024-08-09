import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int result = -1;
			int N = Integer.parseInt(br.readLine());
			int[] array = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				array[j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 0; j < N - 1; j++) {
				loop: for (int k = j + 1; k < N; k++) {
					int timesValue = array[j] * array[k];
					
					String str = Integer.toString(timesValue);
					
					for(int l = 1; l < str.length(); l++) {
						if(str.charAt(l - 1) > str.charAt(l)) {
							continue loop;
						}
					}
					result = Math.max(result, timesValue);
				}
			}
			System.out.printf("#%d %d\n", i + 1, result);
		}
	}
}