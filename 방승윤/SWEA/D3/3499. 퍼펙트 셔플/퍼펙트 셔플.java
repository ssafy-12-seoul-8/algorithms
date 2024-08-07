import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
        	
        	int N = sc.nextInt();
        	
        	Queue<String> card1 = new LinkedList<>();
        	Queue<String> card2 = new LinkedList<>();
        	
        	for (int i = 0; i < N / 2 + N % 2; i++) {
        		card1.offer(sc.next());
        	}
        	
        	for (int i = 0; i < N / 2; i++) {
        		card2.offer(sc.next());
        	}
        	
        	System.out.print("#" + test_case);
        	for (int i = 0; i < N / 2 + N % 2; i++) {
        		System.out.print(" " + card1.poll());
        		if (card2.isEmpty()) {
        			break;
        		}
        		System.out.print(" " + card2.poll());
        	}
        	System.out.println();
        	
        }
    	
    }
}