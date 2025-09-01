import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] dl = {1, -1, 0, 0, 0, 0};
        int[] dr = {0, 0, 1, -1, 0, 0};
        int[] dc = {0, 0, 0, 0, 1, -1};

        boolean test = true;

        one: while (true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (L == 0) {
                break;
            }

            String[][][] building = new String[L][R][C];
            boolean flag = false;
            int sl = 0;
            int sr = 0;
            int sc = 0;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    building[i][j] = br.readLine().split("");
                }

                if (!flag) {
                    for (int j = 0; j < R; j++) {
                        for (int k = 0; k < C; k++) {
                            if (building[i][j][k].equals("S")) {
                                sl = i;
                                sr = j;
                                sc = k;
                                flag = true;
                            }
                        }
                    }
                }

                br.readLine();
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {sl, sr, sc, 0});
            building[sl][sr][sc] = "#";

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int cl = curr[0];
                int cr = curr[1];
                int cc = curr[2];
                int ct = curr[3];

                for (int d = 0; d < 6; d++) {
                    int nl = cl + dl[d];
                    int nr = cr + dr[d];
                    int nc = cc + dc[d];

                    if (nl >= 0 && nl < L && nr >= 0 && nr < R && nc >= 0 && nc < C && !building[nl][nr][nc].equals("#")) {
                        if (building[nl][nr][nc].equals("E")) {
                            sb.append("Escaped in ").append(ct + 1).append(" minute(s).\n");
                            continue one;
                        }

                        queue.add(new int[] {nl, nr, nc, ct + 1});
                        building[nl][nr][nc] = "#";
                    }
                }
            }

            sb.append("Trapped!\n");
        }

        System.out.println(sb);
    }
}