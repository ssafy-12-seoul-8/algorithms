import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int[] dx = {-1, -1, 1, 1, -2, -2, 2, 2};
        int[] dy = {2, -2, -2, 2, 1, -1, -1, 1};

        for (int tc = 0; tc < t; tc++) {
            int l = Integer.parseInt(br.readLine());
            boolean[][] field = new boolean[l][l];
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            field[sx][sy] = true;
            st = new StringTokenizer(br.readLine());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] {sx, sy, 0});

            while (!q.isEmpty()) {
                int[] curr = q.poll();

                if (curr[0] == ex && curr[1] == ey) {
                    sb.append(curr[2]).append("\n");
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int nx = curr[0] + dx[i];
                    int ny = curr[1] + dy[i];

                    if (nx >= 0 && nx < l && ny >= 0 && ny < l && !field[nx][ny]) {
                        field[nx][ny] = true;
                        q.add(new int[]{nx, ny, curr[2] + 1});
                    }
                }
            }
        }

        System.out.println(sb);
    }
}