import java.util.Scanner;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt(); // 2
 
        for (int test_case = 1; test_case <= T; test_case++) {
 
            int N = sc.nextInt(); // 3
            int[][] arr = new int[N][N];
            int cnt = 1;
            // 우 하,좌,상
            int[] dr = { 0, 1, 0, -1 };
            int[] dc = { 1, 0, -1, 0 };
 
            int r = 0;
            int c = 0;
            // 현 위치 : [0,0]
            int idx = 0;
 
 
            for (int i = 0; i < N * N; i++) {
//              System.out.println("현재 좌표는 : " + r + ", " + c);
                // 먼저 현재 좌표를 찍어야함.
                arr[r][c] = cnt++;
                // [0,0] 에 1을 입력함.
                // cnt 는 한 번 입력할 때 마다 더해줌.
 
                // 그 다음, 움직일 수 있는지 판단해야함.
                // 1. nextR and nextC 가 '범위내' 인지
                // 2. arr[nextR][nextC] == 0 인지
 
                int nextR = r + dr[idx];
                int nextC = c + dc[idx];
                // 1번 조건 : 다음 좌표가 격자범위 내부인지
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N){
                 // 2번 조건 : 다음 좌표값이 0인지
                    if (arr[nextR][nextC] == 0) {
                        r = nextR;
                        c = nextC;
                    } else {
                        idx++;
                        idx %= 4;
                        nextR = r + dr[idx];
                        nextC = c + dc[idx];
                        r = nextR;
                        c = nextC;
                         
                    }
                } else {
                    idx++;
                    idx %= 4;
                    nextR = r + dr[idx];
                    nextC = c + dc[idx];
                    r = nextR;
                    c = nextC;
                }
            }
             
            System.out.println("#" + test_case);
             
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}