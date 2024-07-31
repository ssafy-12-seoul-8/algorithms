import java.io.*;
import java.util.*;

public class Main {
	
	static int max = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] tickets = new char[n][m];
		
		for (int i = 0; i < n; i++) {
			tickets[i] = br.readLine()
					.toCharArray();
			
			for (int j = 0; j < m; j++) {
				int number = tickets[i][j] - '0';
				
				if (Math.sqrt(number) == (int) Math.sqrt(number)) {
					max = Math.max(max, number);
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				findSequence(tickets, i, j);
			}
		}
		
		System.out.println(max);
	}
	
	static void findSequence(char[][] tickets, int row, int col) {
		for (int i = -tickets.length; i < tickets.length; i++) {
			for (int j = -tickets[0].length; j < tickets[0].length; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				
				int newRow = row + i;
				int newCol = col + j;
				StringBuilder sb = new StringBuilder()
						.append(tickets[row][col]);
				
				while (isInMatrix(tickets, newRow, newCol)) {
					sb.append(tickets[newRow][newCol]);
					
					max = Math.max(max, getPower(sb));
					
					newRow += i;
					newCol += j;
				}
			}
		}
	}
	
	static int getPower(StringBuilder sb) {
		int number = Integer.parseInt(sb.toString());
		
		if (Math.sqrt(number) == (int) Math.sqrt(number)) {
			return number;
		}
		
		return -1;
	}
	
	static boolean isInMatrix(char[][] tickets, int row, int col) {
		return row >= 0
				&& col >= 0
				&& row < tickets.length
				&& col < tickets[0].length;
	}
	
}