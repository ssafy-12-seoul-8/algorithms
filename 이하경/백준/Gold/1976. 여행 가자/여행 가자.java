import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }

        // 연결된 도시끼리 union
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                String connect = st.nextToken();
                if (connect.equals("1")) {
                    union(i, j, p);
                }
            }
        }

        boolean possible = true;
        st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        int parent = find(prev, p);
        while (st.hasMoreTokens()) {
            int next = Integer.parseInt(st.nextToken());
            if (parent != find(next, p)) {
                possible = false;
                break;
            }
            prev = next;
        }

        System.out.println(possible ? "YES" : "NO");

    }

    static void union(int x, int y, int[] p) {
        int px = find(x, p);
        int py = find(y, p);

        if (px < py) {
            p[py] = px;
            return;
        }

        p[px] = py;
    }

    static int find(int x, int[] p) {
        if (p[x] != x) {
            p[x] = find(p[x], p);
        }
        return p[x];
    }
}
