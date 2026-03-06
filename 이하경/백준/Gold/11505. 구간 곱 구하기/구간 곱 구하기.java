import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegTree tree = new SegTree(arr);
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                arr[b - 1] = c;
                tree.update(b - 1, c);
                continue;
            }

            sb.append(tree.getMultiply(b - 1, c - 1)).append(" \n");
        }

        System.out.println(sb);
    }
    private static class SegTree {
        int n;
        long[] tree;
        long DIV = 1_000_000_007;

        SegTree(int[] arr) {
            n = arr.length;
            tree = new long[n * 4];
            buildTree(0, n - 1, 1, arr);
        }

        void update(int index, int value) {
            recursiveUpdate(0, n - 1, 1, index, value);
        }

        long getMultiply(int left, int right) {
            return recursiveMultiply(0, n - 1, 1, left, right);
        }

        private long buildTree(int start, int end, int node, int[] arr) {
            if (start == end) {
                return tree[node] = arr[start];
            }

            int mid = (start + end) / 2;
            return tree[node] = (buildTree(start, mid, node * 2, arr) * buildTree(mid + 1, end, node * 2 + 1, arr)) % DIV;
        }

        private long recursiveUpdate(int start, int end, int node, int index, int value) {
            if (start > index || end < index) {
                return tree[node];
            }

            if (start == end) {
                return tree[node] = value;
            }

            int mid = (start + end) / 2;
            return tree[node] = (recursiveUpdate(start, mid, node * 2, index, value) * recursiveUpdate(mid + 1, end, node * 2 + 1, index, value)) % DIV;
        }

        private long recursiveMultiply(int start, int end, int node, int left, int right) {
            if (start > right || end < left) {
                return 1;
            }

            if (start >= left && end <= right) {
                return tree[node];
            }

            int mid = (start + end) / 2;
            return (recursiveMultiply(start, mid, node * 2, left, right) * recursiveMultiply(mid + 1, end, node * 2 + 1, left, right)) % DIV;
        }

    }
}
