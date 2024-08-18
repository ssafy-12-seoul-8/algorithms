import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            
        	StringBuilder sb = new StringBuilder();
        	int N = sc.nextInt();
        	int[][] button = new int[100][4];
        	int cntB = 0;
        	int cntO = 0;
        	
        	for (int i = 1; i <= N; i++) {
        		String A = sc.next();
        		if (A.equals("B")) {
        			button[cntB][0] = i;
        			button[cntB++][2] = sc.nextInt();
        		} else {        			
        			button[cntO][1] = i;
        			button[cntO++][3] = sc.nextInt();
        		}
        	}
        	
        	cntB = 0;
        	cntO = 0;
        	int timeB = 0;
        	int timeO = 0;
        	int time = 0;
        	
        	for (int i = 1; i <= N; i++) {
        		if (button[cntB][0] == i) {
        			if (cntB == 0) {
        				timeB += Math.abs(button[cntB][2] - 1);
        			} else {
        				timeB += Math.abs(button[cntB][2] - button[cntB - 1][2]);
        			}
        			if (time >= timeB) {
        				timeB = time;
        			} else {
        				time = timeB;
        			}
        			cntB++;
        			timeB++;
        			time++;
        		} else if (button[cntO][1] == i) {
        			if (cntO == 0) {
        				timeO += Math.abs(button[cntO][3] - 1);
        			} else {
        				timeO += Math.abs(button[cntO][3] - button[cntO - 1][3]);
        			}
        			if (time >= timeO) {
        				timeO = time;
        			} else {
        				time = timeO;
        			}
        			cntO++;
        			timeO++;
        			time++;
        		}
        	}
        	
        	sb.append("#").append(test_case).append(" ").append(time);
            System.out.println(sb);
            
        }
        
    }
    
}