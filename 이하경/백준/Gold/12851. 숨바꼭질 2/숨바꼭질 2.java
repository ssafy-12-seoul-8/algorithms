import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dist = new int[100_001];
        int[] count = new int[100_001];
        dist[n] = 1;
        count[n] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        int currDist = 1;
        while (!q.isEmpty()) {
            int curr = q.poll();

            if (dist[curr] > currDist) {
                currDist = dist[curr];
                if (dist[k] != 0) {
                    break;
                }
            }

            for (int next : move(curr)) {
                if (next >= 0 && next <= 100_000) {
                    if (dist[next] == 0) {
                        dist[next] = dist[curr] + 1;
                        count[next] += count[curr];
                        q.offer(next);
                        continue;
                    }

                    if (dist[next] == dist[curr] + 1) {
                        count[next] += count[curr];
                    }
                }
            }
        }

        sb.append(dist[k] - 1).append("\n").append(count[k]);
        System.out.println(sb);
    }

    public static int[] move(int n) {
        return new int[]{n + 1, n - 1, n * 2};
    }
}
