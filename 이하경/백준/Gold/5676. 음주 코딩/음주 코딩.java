import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        while (input != null) {
            st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] arr = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] tree = new int[n * 4];
            init(arr, tree, 1, 1, n);

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int idx = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());

                if (cmd.equals("C")) {
                    update(tree, 1, idx, num, 1, n);
                    continue;
                }

                sb.append(getSignChar(multiply(tree, 1, 1, n, idx, num)));
            }
            sb.append("\n");

            input = br.readLine();
        }
        System.out.println(sb);
    }

    public static int getSign(int number) {
        return Integer.compare(number, 0);
    }

    public static char getSignChar(int number) {
        if (number == 0) {
            return '0';
        }

        if (number > 0) {
            return '+';
        }

        return '-';
    }

    public static int getMid(int start, int end) {
        return (start + end) / 2;
    }

    public static int init(int[] arr, int[] tree, int node, int start, int end) {
        if (start == end) {
            return tree[node] = getSign(arr[start]);
        }

        int mid = getMid(start, end);
        return tree[node] = init(arr, tree, node * 2, start, mid) * init(arr, tree, node * 2 + 1, mid + 1, end);
    }

    public static int multiply(int[] tree, int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return 1;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = getMid(start, end);
        return multiply(tree, node * 2, start, mid, left, right) * multiply(tree, node * 2 + 1, mid + 1, end, left, right);
    }

    public static int update(int[] tree, int node, int changeIdx, int changeVal, int start, int end) {
        if (changeIdx < start || changeIdx > end) {
            return tree[node];
        }

        if (start == end) {
            return tree[node] = getSign(changeVal);
        }

        int mid = getMid(start, end);
        return tree[node] = update(tree, node * 2, changeIdx, changeVal, start, mid) * update(tree, node * 2 + 1, changeIdx, changeVal, mid + 1, end);
    }
}
