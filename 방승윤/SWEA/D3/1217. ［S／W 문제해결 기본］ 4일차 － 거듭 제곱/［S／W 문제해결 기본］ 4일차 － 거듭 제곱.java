import java.util.Scanner;

public class Solution {
	
    public static void main(String[] args) throws Exception {
		
    	Scanner sc = new Scanner(System.in);
    	
    	for (int tc = 1; tc <= 10; tc++) {
    		
    		sc.nextInt();
    		int N = sc.nextInt();
    		int M = sc.nextInt();
    		
    		System.out.println("#" + tc + " " + pow(N,M));
    		
    	}
    	
	}
    
    static int pow(int lower, int upper) {
    	if (upper == 1) {
    		return lower;
    	}
    	int temp = pow(lower, upper / 2);
    	if (upper % 2 == 0) {
    		return temp * temp;    		
    	} else {
    		return temp * temp * lower;
    	}
    	
    }
    
}