import java.io.FileInputStream;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int testCaseCount = sc.nextInt();

		for(int i = 0; i<testCaseCount; i++) {
			int N = sc.nextInt();
			int [][]array = generateArray(sc, N);
			int [][]oneTurnedArray = turnArray(array,N);
			int [][]twoTurnedArray = turnArray(oneTurnedArray,N);
			int [][]threeTurnedArray = turnArray(twoTurnedArray,N);
			
			System.out.println("#"+(i+1));
			for(int j = 0; j<N;j++) {
				String resultLineString = arrayLineToString(oneTurnedArray,j)+" "+arrayLineToString(twoTurnedArray,j)+" "+arrayLineToString(threeTurnedArray,j);
				
				System.out.println(resultLineString);
			}
		}
	}
	

	public static int[][] generateArray(Scanner sc, int size) {

		int[][]array = new int[size][size];
		
		for(int j = 0; j<size; j++) {
			for(int k = 0; k<size; k++) {					
				int value = sc.nextInt();
				array[j][k] = value; 
			}
		}
		return array;
	}
	
	public static int[][] turnArray(int[][] array, int size) {
		
		int[][]tempArray = new int[size][size];
		
		for(int j = 0; j<size; j++) {
			for(int k = size-1; k>=0; k--) {
				tempArray[j][size-1-k] = array[k][j]; 
			}
		}
		return tempArray;
	}
	
	public static String arrayLineToString(int[][] array, int line) {
		String tempString = "";
		for(int i = 0; i<array.length; i++) {
			tempString += array[line][i];
		}
		
		return tempString;
	}
	
}