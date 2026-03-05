import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int ans = 0;
        char[][] field = new char[N][M];
        boolean[][][][] visited = new boolean[N][M][N][M];

        for (int i = 0; i < N; i++) {
            field[i] = br.readLine().toCharArray();
        }

        int[] r = new int[2];
        int[] b = new int[2];

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1 ; j++) {
                if (field[i][j] == 'R') {
                    r[0] = i;
                    r[1] = j;
                }

                if (field[i][j] == 'B') {
                    b[0] = i;
                    b[1] = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r[0], r[1], b[0], b[1], 0});
        visited[r[0]][r[1]][b[0]][b[1]] = true;

        while (!queue.isEmpty() && ans == 0) {
            int[] curr = queue.poll();
            int rx = curr[0];
            int ry = curr[1];
            int bx = curr[2];
            int by = curr[3];
            int depth = curr[4];

            for (int d = 0; d < 4; d++) {
                int nrx = rx;
                int nry = ry;
                int nbx = bx;
                int nby = by;
                int rMove = 0;

                while (field[nrx + dx[d]][nry + dy[d]] != '#' && field[nrx][nry] != 'O') {
                    nrx += dx[d];
                    nry += dy[d];
                    rMove++;
                }

                int bMove = 0;

                while (field[nbx + dx[d]][nby + dy[d]] != '#' && field[nbx][nby] != 'O') {
                    nbx += dx[d];
                    nby += dy[d];
                    bMove++;
                }

                if (field[nbx][nby] == 'O') {
                    continue;
                }

                if (field[nrx][nry] == 'O') {
                    ans = 1;
                }

                if (nrx == nbx && nry == nby) {
                    if (rMove > bMove) {
                        nrx -= dx[d];
                        nry -= dy[d];
                    }

                    if (bMove > rMove) {
                        nbx -= dx[d];
                        nby -= dy[d];
                    }
                }

                if (visited[nrx][nry][nbx][nby]) {
                    continue;
                }

                if (depth == 9) {
                    continue;
                }

                queue.add(new int[] {nrx, nry, nbx, nby, depth + 1});
            }
        }

        System.out.println(ans);
    }
}