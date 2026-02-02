import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] forest;
    static int[][] move;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        forest = new int[n][n];
        move = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(new int[]{ i, j, forest[i][j]});
            }
        }

        int max = 1;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int tmp = 0;
            for (int d = 0; d < 4; d++) {
                int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && forest[nx][ny] < forest[curr[0]][curr[1]]) {
                    tmp = Math.max(tmp, move[nx][ny]);
                }
            }

            move[curr[0]][curr[1]] = tmp + 1;
            max = Math.max(max, move[curr[0]][curr[1]]);
        }

        System.out.println(max);
    }
}
