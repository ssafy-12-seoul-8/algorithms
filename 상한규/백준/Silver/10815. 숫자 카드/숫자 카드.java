import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> set = new HashSet<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			
			set.add(value);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			
			if(set.contains(target)) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append(" ");
		}
		System.out.println(sb);
	}
}
