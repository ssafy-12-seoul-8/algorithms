import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            
        	StringBuilder sb = new StringBuilder();
        	String S = sc.next();
        	int ball = 0;
        	
        	for (int i = 0; i < S.length(); i++) {
        		if (S.charAt(i) == '(') {
        			ball++;
        		} else if (S.charAt(i) == ')') {
        			ball++;
        			if (S.charAt(i - 1) == '(') {
        				ball--;
        			}
        		}
        	}
        	
        	sb.append("#").append(test_case).append(" ").append(ball);
            System.out.println(sb);
            
        }
        
    }
    
}