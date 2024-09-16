import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 누적합 이용 부배열의 합 배열을 만들고 정렬해서 투포인터로
// 각각 배열 원소는 int, 부배열의 개수는 n(n+1)/2 <= 500,000
// 답은 최대 500,000 * 500,000 = 250,000,000,000개
// 배열 원소 다 더하면 1,000,000 * 1,000 = 1,000,000,000 누적합, 부배열의합의합 모두 int

public class Main {
    static int t, n, m;
    static int[] a, b;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        n = Integer.parseInt(br.readLine());
        a = new int[n + 1]; // a, b를 누적합 배열로 받는다
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = a[i - 1] + Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        b = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            b[i] = b[i - 1] + Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int[] subA = makeSubArr(a);
        int[] subB = makeSubArr(b);

        System.out.println(findZero(subA, subB));
    }

    static int[] makeSubArr(int[] arr) {
        int k = arr.length - 1;

        int[] subArr = new int[k * (k + 1) / 2];
        int idx = -1;
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j <= k; j++) {
                // (i, j]
                subArr[++idx] = arr[j] - arr[i];
            }
        }
        Arrays.sort(subArr);

        return subArr;
    }

    static long findZero(int[] subA, int[] subB) {
        int lenA = subA.length;
        int lenB = subB.length;

        int left = 0; // subA의 인덱스
        int right = lenB - 1; // subB의 인덱스

        long cnt = 0;
        while (left < lenA && right >= 0) {
            int sum = subA[left] + subB[right];

            if (sum < t) {
                left++;
                continue;
            }
            
            if (sum > t) {
                right--;
                continue;
            }

            int leftVal = subA[left];
            long leftCnt = 0;
            while (left < lenA && leftVal == subA[left]) {
                left++;
                leftCnt++;
            }
            int rightVal = subB[right];
            long rightCnt = 0;
            while (right >= 0 && rightVal == subB[right]) {
                right--;
                rightCnt++;
            }
            cnt += leftCnt * rightCnt;
        }
        return cnt;
    }
}
