import java.util.*;
import java.io.*;

public class Solution {
	static int N, M;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			StringBuilder result = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parent = new int[N + 1];
			
			for(int i = 1; i <= N; i++) {
				parent[i] = i;
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int operation = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(operation == 0) {
					union(a, b);
				} else if(operation == 1) {
					if(findSet(a) == findSet(b)) {
						result.append("1");
					} else {
						result.append("0");
					}
				}
				
			}
		
			System.out.printf("#%d %s\n", tc + 1, result);
		}
	}
	
	static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		
		parent[a] = b;
	}
	
	static int findSet(int x) {
		if(parent[x] == x) {
			return x;
		} else {
			return parent[x] = findSet(parent[x]);
		}
	}
}
