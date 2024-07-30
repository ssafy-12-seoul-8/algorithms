//import java.io.FileInputStream;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int testCaseCount = sc.nextInt();

		for(int i = 0; i<testCaseCount; i++) {
			int result = 0;
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] A = generateArray(sc, N);
			int[] B = generateArray(sc, M);
			
			result = getMax(A,B);
			
			System.out.println("#"+(i+1)+" "+result);
		}
	}
	
	public static int[] generateArray(Scanner sc, int size) {
		int[] tempArray = new int [size];
		for(int i = 0; i < size; i++) {
			tempArray[i] = sc.nextInt();
		}
		return tempArray;
	}
	
	public static int getMax(int[] arrayA, int[] arrayB) {
		int[] tempArrayA;
		int[] tempArrayB;
		int max = 0;
		
		tempArrayA = arrayA.length > arrayB.length ? arrayA : arrayB;
		tempArrayB = arrayA.length > arrayB.length ? arrayB : arrayA;
		
		for(int i = 0; i < tempArrayA.length - tempArrayB.length + 1; i++) {
			int sum = 0;
			for(int j = 0; j < tempArrayB.length; j++) {
				sum += tempArrayA[i + j] * tempArrayB[j];
			}
			max = max > sum ? max : sum;
		}
		return max;
	}
}