import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static long[] arr;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        tree = new long[n * 4];
        init(0, n - 1, 0);

        for (int i = 0; i < k + m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(0, n - 1, 0, b - 1, c);
                continue;
            }


            sb.append(sum(0, n - 1, 0, b - 1, (int) c - 1)).append("\n");
        }

        System.out.println(sb);
    }

    // arr의 start에서 end까지의 값이 node번에 들어간다
    static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        // 양쪽 자식의 합이 현재 노드의 값이 된다
        return tree[node] = init(start, mid, node * 2 + 1) + init(mid + 1, end, node * 2 + 2);
    }

    // arr의 start에서 end까지 계산한 결과를 node번에 넣는다
    static long update(int start, int end, int node, int index, long val) {
        if (index < start || index > end) {
            return tree[node];
        }

        if (start == end) {
            return tree[node] = val;
        }

        int mid = (start + end) / 2;

        return tree[node] = update(start, mid, node * 2 + 1, index, val) + update(mid + 1, end, node * 2 + 2, index, val);
    }

    // 현재 구간 [start, end], 구하려는 구간 [left, right]
    static long sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && right >= end) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return sum(start, mid, node * 2 + 1, left, right) + sum(mid + 1, end, node * 2 + 2, left, right);
    }
}
