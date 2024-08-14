import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			int n = Integer.parseInt(br.readLine());
			Set<Integer> set = new HashSet<>();
			int current = n;
			
			while (set.size() < 10) {
				String number = String.valueOf(current);
				
				for (int i = 0; i < number.length(); i++) {
					set.add(number.charAt(i) - '0');
				}
				
				current += n;
			}
			
			System.out.println("#" + t + " " + (current - n));
		}
	}

}
