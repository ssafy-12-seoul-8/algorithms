import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] friendCost = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            friendCost[i] = Integer.parseInt(st.nextToken());
        }

        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            union(v, w, p, friendCost);
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int pi = find(i, p);
            sum += friendCost[pi];
            friendCost[pi] = 0;
        }

        System.out.println(sum <= k ? sum : "Oh no");
    }

    static int find(int x, int[] p) {
        if (p[x] == x) {
            return x;
        }
        return p[x] = find(p[x], p);
    }

    static void union(int x, int y, int[] p, int[] cost) {
        int px = find(x, p);
        int py = find(y, p);

        if (px == py) {
            return;
        }

        p[px] = py;
        cost[px] = cost[py] = Math.min(cost[px], cost[py]);
    }
}