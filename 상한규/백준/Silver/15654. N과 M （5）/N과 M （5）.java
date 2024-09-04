import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr, ans;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		ans = new int[M];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		recur(0);
	}
	
	static void recur(int count) {
		StringBuilder sb = new StringBuilder();
		if(count == M) {
			for(int result : ans) {
				sb.append(result).append(" ");
			}
			System.out.println(sb);
			return;
		} else {
			for(int i = 0; i < N; i++) {
				if(visited[i] == false) {
					ans[count] = arr[i];
					visited[i] = true;
					recur(count + 1);
					visited[i] = false;
				}
			}
		}
	}
}
