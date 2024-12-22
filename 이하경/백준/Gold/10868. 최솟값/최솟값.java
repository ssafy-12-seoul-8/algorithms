import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] segTree = new int[(int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)) + 1)];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(arr, segTree, 1, 1, n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(findMin(segTree, 1, 1, n, a, b)).append("\n");
        }

        System.out.println(sb);
    }

    // idx는 탐색하려는 트리의 인덱스, start와 end는 segtree를 만들려는 구간
    public static int init(int[] arr, int[] tree, int idx, int start, int end) {
        if (start == end) {
            return tree[idx] = arr[start];
        }

        return tree[idx] = Math.min(init(arr, tree, idx * 2, start, (start + end) / 2), init(arr, tree, idx * 2 + 1, (start + end) / 2 + 1, end));
    }

    // start와 end는 현재 idx가 포함하는 구간, left와 right는 찾으려는 구간
    public static int findMin(int[] tree, int idx, int start, int end, int left, int right) {
        if (end < left || start > right) {
            return Integer.MAX_VALUE;
        }

        if (left <= start && right >= end) {
            return tree[idx];
        }

        return Math.min(findMin(tree, idx * 2, start, (start + end) / 2, left, right), findMin(tree, idx * 2 + 1, (start + end) / 2 + 1, end, left, right));
    }
}
