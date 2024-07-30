import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int A, B;
		A=sc.nextInt();
		B=sc.nextInt();

		int winCase = A-1 ==0?3:A-1;
		String result = B == winCase ? "A":"B";
		
		System.out.println(result);
		
	}
}