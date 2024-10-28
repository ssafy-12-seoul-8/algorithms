import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		Queue<int[]> queue = new LinkedList<>();
		int[] priorityArray = new int[10];
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int count = 0;
			queue.clear();
			priorityArray = new int[10];
			
			for(int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				priorityArray[value]++;
				
				queue.offer(new int[] {j, value});
			}
			
			while(!queue.isEmpty()) {
				int[] arr = queue.poll();
				boolean isHighest = true;
				
				for(int j = arr[1] + 1; j < 10; j++) {
					if(priorityArray[j] != 0) {
						isHighest = false;
						
						break;
					}
				}

				if(isHighest) {
					if(arr[0] == M) {
						sb.append(count + 1).append("\n");
						
						break;
					} else {
						count++;
						priorityArray[arr[1]]--;
					}
				} else {
					queue.offer(arr);
				}
			}
		}
		
		System.out.println(sb);
	}
}
