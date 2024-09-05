import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] p;
 
	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			p = new int[N + 1];
			
			for (int i = 1; i <= N; i++) {
				p[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				if (Integer.parseInt(st.nextToken()) == 0) {
					union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				} else {
					if (findSet(Integer.parseInt(st.nextToken())) == findSet(Integer.parseInt(st.nextToken()))) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			
			sb.append("\n");
			
		}
		
		System.out.println(sb);
		
	}

	static int findSet(int x) {
		
		if (p[x] == x) {
			return x;
		}
		return p[x] = findSet(p[x]);
		
	}

	static void union(int a, int b) {
		
		a = findSet(a);
		b = findSet(b);
		p[a] = b;
		
	}
	
}