import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] com;

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		com = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			com[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (find(a) != find((b))) {
				if (find(b) == 1) {
					union(b, a);
				} else {
					union(a, b);
				}
			}
		}
		
		int cnt = 0;
		
		for (int i = 2; i <= N; i++) {
			if (find(i) == 1) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}

	private static int find(int x) {
		if (x == com[x]) {
			return com[x];
		}
		return com[x] = find(com[x]);
	}

	
	private static void union(int x, int y) {
		com[find(y)] = find(x);
	}
	
}