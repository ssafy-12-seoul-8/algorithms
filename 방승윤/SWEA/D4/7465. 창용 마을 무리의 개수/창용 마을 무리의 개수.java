import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	static int[] relation;
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			relation = new int[N + 1];
			
			for (int i = 1; i <= N; i++) {
				relation[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				unionRelation(A, B);
			}
			
			sb.append("#").append(tc).append(" ").append(N).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	static int findRelation(int x) {
		
		if (relation[x] == x) {
			return x;
		}
		return findRelation(relation[x]);
	}
	
	static void unionRelation(int x, int y) {
		
		if (findRelation(y) != findRelation(x)) {
			N--;
			relation[findRelation(y)] = findRelation(x);	
		}
		
	}
	
}