
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

class Solution {

	static char[][] arr;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			test_case = sc.nextInt();
			sc.nextLine();

			arr = new char[100][100];

			for (int i = 0; i < 100; i++) {
				String line = sc.nextLine();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = line.charAt(j);
				}
			}

			int max = 0;
			// 제일 왼쪽 끝에서 제일 오른쪽 끝까지, 총 길이 99짜리 회문부터 시작함. window 의 길이를 줄여가면서 문제를 풀어보자.

			// 1. 첫 회문 찾기 -> 가장 긴것부터 확인해서 회문인지 알아보기

			// 0~99행까지 반복
			for (int i = 0; i < 100; i++) {
//				System.out.println(i + "번째 행");
				// 0 행 0~99열까지 반복 시작
				// 먼저 창문 길이를 최대(98)로 설정
				int idx;
//				int Lidx;
				// 창문 길이를 99 (최대)에서부터 1씩 줄임
				findPalindrome: for (int L = 99; L >= max; L -= 1) {
//					System.out.println("테스트 길이 L : " + L);
//					Lidx = idx + L; // '0 + 창문길이' 로 초기화
//					System.out.println("시작 인덱스 idx : " + idx);
//					System.out.println("끝 인덱스 Lidx : " + Lidx);

					for (idx = 0; idx + L < 100; idx++) {
//						Lidx = Fidx + L; // '0 + 창문길이' 로 초기화
//						System.out.println("시작 인덱스 변환 : 현재 Fidx는 : " + Fidx);
//						System.out.println("종료 인덱스 확인 : 현재 Lidx는 : " + Lidx);
						if (회문판단(i, idx, L)) {
//							System.out.println(i + "행 " + idx + " 시작점에서 " + L + " 길이의 회문이다");
							max = Math.max(max, L+1);
							break findPalindrome;
						}
					}

				}

			}

			// 0~99열까지 반복
			for (int i = 0; i < 100; i++) {
				int idx;
				findPalindrome: for (int L = 99; L >= max; L -= 1) {
					for (idx = 0; idx + L < 100; idx++) {
						if (세로회문판단(i, idx, L)) {	// i 번째 열, 시작점 idx, 길이 L
							max = Math.max(max, L+1);
							break findPalindrome;
						}
					}
				}
			}
			// 끝
			System.out.println("#" + test_case + " " + max);
		}
	}

	// isPalindrome
	static boolean 회문판단(int i, int idx, int L) { // i 번째 행, 시작점 idx, 길이 L

		int end = idx + L;
		// a 번째 글자와 a+L 번째 글자 사이의 내부 비교 시작
		while (idx <= end) {
			if (arr[i][idx] != arr[i][end]) {
				return false;
			} 
			idx++;
			end--;
		}
		return true;
	}

	// isPalindrome
	static boolean 세로회문판단(int i, int idx, int L) { // i 번째 열, 시작점 idx, 길이 L

		int end = idx + L;
		// a 번째 글자와 a+L 번째 글자 사이의 내부 비교 시작
		while (idx <= end) {
			if (arr[idx][i] != arr[end][i]) {
				return false;
			} 
			idx++;
			end--;
		}
		return true;
	}

}