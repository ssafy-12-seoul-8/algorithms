import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			boolean result = true;
			char[] charArray = br.readLine().toCharArray();
			
			for(int j = 0; j < charArray.length / 2; j++) {
				if(charArray[j] != charArray[charArray.length - 1 - j]) {
					result = false;
					break;
				}
			}
			System.out.printf("#%d %d\n", i + 1, result == true ? 1 : 0);
		}
	}
}
