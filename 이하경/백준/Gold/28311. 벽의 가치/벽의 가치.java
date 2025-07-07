import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, N, W, r, c, d, valueOfWall;
    static int[][] map;
    static int[][] wallMap;
    static Point[] start;
    static int[] dist;
    static int[] wallDist;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;

            map = new int[R][C]; // 0: 빈칸, -1: 벽, 자연수: 말
            wallMap = new int[R][C];
            start = new Point[N + 1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken()) - 1;
                int col = Integer.parseInt(st.nextToken()) - 1;
                map[row][col] = i + 1;
                start[i + 1] = new Point(row, col, 0);
            }

            W = 1;
            for (int i = 0; i < R; i++) {
                char[] tmp = br.readLine().toCharArray();
                for (int j = 0; j < C; j++) {
                    if (tmp[j] == 'W') {
                        map[i][j] = -1;
                        wallMap[i][j] = W++;
                    }
                }
            }

            bfs();
            for (int i = 1; i <= N; i++) {
                bfs(i);
            }

            sb.append(d).append(" ").append(valueOfWall).append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs() {
        d = 0;
        valueOfWall = 0;
        dist = new int[N + 1];
        wallDist = new int[W + 1];

        boolean[][] visit = new boolean[R][C]; // 0: 방문x, -1: 방문, 자연수: i번째 벽 지나서 방문
        Queue<Point> q = new LinkedList<>();

        visit[r][c] = true;
        q.add(new Point(r, c, 0));

        while (!q.isEmpty()) {
            Point curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    Point np = new Point(nr, nc, curr.d + 1);

                    if (map[nr][nc] > 0) {
                        dist[map[nr][nc]] = curr.d + 1;
                        d += curr.d + 1;
                        q.add(np);
                        continue;
                    }

                    if (map[nr][nc] == 0) {
                        q.add(np);
                        continue;
                    }

                    wallDist[wallMap[nr][nc]] = curr.d + 1;
                }
            }
        }
    }

    private static void bfs(int startIdx) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visit = new boolean[R][C];
        q.add(start[startIdx]);
        visit[start[startIdx].r][start[startIdx].c] = true;

        while (!q.isEmpty()) {
            Point curr = q.poll();

            if (curr.d >= dist[startIdx]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    Point np = new Point(nr, nc, curr.d + 1);

                    if (wallMap[nr][nc] > 0) {
                        int gap = dist[startIdx] - curr.d - 1 - wallDist[wallMap[nr][nc]];
                        if (gap > 0) {
                            valueOfWall += gap;
                        }
                        continue;
                    }

                    if (wallMap[nr][nc] == 0) {
                        q.add(np);
                    }

                }
            }
        }
    }

    private static class Point {
        int r;
        int c;
        int d;

        public Point(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}
