import java.util.Scanner;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
 
            test_case = sc.nextInt(); // 1 (무의미한 입력값)
 
            String compare = sc.next(); // ti
            String str = sc.next(); // Starteatingwellwithe~~
 
            // str.length() - compare.length() 만큼 반복해서
            // 만약 첫 번째 글자가 같다면
 
            int result = 0;
            for (int i = 0; i <= str.length() - compare.length(); i++) {
                int cnt = 0;
 
                for (int j = 0; j < compare.length(); j++) {
                    if (compare.charAt(j) == str.charAt(i + j)) {
                        cnt++;
                    }
                    if (cnt == compare.length()) {
                        result++;
                    }
                }
 
            }
 
            System.out.println("#" + test_case + " " + result);
        }
 
    }
}