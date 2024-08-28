import java.util.*;
import java.io.*;

public class Solution {
	static boolean[] ingredients;
	static int[][] board;
	static int N;
	static int AIndex;
	static int BIndex;
	static boolean[] sel;
	static int result;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int tc = 0; tc < T; tc++) {
    		N = Integer.parseInt(br.readLine());
    		board = new int[N][N];
    		result = Integer.MAX_VALUE;
    		ingredients = new boolean[N];
    		AIndex = 0;
    		BIndex = 0;
    		sel = new boolean[2];
    		
    		for(int i = 0; i < N; i++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			
    			for(int j = 0; j < N; j++) {
    				int value = Integer.parseInt(st.nextToken());
    				board[i][j] = value;
    			}
    		}
    		
    		combination(0, 0);
    		
    		System.out.printf("#%d %d\n", tc + 1, result);
    	}
    }
    
    static void combination(int index, int count) {
    	if(count == N / 2) {
    		int[] A = new int[N /2];
    		int[] B = new int[N /2];
    		
    		for(int i = 0; i < N; i++) {
    			if(ingredients[i] == true) {
    				A[AIndex++] = i;
    			} else {
    				B[BIndex++] = i;
    			}
    		}
    		
    		int ASum = 0;
    		int BSum = 0;
    		
    		for(int j = 0; j < A.length - 1; j++) {
    			for(int k = j + 1; k < A.length; k++) {
    				ASum += board[A[j]][A[k]];
    				ASum += board[A[k]][A[j]];
    				BSum += board[B[j]][B[k]];
    				BSum += board[B[k]][B[j]];
    			}
    		}
    		
    		result = Math.min(result, Math.abs(ASum - BSum));
    		AIndex = 0;
    		BIndex = 0;
    		
    		return;
    	} else {
    		for(int i = index; i < N; i++) {
    			ingredients[i] = true;
    			combination(i + 1, count + 1);
    			ingredients[i] = false;
    		}
    	}
    }
}