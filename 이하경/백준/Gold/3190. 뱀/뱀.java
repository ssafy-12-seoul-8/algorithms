import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 우하좌상 순서
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        char[][] board = new char[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 'a'; // apple의 a~
        }

        board[1][1] = 's'; // snake의 s~
        int d = 0; // 뱀의 방향
        Deque<int[]> deque = new ArrayDeque<>(); // 뱀의 위치 저장
        deque.addFirst(new int[]{ 1, 1 }); // first가 머리쪽, last가 꼬리쪽

        int l = Integer.parseInt(br.readLine());

        int time = 0;
        st = new StringTokenizer(br.readLine());
        int turnTime = Integer.parseInt(st.nextToken());
        int turnDir = st.nextToken().equals("D") ? 1 : -1;
        l--;

        while (true) {
            time++;
            int nx = deque.peekFirst()[0] + dx[d];
            int ny = deque.peekFirst()[1] + dy[d];

            if (nx < 1 || nx > n || ny < 1 || ny > n || board[nx][ny] == 's') {
                break;
            }

            if (board[nx][ny] != 'a') {
                int x = deque.peekLast()[0]; // 사과가 아니라면 길이를 줄여준다
                int y = deque.peekLast()[1];
                board[x][y] = ' ';
                deque.pollLast();
            }

            board[nx][ny] = 's';
            deque.addFirst(new int[]{ nx, ny });

            if (time == turnTime) {
                d = (d + 4 + turnDir) % 4;

                if (l > 0) {
                    st = new StringTokenizer(br.readLine());
                    turnTime = Integer.parseInt(st.nextToken());
                    turnDir = st.nextToken().equals("D") ? 1 : -1;
                    l--;
                }
            }
        }

        System.out.println(time);
    }
}
