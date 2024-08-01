import java.util.Scanner;
 
class Solution {
 
    static int r, c;
//  static int[] dr = { 1, 0, 0 };
//  static int[] dc = { 0, -1, +1 };
    static int idx = 0;
    static boolean isDone = false;
    static int[][] arr = new int[100][100];
 
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10; // 10
 
        for (int test_case = 1; test_case <= T; test_case++) {
 
            test_case = sc.nextInt();
 
            // 사다리 그리기 (100 * 100)
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
 
            // 아래, 왼쪽, 오른쪽
 
            // 0 ~ 99 까지 시작점 하나씩 해보기
            search : for (int startPoint = 0; startPoint < 100; startPoint++) {
 
                if (arr[0][startPoint] != 1)
                    continue; // 시작좌표가 1이 아니면 빨리 넘어가고
                else
                    init(startPoint);   // 시작좌표가 1이면 사다리타기 준비해보자
 
//              System.out.println(test_case + "번째 테스트케이스 : " + startPoint + " 위치에서 시작 ! ");
 
                // 제일 아랫줄에 도착할 때 까지 반복해야함
                while (!isDone) {
                    // 이동
                    move();
                    // 도착 체크
                    if (r == 99) {
                        // 끝점에 도착하면 check() 를 통해 1인지 2인지 판단하고, 만약 2라면 게임을 끝내자
                        if (isArrived())  {
                            System.out.println("#" + test_case + " " + startPoint);
                            break search;
                        }
                        else
                            break;
                    }
                }
 
            }
 
        }
    }
 
    // 시작점으로 리셋하기
    public static void init(int startPoint) {
        r = 0;
        c = startPoint;
    }
 
     
    // 움직이기
    public static void move() {
        // 이동 로직
        switch (idx) {
        case 0: // 방향이 아래일 때
            // 아래로 내려가려는데 왼쪽 길이 열려있으면 왼쪽으로, 오른쪽이 열려있으면 오른쪽으로 가. 그리고 방향을 바꿔
            if ((c - 1 >= 0) && arr[r][c - 1] == 1) {
                // 왼쪽으로 간다
                c = c - 1;
                idx = 1;
            } else if ((c + 1 < 100) && arr[r][c + 1] == 1) {
                // 오른쪽으로 간다
                c = c + 1;
                idx = 2;
            } else {
                // 아래로 간다
                r = r + 1;
            }
            break;
        case 1: // 방향이 왼쪽일 때
            if ((c - 1 >= 0) && arr[r][c - 1] == 1)
                c = c - 1;
            else {
                r = r + 1;
                idx = 0; // 방향 아래로 바꿈
            }
            break;
        case 2: // 방향이 오른쪽일 때
            if ((c + 1 < 100) && arr[r][c + 1] == 1)
                c = c + 1;
            else {
                r = r + 1;
                idx = 0; // 방향 아래로 바꿈
            }
            break;
        }
    }
 
     
     
    // 제일 아랫줄에 도착했을 때 목적지인지 판단하기
    public static boolean isArrived() {
        if (arr[r][c] == 1) {
//          System.out.println("끝까지 갔는데 꽝");
            return false;
        } else {
//          System.out.println("도착!");
            return true;
        }
    }
}