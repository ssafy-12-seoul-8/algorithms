import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] need;
    static int[] memo, delay;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            delay = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                delay[i] = Integer.parseInt(st.nextToken());
            }

            need = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                need[i] = new ArrayList<>();
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                need[y].add(x);
            }

            memo = new int[n + 1];
            Arrays.fill(memo, -1);

            int w = Integer.parseInt(br.readLine());
            sb.append(time(w)).append("\n");
        }
        System.out.println(sb);
    }

    // k를 짓는데 걸리는 시간, 최대 1000 * 100,000
    static int time(int k) {
        if (memo[k] >= 0) {
            return memo[k];
        }

        int maxTime = 0;
        for (int prev : need[k]) {
            maxTime = Math.max(maxTime, time(prev));
        }
        return memo[k] = maxTime + delay[k];
    }
}
