import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] cntNum; // i자리 이하 이진수의 개수 (2^i)
    static long[] cntOne; // i자리 이하 이진수의 1의 개수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        init();
        System.out.println(countOne(b) - countOne(a - 1));
    }

    static void init() {
        cntNum = new long[58];
        cntOne = new long[58];
        cntNum[0] = 1;
        cntOne[0] = 0;
        for (int i = 1; i <= 57; i++) {
            cntNum[i] = cntNum[i - 1] << 1;
            cntOne[i] = 2 * cntOne[i - 1] + cntNum[i - 1];
        }
    }

    // 1~x까지 모든 수의 1의 개수 세기
    public static long countOne(long x) {
        long ans = 0;
        int digit = 0;
        while (x >= cntNum[digit]) { // 몇 자리 이진수인지 알고싶어..
            digit++;
        }

        int frontOne = 0;
        for (int i = digit; i > 0; i--) { // i번째 자리 확인
            if ((x & cntNum[i - 1]) != 0) { // 자릿수가 1인 경우
                ans += frontOne*cntNum[i - 1] + cntOne[i - 1];
                frontOne++;
            }
        }

        ans += frontOne;
        return ans;
    }
}
