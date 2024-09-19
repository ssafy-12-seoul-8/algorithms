import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] visit = new int[100_001];
        q.add(n);
        visit[n] = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();

            int next = curr * 2;
            while (next <= 100_000 && visit[next] == 0) {
                if (next == k) {
                    System.out.println(visit[curr] - 1);
                    return;
                }
                visit[next] = visit[curr];
                q.add(next);
                next *= 2;
            }

            if (curr > 0) {
                next = curr - 1;
                if (next == k) {
                    System.out.println(visit[curr]);
                    return;
                }
                if (visit[next] == 0) {
                    visit[next] = visit[curr] + 1;
                    q.add(next);
                }
            }

            if (curr < 100_000) {
                next = curr + 1;
                if (next == k) {
                    System.out.println(visit[curr]);
                    return;
                }
                if (visit[next] == 0) {
                    visit[next] = visit[curr] + 1;
                    q.add(next);
                }
            }
        }
    }
}
