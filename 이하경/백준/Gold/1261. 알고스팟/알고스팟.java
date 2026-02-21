import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visit;
    static Queue<int[]> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String inp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = inp.charAt(j) - '0';
            }
        }

        visit = new boolean[n][m];
        q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        visit[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            move(curr[0], curr[1], curr[2]);
        }

    }

    public static void move(int x, int y, int wall) {
        Queue<int[]> moveQ = new LinkedList<>();
        moveQ.add(new int[]{x, y});

        while (!moveQ.isEmpty()) {
            int[] curr = moveQ.poll();

            if (curr[0] == n - 1 && curr[1] == m - 1) {
                System.out.println(wall);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    if (map[nx][ny] == 0) {
                        moveQ.add(new int[]{nx, ny});
                    } else {
                        q.add(new int[]{nx, ny, wall + 1});
                    }
                }

            }
        }

    }
}
