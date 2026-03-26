import java.io.*;
import java.util.*;

public class Main {
    static int[][] want;
    static int[] match;
    static boolean[] visit;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        want = new int[n + 1][];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            want[i] = new int[s];
            for (int j = 0; j < s; j++) {
                want[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        match = new int[m + 1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            visit = new boolean[m + 1];
            if (dfs(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean dfs(int curr) {
        for (int next:want[curr]) {
            if (visit[next]) {
                continue;
            }

            visit[next] = true;
            if (match[next] == 0 || dfs(match[next])) {
                match[next] = curr;
                return true;
            }
        }
        return false;
    }
}
