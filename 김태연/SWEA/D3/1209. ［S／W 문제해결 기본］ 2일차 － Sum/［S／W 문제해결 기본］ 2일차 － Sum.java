import java.util.Scanner;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10; // 10
 
        for (int test_case = 1; test_case <= T; test_case++) {
   
            test_case = sc.nextInt();
             
            int[][] arr = new int[100][100];
         
            // 100 * 100 에 숫자 채우기!
            for (int i=0; i<100; i++) {
                for (int j=0; j<100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int max = 0;
            // 행 합 구하기
            for (int r = 0; r<100; r++) {
                int cSum = 0;
                for (int c=0; c<100; c++) {
                    cSum += arr[r][c];
                    max = Math.max(max, cSum);
                }
            }
             
             
            // 열 합 구하기
            for (int c=0; c<100; c++) {
                int rSum = 0;
                for (int r=0; r<100; r++) {
                    rSum += arr[r][c];
                    max = Math.max(max, rSum);
                }
            }
             
             
            // X 합 구하기
             
 
            int crossSum1 = 0;
            int crossSum2 = 0;
            for (int i=0; i<100; i++) {
                crossSum1 += arr[i][i];
            }
            max = Math.max(max, crossSum1);
             
            for (int i=0; i<100; i++) {
                int j = 99-i;
                crossSum2 += arr[i][j];
            }
            max = Math.max(max, crossSum2);
             
            System.out.println("#" + test_case + " " + max);
        }
    }
}