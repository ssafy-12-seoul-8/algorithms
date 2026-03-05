import java.io.*;
import java.util.*;

public class Main {
    static int[] tree;
    static boolean[] flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        tree = new int[4 * n];
        flag = new boolean[4 * n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            if (o == 0) {
                reverse(1, n, 1, s, t);
                continue;
            }

            sb.append(count(1, n, 1, s, t)).append("\n");
        }

        System.out.println(sb);
    }

    static int reverse(int start, int end, int node, int left, int right) {
        if (right < start || left > end) {
            return 0;
        }

        if (start == end) {
            if (flag[node]) {
                flag[node] = false;
                int tmp = 1 - tree[node];
                return tree[node] - tmp;
            }
            int tmp = tree[node];
            tree[node] = 1 - tree[node];
            return tree[node] - tmp;
        }

        if (start >= left && end <= right) {
            if (flag[node]) {
                flag[node] = false;
                int tmp = end - start + 1 - tree[node];
                return tree[node] - tmp;
            }
            flag[node * 2] = !flag[node * 2];
            flag[node * 2 + 1] = !flag[node * 2 + 1];
            int tmp = tree[node];
            tree[node] = end - start + 1 - tree[node];
            return tree[node] - tmp;
        }

        int mid = (start + end) / 2;

        if (flag[node]) {
            flag[node] = false;
            flag[node * 2] = !flag[node * 2];
            flag[node * 2 + 1] = !flag[node * 2 + 1];
            int tmp = end - start + 1 - tree[node]; // tmp = 기존값
            int lGap = reverse(start, mid, node * 2, left, right);
            int rGap = reverse(mid + 1, end, node * 2 + 1, left, right);

            tree[node] = tmp + lGap + rGap;
            return tree[node] - tmp;
        }

        int lGap = reverse(start, mid, node * 2, left, right);
        int rGap = reverse(mid + 1, end, node * 2 + 1, left, right);

        int tmp = tree[node];
        tree[node] = tmp + lGap + rGap;
        return tree[node] - tmp;
    }

    static int count(int start, int end, int node, int left, int right) {
        if (start > right || end < left) {
            return 0;
        }

        if (start == end) {
            if (flag[node]) {
                flag[node] = false;
                return tree[node] = 1 - tree[node];
            }
            return tree[node];
        }

        if (start >= left && end <= right) {
            if (flag[node]) {
                flag[node] = false;
                flag[node * 2] = !flag[node * 2];
                flag[node * 2 + 1] = !flag[node * 2 + 1];
                return tree[node] = end - start + 1 - tree[node];
            }
            return tree[node];
        }

        int mid = (start + end) / 2;
        if (flag[node]) {
            flag[node] = false;
            flag[node * 2] = !flag[node * 2];
            flag[node * 2 + 1] = !flag[node * 2 + 1];
            tree[node] = end - start + 1 - tree[node];
        }

        return count(start, mid, node * 2, left, right) + count(mid + 1, end, node * 2 + 1, left, right);

    }
}
