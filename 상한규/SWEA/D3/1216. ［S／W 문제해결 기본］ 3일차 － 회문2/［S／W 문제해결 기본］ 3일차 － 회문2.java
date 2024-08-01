import java.io.*;
import java.util.*;

public class Solution {
	static public int SIZE = 100;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		int T = 10;
		
		for(int i = 0; i < T; i++) {
			int result = 0;
			char[][] board = new char[SIZE][SIZE];
			int testNumber = Integer.parseInt(br.readLine());
			
			for(int j = 0; j < SIZE; j++) {
				String line = br.readLine();
				board[j] = line.toCharArray();
			}
			
			for(int j = 0; j < SIZE; j++) {
				int startIndex = 0;
				int endIndex = SIZE - 1;
				
				while(startIndex < SIZE - result) {
					endIndex = SIZE - 1;
					while(startIndex <= endIndex - result) {
						if(board[j][startIndex] == board[j][endIndex]) {
							int searchStart = startIndex + 1;
							int searchEnd = endIndex - 1;
							
							while(searchStart <= searchEnd) {
								if(board[j][searchStart] == board[j][searchEnd]) {
									searchStart++;
									searchEnd--;
									
									if(searchStart > searchEnd) {
										result = Math.max(endIndex - startIndex, result);
									}
								}
								else {
									break;
								}
							}
						}
						endIndex--;
					}
					startIndex++;
				}
			}

			for(int j = 0; j < SIZE; j++) {
				int startIndex = 0;
				int endIndex = SIZE - 1;
				
				while(startIndex < SIZE - result) {
					endIndex = SIZE - 1;
					while(startIndex <= endIndex - result) {
						if(board[startIndex][j] == board[endIndex][j]) {
							int searchStart = startIndex + 1;
							int searchEnd = endIndex - 1;
							
							while(searchStart <= searchEnd) {
								if(board[searchStart][j] == board[searchEnd][j]) {
									searchStart++;
									searchEnd--;
									
									if(searchStart > searchEnd) {
										result = Math.max(endIndex - startIndex, result);
									}
								}
								else {
									break;
								}
							}
						}
						endIndex--;
					}
					startIndex++;
				}
			}
			
			System.out.printf("#%d %d\n", testNumber, result + 1);
		}
	}
}
