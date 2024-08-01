import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			String word = br.readLine();
			Deque<Character> dq = new ArrayDeque<>();
			int answer = 1;
			int len = word.length();
			
			for (int i = 0; i < len; i++) {
				if (i < len / 2) {
					dq.push(word.charAt(i));
					
					continue;
				}
				
				if (len % 2 != 0 && i == len / 2) {
					continue;
				}
				
				if (dq.poll() != word.charAt(i)) {
					answer = 0;
					
					break;
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}
	
}