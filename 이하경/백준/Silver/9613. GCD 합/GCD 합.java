import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            long ans = 0; // 1,000,000 * 10,000 = 10,000,000,000
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    ans += gcd(nums[i], nums[j]);
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static int gcd(int x, int y) {
        if (x % y == 0) { // x가 y의 배수이면
            return y;
        }
        return gcd(y, x % y);
    }
}
