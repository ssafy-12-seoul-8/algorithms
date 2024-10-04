import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == 1 && m == 1) {
            System.out.println(1);
            return;
        }

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        Queue<Point> q = new LinkedList<>();
        int[][] visit = new int[n][m]; // 벽을 몇개 부쉈을때 방문했는지 -> 벽을 적게부수고 일찍 갈수있는곳이면 갈필요 x
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit[i], 11);
        }
        q.add(new Point(0, 0, 1, 0));
        visit[0][0] = 0;

        while (!q.isEmpty()) {
            Point curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (nx == n - 1 && ny == m - 1) {
                        System.out.println(curr.dist + 1);
                        return;
                    }

                    int nextDest = curr.destroy + map[nx][ny];

                    if (nextDest <= k && visit[nx][ny] > nextDest) { // 이번에 넣을 값보다 큰 경우만 갱신
                        visit[nx][ny] = nextDest;
                        q.add(new Point(nx, ny, curr.dist + 1, nextDest));
                    }
                }
            }
        }

        System.out.println(-1);
    }

    static class Point {
        int x, y, dist, destroy;

        public Point(int x, int y, int dist, int destroy) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.destroy = destroy;
        }
    }
}
