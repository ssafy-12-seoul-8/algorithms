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
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dist = new int[100_001];
        Arrays.fill(dist, -1);

        if (N == K) {
            sb.append(0).append("\n").append(1);
            System.out.println(sb);
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        dist[N] = 0;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int X = curr[0];
            int t = curr[1];

            if (dist[X] == -1) {
                dist[X] = t;
            }

            if (dist[X] != -1) {
                if (t > dist[X]) {
                    continue;
                }
            }

            if (X == K) {
                cnt++;
                continue;
            }

            if (X == 0) {
                queue.add(new int[]{1, t + 1});
                continue;
            }

            if (X > K) {
                queue.add(new int[]{X - 1, t + 1});
                continue;
            }

            if (X * 2 <= 100_000) {
                queue.add(new int[]{X * 2, t + 1});
            }

            queue.add(new int[]{X - 1, t + 1});
            queue.add(new int[]{X + 1, t + 1});
        }

        sb.append(dist[K]).append("\n").append(cnt);
        System.out.println(sb);
    }
}