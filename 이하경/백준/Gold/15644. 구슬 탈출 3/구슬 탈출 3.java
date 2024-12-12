import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, minCount;
    static char[][] board;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { -1, 0, 1, 0 };
    static char[] dir = { 'L', 'U', 'R', 'D'};
    static char[] dirs = new char[10];
    static String dirMinCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int bx = 0, by = 0, rx = 0, ry = 0;

        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();

            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'B') {
                    bx = i; by = j;
                    board[i][j] = '.';
                }

                if (board[i][j] == 'R') {
                    rx = i; ry = j;
                    board[i][j] = '.';
                }
            }
        }

        minCount = 11;
        bt(bx, by, rx, ry, 0, -1);

        if (minCount == 11) {
            System.out.println(-1);
            return;
        }

        System.out.println(minCount);
        System.out.println(dirMinCount);
    }

    static void bt(int bx, int by, int rx, int ry, int count, int prevDir) {
        if (count >= minCount - 1) {
            return;
        }

        direction:
        for (int d = 0; d < 4; d++) {
            if (prevDir % 2 == d % 2) {
                continue;
            }

            boolean rIsFront = false;

            int nbx = bx + dx[d];
            int nby = by + dy[d];

            while (board[nbx][nby] != '#') {
                if (board[nbx][nby] == 'O') {
                    continue direction;
                }
                if (nbx == rx && nby == ry) {
                    rIsFront = true;
                }
                nbx += dx[d];
                nby += dy[d];
            }

            dirs[count] = dir[d];
            int nrx = rx + dx[d];
            int nry = ry + dy[d];

            while (board[nrx][nry] != '#') {
                if (board[nrx][nry] == 'O') {
                    minCount = count + 1;
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i <= count; i++) {
                        sb.append(dirs[i]);
                    }
                    dirMinCount = sb.toString();
                    continue direction;
                }
                nrx += dx[d];
                nry += dy[d];
            }

            nbx -= dx[d];
            nby -= dy[d];
            nrx -= dx[d];
            nry -= dy[d];

            if (nbx == nrx && nby == nry) {
                if (rIsFront) {
                    nbx -= dx[d];
                    nby -= dy[d];
                } else {
                    nrx -= dx[d];
                    nry -= dy[d];
                }
            }

            bt(nbx, nby, nrx, nry, count + 1, d);
        }
    }
}
