import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= cases; t++) {
			int n = Integer.parseInt(br.readLine());
			Queue<String> first = new LinkedList<>();
			Queue<String> second = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int half = n % 2 == 0 ? n / 2 : n / 2 + 1;
			
			while (st.hasMoreTokens()) {
				if (first.size() < half) {
					first.add(st.nextToken());
				} else {
					second.add(st.nextToken());
				}
			}
			
			StringBuilder sb = new StringBuilder()
					.append("#")
					.append(t)
					.append(" ");
			
			while (!first.isEmpty()) {
				sb.append(first.poll())
					.append(" ");
				
				if (!second.isEmpty()) {
					sb.append(second.poll())
						.append(" ");
				}
			}
			
			System.out.println(sb);
		}
	}
	
}