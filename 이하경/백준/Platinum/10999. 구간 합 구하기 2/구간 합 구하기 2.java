import java.io.*;
import java.util.*;

public class Main {
    static long[] arr;
    static long[] tree;
    static long[] lazy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n];
        tree = new long[n * 4];
        lazy = new long[n * 4];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        init(0, n - 1, 1);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                long d = Long.parseLong(st.nextToken());
                updateRange(0, n - 1, 1, b - 1, c - 1, d);
                continue;
            }
            sb.append(sum(0, n - 1, 1, b - 1, c - 1)).append("\n");
        }

        System.out.println(sb);
    }

    static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    static void updateLazy(int start, int end, int node) {
        if (lazy[node] == 0) {
            return;
        }

        tree[node] += (end - start + 1) * lazy[node];
        if (start == end) {
            lazy[node] = 0;
            return;
        }

        lazy[node * 2] += lazy[node];
        lazy[node * 2 + 1] += lazy[node];
        lazy[node] = 0;
    }

    static void updateRange(int start, int end, int node, int left, int right, long diff) {
        updateLazy(start, end, node);
        if (start > right || end < left) {
            return;
        }

        if (start == end) {
            tree[node] += diff;
            return;
        }

        if (start >= left && end <= right) {
            tree[node] += (end - start + 1) * diff;
            lazy[node * 2] += diff;
            lazy[node * 2 + 1] += diff;
            return;
        }

        int mid = (start + end) / 2;
        updateRange(start, mid, node * 2, left, right, diff);
        updateRange(mid + 1, end, node * 2 + 1, left, right, diff);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long sum(int start, int end, int node, int left, int right) {
        updateLazy(start, end, node);
        if (start > right || end < left) {
            return 0;
        }

        if (start >= left && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }
}
