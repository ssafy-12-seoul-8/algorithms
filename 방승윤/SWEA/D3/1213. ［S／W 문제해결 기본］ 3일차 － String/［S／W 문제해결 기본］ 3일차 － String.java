import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		

		for(int test_case = 1; test_case <= 10; test_case++)
		{

            int T;
			T=sc.nextInt();
            String text = sc.next();
            String str = sc.next();
            int textIdx = 0;
            int strIdx = 0;
            int cnt = 0;
            int answer = -1;
            
            while (strIdx != str.length()) {
                if (str.charAt(strIdx) != text.charAt(textIdx)) {
                    strIdx -= textIdx;
                    textIdx = -1;
                }
                strIdx++;
                textIdx++;
                if (textIdx == text.length()) {
                    strIdx -= textIdx - 1;
                    textIdx = 0;
                    cnt++;
                }
            }
            
            if (cnt != 0) {
          		answer = cnt;
            }
            
            System.out.println("#" + T + " " + answer);

		}
	}
}