import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] cows;
    static long[] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        cows = new int[n];
        for (int i = 0; i < n; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        memo = new long[n];
        System.out.println(search(0, n - 1));

    }

    // isMin이 되는 곳을 찾는다
    public static long search(int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int minCheck = isMin(mid);
            if (minCheck == 0) {
                return calcTime(mid);
            }
            if (minCheck > 0) { // 오름차순이면 최소는 왼쪽에 있다
                end = mid - 1;
                continue;
            }
            // 내림차순이면 최소는 오른쪽에 있다
            start = mid + 1;
        }
        return -1;
    }

    // 0이면 최소, 1이면 증가, -1이면 감소
    public static int isMin(int idx) {
        if (idx == 0 || calcTime(idx - 1) >= calcTime(idx)) { // 왼쪽이 더 크면
            if (idx == n - 1 || calcTime(idx + 1) >= calcTime(idx)) { // 오른쪽이 더 크면
                return 0;
            }
            return -1;
        }
        return 1;
    }

    // 300,000개가 모두 500,000이라면 최대 500,000 * 300,000
    public static long calcTime(int idx) {
        if (memo[idx] == 0) {
            long max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, (long) cows[i] * Math.abs(i - idx));
            }
            memo[idx] = max;
        }
        return memo[idx];
    }
}
