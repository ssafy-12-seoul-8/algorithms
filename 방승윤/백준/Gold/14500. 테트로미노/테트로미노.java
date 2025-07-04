import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int N;
    static int M;
    static int maxS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                visited[r][c] = true;
                recur(1, r, c, board[r][c]);
                visited[r][c] = false;

                if (r + 1 < N && c - 1 >= 0 && r - 1 >= 0) {
                    maxS = Math.max(maxS, board[r][c] + board[r + 1][c] + board[r][c - 1] + board[r - 1][c]);
                }

                if (c + 1 < M && c - 1 >= 0 && r - 1 >= 0) {
                    maxS = Math.max(maxS, board[r][c] + board[r][c + 1] + board[r][c - 1] + board[r - 1][c]);
                }

                if (c + 1 < M && r + 1 < N && r - 1 >= 0) {
                    maxS = Math.max(maxS, board[r][c] + board[r][c + 1] + board[r + 1][c] + board[r - 1][c]);
                }

                if (c + 1 < M && r + 1 < N && c - 1 >= 0) {
                    maxS = Math.max(maxS, board[r][c] + board[r][c + 1] + board[r + 1][c] + board[r][c - 1]);
                }
            }
        }

        System.out.println(maxS);
    }

    static void recur(int level, int r, int c, int s) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
                if (level < 3) {
                    visited[nr][nc] = true;
                    recur(level + 1, nr, nc, s + board[nr][nc]);
                    visited[nr][nc] = false;
                }

                if (level == 3) {
                    maxS = Math.max(maxS, s + board[nr][nc]);
                }
            }
        }
    }
}