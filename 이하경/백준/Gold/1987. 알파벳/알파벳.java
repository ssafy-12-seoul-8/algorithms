import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int r;
    static int c;
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new int[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = str.charAt(j) - 'A';
            }
        }

        System.out.println(bt(0, 0, 1 << board[0][0]));
    }

    static int bt(int cr, int cc, int bit) {
        int max = 0;

        for (int d = 0; d < 4; d++) {
            int nr = cr + dr[d];
            int nc = cc + dc[d];

            if (nr >= 0 && nr < r && nc >= 0 && nc < c && (bit & (1 << board[nr][nc])) == 0) {
                max = Math.max(max, bt(nr, nc, (bit | (1 << board[nr][nc]))));
            }
        }

        return max + 1;
    }
}
