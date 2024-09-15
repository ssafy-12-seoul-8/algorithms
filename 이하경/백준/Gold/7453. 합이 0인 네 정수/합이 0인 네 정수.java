import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// n <= 4000, 시간제한 12초 -> n^3 풀이는 불가능
// 두개씩 더해서 정렬하고 다른거 두개 더해서 이분탐색
// 두개씩 더하는데 n^2 (1번), 정렬 n^2logn(1번), 나머지 두개 더하기 n^2번, 다른쪽에서 찾기 2logn
// 메모리는 16,000,000 * 4 = 64mb

public class Main {
    static int n;
    static int[] ab;
    static int[][] abcd;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    static void input() throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        abcd = new int[4][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                abcd[j][i] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() throws Exception {
        makeAB();
        long cnt = 0; // 최대 개수는 4000^4 = 256e12
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt += find(-abcd[2][i] - abcd[3][j]);
            }
        }
        System.out.println(cnt);
    }

    static void makeAB() {
        ab = new int[n * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[i * n + j] = abcd[0][i] + abcd[1][j];
            }
        }
        Arrays.sort(ab);
    }

    // 일치하는 ab가 여러개인 경우 그만큼 더해줘야함
    static int find(int target) throws Exception {
        int start = 0;
        int end = n * n;

        int repeat = 0;
        // mid >= target인 최소 인덱스 찾기
        while (start < end) {
            repeat++;
            if(repeat >= 30) {
                throw new Exception("저 무한루프 돌아요?");
            }
            int mid = (start + end) / 2;
            if (ab[mid] >= target) { // mid가 target보다 크거나같으면 정답은 mid포함 작은쪽
                end = mid;
                continue;
            }
            // mid가 target보다 작으면 정답은 mid보다 큰쪽에
            start = mid + 1;
        }
        int lowerBound = start;

        start = 0;
        end = n * n;

        repeat = 0;
        // mid > target인 최소 인덱스 찾기
        while (start < end) {
            repeat++;
            if(repeat >= 30) {
                throw new Exception("저 무한루프 돌아요?");
            }
            int mid = (start + end) / 2;
            if (ab[mid] <= target) { // mid가 target보다 작거나 같으면 정답은 mid보다 큰쪽
                start = mid + 1;
                continue;
            }
            // mid가 target보다 크면 정답은 mid 포함 작은쪽
            end = mid;
        }
        int upperBound = start;

        return upperBound - lowerBound;
    }
}
