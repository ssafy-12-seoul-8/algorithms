import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] nums;
    static SegTree tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        tree = new SegTree();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] minMax = tree.getMinMax(0, n - 1, 1, a - 1, b - 1);
            sb.append(minMax[0]).append(" ").append(minMax[1]).append("\n");
        }

        System.out.println(sb);
    }

    private static class SegTree {
        private int[] minTree;
        private int[] maxTree;

        public SegTree() {
            minTree = new int[4 * n];
            maxTree = new int[4 * n];
            init(0, n - 1, 1);
        }

        private void init(int start, int end, int node) {
            if (start == end) {
                minTree[node] = nums[start];
                maxTree[node] = nums[start];
                return;
            }

            int mid = (start + end) / 2;
            init(start, mid, node * 2);
            init(mid + 1, end, node * 2 + 1);
            minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
            maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
        }

        private int[] getMinMax(int start, int end, int node, int left, int right) {
            if (right < start || left > end) {
                return new int[]{ 1_000_000_000, 0 };
            }

            if (left <= start && right >= end) {
                return new int[]{ minTree[node], maxTree[node] };
            }

            int mid = (start + end) / 2;
            int[] leftMinMax = getMinMax(start, mid, node * 2, left, right);
            int[] rightMinMax = getMinMax(mid + 1, end, node * 2 + 1, left, right);
            return new int[]{ Math.min(leftMinMax[0], rightMinMax[0]), Math.max(leftMinMax[1], rightMinMax[1])};
        }
    }
}
