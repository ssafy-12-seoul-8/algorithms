import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] box = new int[N][M];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int d = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] t = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = t[0] + dr[i];
                int nc = t[1] + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && box[nr][nc] == 0) {
                    q.add(new int[]{nr, nc, t[2] + 1});
                    box[nr][nc] = 1;
                    d = t[2] + 1;
                }
            }
        }

        one: for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    d = -1;
                    break one;
                }
            }
        }

        System.out.println(d);
    }
}