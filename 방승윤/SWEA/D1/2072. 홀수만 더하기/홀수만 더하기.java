import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int a = 0;
            for(int i = 0; i < 10; i++)
            {
                int b = sc.nextInt();
                if(b % 2 == 1)
                {
                    a += b;
                }
            }
            System.out.println("#" + test_case + " " + a);
		}
	}
}