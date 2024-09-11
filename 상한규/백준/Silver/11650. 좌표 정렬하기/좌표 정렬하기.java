import java.io.*;
import java.util.*;

public class Main {
	public static class Position implements Comparable<Position>  {
		int x;
		int y;
		
		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Position o) {
			if(this.x == o.x) {
				return this.y - o.y;
			} else {
				return this.x - o.x;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Position[] arr = new Position[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(arr);
		
		for(Position p : arr) {
			System.out.println(p.x + " " + p.y);
		}
	}
}