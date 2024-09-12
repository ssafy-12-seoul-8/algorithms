import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean ascending = false;
		boolean descending = false;
		int start = Integer.parseInt(st.nextToken());
		
		while(st.hasMoreTokens() && (ascending == false || descending == false)) {
			int next = Integer.parseInt(st.nextToken());
			
			if(start - 1 == next) {
				descending = true;
			} else if(start + 1 == next) {
				ascending = true;
			} else {
				ascending = true;
				descending = true;
			}
			start = next;
		}
		
		if(ascending == true && descending == true) {
			System.out.println("mixed");
		} else if(ascending == true) {
			System.out.println("ascending");
		} else {
			System.out.println("descending");
		}
	}
}