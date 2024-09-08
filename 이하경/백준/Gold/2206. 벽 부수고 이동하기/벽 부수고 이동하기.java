import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dr = { 1, 0, -1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(bfs());
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String inp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = inp.charAt(j) - '0';
            }
        }
    }

    static int bfs() {
        if (n == 1 && m == 1) {
            return 1;
        }

        boolean[][] visitBefore = new boolean[n][m];
        boolean[][] visitAfter = new boolean[n][m];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1, true));
        visitBefore[0][0] = true;

        while(!q.isEmpty()) {
            Point curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visitBefore[nr][nc]) {
                    if (nr == n - 1 && nc == m - 1) {
                        return curr.dist + 1;
                    }
                    if (map[nr][nc] == 0) { // 벽이 아닐때
                        if (curr.canBreak) { // 벽 부수기 전이면
                            visitBefore[nr][nc] = true;
                            q.add(new Point(nr, nc, curr.dist + 1, true));
                        } else if (!visitAfter[nr][nc]) { // 이미 하나 부순적있으면
                            visitAfter[nr][nc] = true;
                            q.add(new Point(nr, nc, curr.dist + 1, false));
                        }
                    } else { // 벽일때
                        if (curr.canBreak && !visitAfter[nr][nc]) { // 부술수있으면
                            visitAfter[nr][nc] = true;
                            q.add(new Point(nr, nc, curr.dist + 1, false));
                        }
                    }
                }
            }
        }
        return -1;
    }

    static class Point {
        int r, c, dist;
        boolean canBreak;

        public Point(int r, int c, int dist, boolean canBreak) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.canBreak = canBreak;
        }
    }
}
