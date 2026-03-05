import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tree = new int[n * 4];
        init(0, n - 1, 1);

        int m = Integer.parseInt(br.readLine());
        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                update(0, n - 1, 1, i - 1, j);
                continue;
            }

            sb.append(minIdx(0, n - 1, 1, i - 1, j - 1) + 1).append("\n");
        }

        System.out.println(sb);
    }

    static int init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = start;
        }

        int mid = (start + end) / 2;
        int left = init(start, mid, node * 2);
        int right = init(mid + 1, end, node * 2 + 1);
        if (arr[left] <= arr[right]) {
            return tree[node] = left;
        }
        return tree[node] = right;
    }

    static int update(int start, int end, int node, int index, int value) {
        if (start > index || end < index) {
            return tree[node];
        }

        if (start == end) {
            arr[index] = value;
            return index;
        }

        int mid = (start + end) / 2;
        int left = update(start, mid, node * 2, index, value);
        int right = update(mid + 1, end, node * 2 + 1, index, value);

        if (left == -1) {
            return tree[node] = right;
        }
        if (right == -1) {
            return tree[node] = left;
        }
        if (arr[left] <= arr[right]) {
            return tree[node] = left;
        }
        return tree[node] = right;
    }

    static int minIdx(int start, int end, int node, int left, int right) {
        if (right < start || left > end) {
            return -1;
        }

        if (left <= start && right >= end) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        int leftC = minIdx(start, mid, node * 2, left, right);
        int rightC = minIdx(mid + 1, end, node * 2 + 1, left, right);

        if (leftC == -1) {
            return rightC;
        }
        if (rightC == -1) {
            return leftC;
        }
        if (arr[leftC] <= arr[rightC]) {
            return leftC;
        }
        return rightC;
    }
}
