import java.io.*;
import java.util.*;

public class Main {
    static int[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int FLAVOR = 1_000_001;
        int n = Integer.parseInt(br.readLine());
        tree = new int[4 * FLAVOR];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                sb.append(getCandy(1, FLAVOR - 1, 1, b)).append("\n");
                continue;
            }

            int c = Integer.parseInt(st.nextToken());
            update(1, FLAVOR - 1, 1, b, c);
        }

        System.out.println(sb);
    }

    static int getCandy(int start, int end, int node, int rank) {
        if (start == end) {
            return start;
        }

        int mid = (start + end) / 2;
        if (rank <= tree[node * 2]) {
            int candy = getCandy(start, mid, node * 2, rank);
            tree[node * 2]--;
            return candy;
        }

        int candy = getCandy(mid + 1, end, node * 2 + 1, rank - tree[node * 2]);
        tree[node * 2 + 1]--;
        return candy;
    }

    static void update(int start, int end, int node, int idx, int inc) {
        if (start > idx || end < idx) {
            return;
        }

        tree[node] += inc;

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, inc);
        update(mid + 1, end, node * 2 + 1, idx, inc);
    }
}
