import java.io.*;

class Solution {
	
	static final int cases = 10;
	static final int rooms = 100;
	
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= cases; t++) {
			int tc = Integer.parseInt(br.readLine());
			
			char[][] rows = new char[rooms][rooms];
			char[][] cols = new char[rooms][rooms];
			
			for (int i = 0; i < rooms; i++) {
				rows[i] = br.readLine()
						.toCharArray();
			}
			
			for (int i = 0; i < rooms; i++) {
				for (int j = 0; j < rooms; j++) {
					cols[i][j] = rows[j][i];
				}
			}
			
			
			for (int i = 0; i < rooms; i++) {
				findPalindrome(rows[i]);
				findPalindrome(cols[i]);
			}
			
			System.out.println("#" + tc + " " + max);
			
			max = 0;
		}
	}
	
	static void findPalindrome(char[] str) {
		for (int i = 0; i < rooms; i++) {
			extendPalindrome(str, i, i + 2);
			extendPalindrome(str, i, i + 1);
		}
	}
	
	static void extendPalindrome(char[] str, int begin, int end) {
		while (begin >= 0 && end < str.length && str[begin] == str[end]) {
			begin--;
			end++;
		}
		
		max = Math.max(max, end - begin - 1);
	}
	
}