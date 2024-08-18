import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
        	int temp = i;
        	int cnt = 0;
        	while (temp != 0) {
        		if (temp % 10 == 3 || temp % 10 == 6 || temp % 10 == 9) {
        			cnt++;
        		}
        		temp /= 10;
        	}
        	if (cnt == 0) {
        		sb.append(i);
        	} else {
        		for (int j = 0; j < cnt; j++) {
        			sb.append("-");
        		}
        	}
        	sb.append(" ");
        }
        System.out.println(sb);
    }
    
}