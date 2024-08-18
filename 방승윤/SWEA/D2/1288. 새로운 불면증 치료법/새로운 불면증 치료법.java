import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            
        	StringBuilder sb = new StringBuilder();
        	int N = sc.nextInt();
        	int xN = N;
        	int[] cnt = new int[10];
        	while(true) {
        		int temp = xN;
        		while(temp != 0) {
        			if (cnt[temp % 10] == 0) {
        				cnt[temp % 10]++;
        			}
        			temp /= 10;
        		}
        		int total = 0;
        		for (int i = 0; i < 10; i++) {
        			total += cnt[i];
        		}
        		if (total == 10) {
        			break;
        		}
        		xN += N;
        	}
            sb.append("#").append(test_case).append(" ").append(xN);
            System.out.println(sb);
        }
        
    }
    
}