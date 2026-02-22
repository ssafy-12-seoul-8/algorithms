import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int l = Integer.parseInt(br.readLine());
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visit = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());

            q.add(new int[]{x, y, 0});
            visit[x][y] = true;

            while (!q.isEmpty()) {
                int[] curr = q.poll();

                if (curr[0] == tx && curr[1] == ty) {
                    sb.append(curr[2]).append("\n");
                    break;
                }

                for (int d = 0; d < 8; d++) {
                    int nx = curr[0] + dx[d];
                    int ny = curr[1] + dy[d];

                    if (nx >= 0 && nx < l && ny >= 0 && ny < l && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        q.add(new int[]{ nx, ny, curr[2] + 1 });
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
