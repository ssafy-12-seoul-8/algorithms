import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int tc = 1; ; tc++) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            int[][] cave = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] cost = new int[N][N];

            for (int i = 0; i < N; i++) {
                Arrays.fill(cost[i], Integer.MAX_VALUE);
            }

            cost[0][0] = cave[0][0];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            pq.add(new int[] {0, 0, cave[0][0]});

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                cost[curr[0]][curr[1]] = curr[2];

                if (curr[0] == N - 1 && curr[1] == N - 1) {
                    System.out.println("Problem " + tc + ": " + curr[2]);
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = curr[0] + dx[d];
                    int ny = curr[1] + dy[d];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || cost[nx][ny] != Integer.MAX_VALUE) {
                        continue;
                    }

                    pq.add(new int[] {nx, ny, curr[2] + cave[nx][ny]});
                }
            }
        }
    }
}