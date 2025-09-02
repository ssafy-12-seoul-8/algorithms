import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static int minChickDist = Integer.MAX_VALUE;
    public static int M;
    public static int houseCnt;
    public static int chickCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] chick = new int[13][2];
        int[][] house = new int[2 * N][2];
        houseCnt = 0;
        chickCnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int type = Integer.parseInt(st.nextToken());

                if (type == 1) {
                    house[houseCnt++] = new int[] {i, j};
                }

                if (type == 2) {
                    chick[chickCnt++] = new int[] {i, j};
                }
            }
        }

        int[][] dist = new int[houseCnt][chickCnt];

        for (int i = 0; i < houseCnt; i++) {
            for (int j = 0; j < chickCnt; j++) {
                dist[i][j] = Math.abs(house[i][0] - chick[j][0]) + Math.abs(house[i][1] - chick[j][1]);
            }
        }

        findMinChickDist(0, 0, -1, dist);

        System.out.println(minChickDist);
    }

    public static void findMinChickDist(int cnt, int mask, int prev, int[][] dist) {
        if (cnt == M) {
            int chickDist = 0;

            for (int i = 0; i < houseCnt; i++) {
                int min = Integer.MAX_VALUE;

                for (int j = 0; j < chickCnt; j++) {
                    if ((mask & (1 << j)) == 0) {
                        continue;
                    }

                    min = Math.min(min, dist[i][j]);
                }

                chickDist += min;
            }

            minChickDist = Math.min(minChickDist, chickDist);
        }

        for (int i = prev + 1; i < chickCnt; i++) {
            if (cnt + chickCnt - i < M) {
                return;
            }

            findMinChickDist(cnt + 1, mask | (1 << i), i, dist);
        }
    }
}