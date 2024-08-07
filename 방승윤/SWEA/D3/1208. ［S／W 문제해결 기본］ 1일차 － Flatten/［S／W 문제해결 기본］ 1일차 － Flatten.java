import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			
			int N;
	        N = sc.nextInt();
	        int[] blockHeight = new int[101];
	        int temp;
	        int total = 0;
	        int min = 1;
	        int minIdx = 0;
	        int maxIdx = 100;
	        
	        for (int i = 0; i < 100; i++) {
	     		temp = sc.nextInt();
	            blockHeight[temp]++;
	            total += temp;
	        }
	        
	        if (total % 100 == 0) {
	            min = 0;
	        }
	        
	        while (blockHeight[minIdx] == 0) {
	            minIdx++;
	        }
	        
	        while (blockHeight[maxIdx] == 0) {
	            maxIdx--;
	        }
	        
	        int diff = maxIdx - minIdx;
	        
	        while (N != 0 && diff != min) {
        		blockHeight[maxIdx]--;
        		blockHeight[maxIdx - 1]++;
        		blockHeight[minIdx]--;
        		blockHeight[minIdx + 1]++;
        		N--;
        		if (blockHeight[maxIdx] == 0) {
        			maxIdx--;
        		}
        		if (blockHeight[minIdx] == 0) {
        			minIdx++;
        		}
	        	diff = maxIdx - minIdx;
	        }
	        
	        System.out.println("#" + test_case + " " + diff);
		
		}
        
	}
}