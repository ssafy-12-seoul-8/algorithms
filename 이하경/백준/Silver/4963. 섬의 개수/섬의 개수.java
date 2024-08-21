import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
    static int h, w;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        while (w != 0 && h != 0) {
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        map[i][j] = 0;
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == 1) {
                map[nx][ny] = 0;
                dfs(nx, ny);
            }
        }
    }
}
