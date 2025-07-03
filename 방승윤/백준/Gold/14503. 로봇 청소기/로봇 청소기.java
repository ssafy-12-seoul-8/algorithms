import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int[][] f = new int[N][M];
        int cnt = 0;

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                f[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        one: while (true) {
            if (f[r][c] == 0) {
                f[r][c] = 2;
                cnt++;
            }

            for (int i = 0; i < 4; i++) {
                if (f[r + dr[i]][c + dc[i]] == 0) {
                    while (true) {
                        if (d == 0) {
                            d = 3;
                        } else {
                            d--;
                        }

                        if (f[r + dr[d]][c + dc[d]] == 0) {
                            r = r + dr[d];
                            c = c + dc[d];
                            continue one;
                        }
                    }
                }
            }

            if (f[r - dr[d]][c - dc[d]] == 1) {
                break;
            }

            r = r - dr[d];
            c = c - dc[d];
        }

        System.out.println(cnt);
    }
}