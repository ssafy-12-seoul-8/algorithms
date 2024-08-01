import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt(); // 3

		for (int test_case = 1; test_case <= T; test_case++) {

			int result = 0;

			String text = sc.next();
			char[] array = new char[text.length()];

			int halfLength = text.length() / 2;

			for (int i = 0; i < halfLength; i++) {
//				char temp = text.charAt(i);
				int reverse = text.length() - i - 1;

				// 0번 자리에 반대편꺼 집어넣기
				array[i] = text.charAt(reverse);
				// 반대 자리에 0번꺼 집어넣기
				array[reverse] = text.charAt(i);
			}

			array[halfLength] = text.charAt(halfLength);

//			System.out.println(array);
			String newText = "";

			for (int i = 0; i < text.length(); i++) {
				newText += array[i];
			}

			if (text.equals(newText))
				result = 1;

			System.out.println("#" + test_case + " " + result);
		}
	}
}