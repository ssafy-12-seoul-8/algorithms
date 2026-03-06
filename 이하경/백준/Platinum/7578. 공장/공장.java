import java.io.*;
import java.util.*;

public class Main {
    static int[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] idxA = new int[1_000_001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int idx = Integer.parseInt(st.nextToken());
            idxA[idx] = i;
        }

        tree = new int[n * 4];
        init(0, n - 1, 1);

        long count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            delete(0, n - 1, 1, idxA[num]);
            count += count(0, n - 1, 1, idxA[num]);
        }

        System.out.println(count);
    }

    static int init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = 1;
        }

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    static int delete(int start, int end, int node, int idx) {
        if (idx < start || idx > end) {
            return tree[node];
        }

        if (start == end) {
            return tree[node] = 0;
        }

        int mid = (start + end) / 2;
        return tree[node] = delete(start, mid, node * 2, idx) + delete(mid + 1, end, node * 2 + 1, idx);
    }

    static int count(int start, int end, int node, int right) {
        if (right < start) {
            return 0;
        }

        if (end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return count(start, mid, node * 2, right) + count(mid + 1, end, node * 2 + 1, right);
    }
}
