import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(cnt);
    }

    public static void dfs(int i, int j) {
        map[i][j] = 0;

        for (int d = 0; d < 8; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}
