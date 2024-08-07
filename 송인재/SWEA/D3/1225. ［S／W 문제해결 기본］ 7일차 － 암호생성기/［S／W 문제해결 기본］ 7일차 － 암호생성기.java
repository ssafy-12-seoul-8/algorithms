import java.io.*;
import java.util.*;

class Solution {
	
	static final int cases = 10;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= cases; t++) {
			int tc = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Integer> queue = new LinkedList<>();
			
			for (int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			int dec = 0;
			int last = 0;
			
			while ((last = queue.poll() - (dec++ % 5 + 1)) > 0) {
				queue.add(last);
			}
			
			queue.add(0);
			
			StringBuilder sb = new StringBuilder()
					.append("#")
					.append(tc)
					.append(" ");
			
			while (!queue.isEmpty()) {
				sb.append(queue.poll())
					.append(" ");
			}
			
			System.out.println(sb);
		}
	}
	
}