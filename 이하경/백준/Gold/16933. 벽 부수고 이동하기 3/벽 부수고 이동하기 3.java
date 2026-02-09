import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };
        int[][] visit = new int[n][m]; // 2의 n제곱 자리는 n번 부수고 방문 여부 => n번 갈지말지 정할때 0~n중에서 방문했는지 체크
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1, 0, true));
        visit[0][0] = 1;

        boolean done = false;
        while (!q.isEmpty()) {
            Point curr = q.poll();

            if (map[curr.x][curr.y] == '1' && curr.day) {
                q.add(new Point(curr.x, curr.y, curr.d + 1, curr.wall, false));
                continue;
            }

            if (curr.x == n - 1 && curr.y == m - 1) {
                done = true;
                System.out.println(curr.d);
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == '1' && curr.wall < k && (((1 << (curr.wall + 1)) - 1) & visit[nx][ny]) == 0) {
                        int wall = curr.wall + 1;
                        visit[nx][ny] |= (1 << (wall));
                        q.add(new Point(nx, ny, curr.d + 1, wall, !curr.day));
                        continue;
                    }
                    if (map[nx][ny] =='0' && (((1 << (curr.wall + 1)) - 1) & visit[nx][ny]) == 0) {
                        visit[nx][ny] |= (1 << curr.wall);
                        q.add(new Point(nx, ny, curr.d + 1, curr.wall, !curr.day));
                    }
                }
            }
        }

        if (!done) {
            System.out.println(-1);
        }
    }

    private static class Point {
        int x;
        int y;
        int d;
        int wall;
        boolean day;

        public Point(int x, int y, int d, int wall, boolean day) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.wall = wall;
            this.day = day;
        }
    }
}
