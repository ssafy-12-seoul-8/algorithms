import java.io.*;
import java.util.*;

public class Solution {
	
	static int total = 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2;
	static int cnt, temp;
	static int[] A = new int[9];
	static int[] B = new int[9];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 9; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(B);
			for (int i = 0; i < 9; i++) {
				A[i] = B[8 - i];
			}
			
			int idxB = 0;
			check : for (int i = 1; i <= 18; i++) {
				for (int j = 0; j < 9; j++) {
					if (A[j] == i) {
						continue check;
					}
				}
				B[idxB++] = i;
			}
			
			cnt = 0;
			winCnt(-1, 0, 0, 0);
			
			sb.append("#").append(tc).append(" ").append(total - cnt).append(" ").append(cnt).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static void winCnt(int idx, int scoreA, int scoreB, int check) {	
		
		if (idx != -1 && A[idx] > temp) {
			scoreA += A[idx] + temp;
		} else if (idx != -1) {
			scoreB += A[idx] + temp;
		}
		
		if (scoreA > 85) {
			return;
		}
		
		if (idx == 8) {
			if (scoreB > scoreA) {
				cnt++;
			}
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if ((check & (1 << i)) == 0) {
				temp = B[i];
				winCnt(idx + 1, scoreA, scoreB, check + (1 << i));
			}
		}
	}
    
}