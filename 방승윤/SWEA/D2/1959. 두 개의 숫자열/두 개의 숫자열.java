import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            
        	StringBuilder sb = new StringBuilder();
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	int max = Math.max(N, M);
        	int min = Math.min(N, M);
        	
        	int[] A = new int[max];
        	int[] B = new int[min];
        	
        	for (int i = 0; i < N; i++) {
        		if (max == N) {
        			A[i] = sc.nextInt();
        		} else {
        			B[i] = sc.nextInt();
        		}
        		
        	}
        	
        	for (int i = 0; i < M; i++) {
        		if (max != N) {
        			A[i] = sc.nextInt();
        		} else {
        			B[i] = sc.nextInt();
        		}
        	}
        	
        	int answer = 0;
        	
        	for (int i = 0; i < max - min + 1; i++) {
        		int temp = 0;
        		for (int j = 0; j < min; j++) {
        			temp += A[i + j] * B[j];
        		}
        		if (answer < temp) {
        			answer = temp;
        		}
        	}
        	
        	sb.append("#").append(test_case).append(" ").append(answer);
            System.out.println(sb);
        }
        
    }
    
}