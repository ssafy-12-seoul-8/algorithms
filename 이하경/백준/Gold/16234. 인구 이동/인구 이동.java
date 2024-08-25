import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visit;
    static ArrayList<Point> open;
    static int sum, cnt, n, l, r;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = -1;
        boolean moved = true;
        while (moved) {
            day++;
            moved = false;
            visit = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visit[i][j]) {
                        continue;
                    }
                    visit[i][j] = true;
                    sum = map[i][j];
                    cnt = 1;
                    open = new ArrayList<>();
                    Point start = new Point(i, j);
                    open.add(start);

                    if (haveToMove(start, map[i][j])){
                        moved = true;
                        move();
                    }
                }
            }
        }

        System.out.println(day);

    }

    static boolean haveToMove(Point p, int pop) {
        boolean ret = false;

        for (int i = 0; i < 4; i++) {
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visit[nx][ny]) {
                int gap = Math.abs(map[nx][ny] - pop);
                if (gap < l || gap > r) {
                    continue;
                }
                visit[nx][ny] = true;
                if (pop != map[nx][ny]) {
                    ret = true;
                }
                sum += map[nx][ny];
                cnt++;
                Point next = new Point(nx, ny);
                open.add(next);
                if(haveToMove(next, map[nx][ny])) {
                    ret = true;
                }
            }
        }

        return ret;
    }

    static void move() {
        int pop = sum / cnt;
        for (Point p : open) {
            map[p.x][p.y] = pop;
        }
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
