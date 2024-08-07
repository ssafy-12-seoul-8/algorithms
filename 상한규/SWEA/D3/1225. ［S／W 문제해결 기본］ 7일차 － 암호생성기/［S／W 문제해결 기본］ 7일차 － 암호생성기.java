import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = 10;
		
		for(int i = 0; i < T; i++) {
			int discount = 1;
			Queue<Integer> queue = new LinkedList<>();
			
			int testNumber = Integer.parseInt(br.readLine());
			String[] arrayString = br.readLine().split(" ");
			
			for(int j = 0; j < arrayString.length; j++) {
				queue.offer(Integer.parseInt(arrayString[j]));
			}
			
			while(true) {
				int value = queue.poll();
				value = value - discount < 0 ? 0 : value - discount;
				discount = (discount) % 5 + 1;
				queue.offer(value);
				if(value == 0) {
					break;
				}
			}
			System.out.printf("#%d ",testNumber);
			while(!queue.isEmpty()) {
				System.out.printf("%d ", queue.poll());
			}
			System.out.println();
		}
	}
}