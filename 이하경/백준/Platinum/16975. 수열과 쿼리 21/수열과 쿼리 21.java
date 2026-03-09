import java.io.*;
import java.util.*;

public class Main {
    static long[] arr;
    static long[] lazy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = new long[n];
        lazy = new long[n * 4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            if (query == 1) {
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                int diff = Integer.parseInt(st.nextToken());
                updateRange(0, n - 1, 1, left - 1, right - 1, diff);
                continue;
            }
            int x = Integer.parseInt(st.nextToken());
            query(0, n - 1, 1, x - 1);
            sb.append(arr[x - 1]).append("\n");
        }
        System.out.println(sb);
    }

    static void updateLazy(int start, int end, int node) {
        if (lazy[node] == 0) {
            return;
        }

        if (start == end) {
            arr[start] += lazy[node];
        } else {
            lazy[node * 2] += lazy[node];
            lazy[node * 2 + 1] += lazy[node];
        }
        lazy[node] = 0;
    }

    static void updateRange(int start, int end, int node, int left, int right, int diff) {
        if (start > right || end < left) {
            return;
        }
        if (start >= left && end <= right) {
            lazy[node] += diff;
            return;
        }
        int mid = (start + end) / 2;
        updateRange(start, mid, node * 2, left, right, diff);
        updateRange(mid + 1, end, node * 2 + 1, left, right, diff);
    }

    static void query(int start, int end, int node, int index) {
        updateLazy(start, end, node);

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        if (index <= mid) {
            query(start, mid, node * 2, index);
        } else {
            query(mid + 1, end, node * 2 + 1, index);
        }
    }
}
