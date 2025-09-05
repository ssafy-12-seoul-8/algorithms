import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static int N;
    public static boolean[] visited;
    public static int[][] scale;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        scale = new int[N + 1][N + 1];
        int mid = (N + 1) / 2;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());
            scale[heavy][light] = 1;
            scale[light][heavy] = -1;
        }

        int marble = 0;

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            int heavyCnt = dfs(i, 1);
            int lightCnt = dfs(i, -1);

            if (Math.max(heavyCnt, lightCnt) >= mid) {
                marble++;
            }
        }

        System.out.println(marble);
    }

    public static int dfs(int curr, int type) {
        visited[curr] = true;
        int cnt = 0;

        for (int next = 1; next <= N; next++) {
            if (!visited[next] && scale[curr][next] == type) {
                cnt += 1 + dfs(next, type);
            }
        }

        return cnt;
    }
}