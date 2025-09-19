import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static ArrayList<Integer>[] pre;
    public static int[] D;
    public static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            D = new int[N + 1];
            memo = new int[N + 1];
            Arrays.fill(memo, -1);
            pre = new ArrayList[N + 1];
            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                pre[i] = new ArrayList<>();
                D[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                pre[Y].add(X);
            }

            int W = Integer.parseInt(br.readLine());
            int time = dp(W);
            sb.append(time == -1 ? 0 : time).append("\n");
        }

        System.out.println(sb);
    }

    public static int dp(int target) {
        if (memo[target] != -1) {
            return memo[target];
        }

        int max = 0;

        for (int build : pre[target]) {
            max = Math.max(max, dp(build));
        }

        return memo[target] = max + D[target];
    }
}