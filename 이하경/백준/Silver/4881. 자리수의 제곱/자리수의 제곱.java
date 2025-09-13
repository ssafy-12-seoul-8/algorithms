import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 9자리 숫자의 자리수의 제곱의 합은 최대 9*9*9 = 729
// 처음 숫자가 같은경우 2, 아닌경우 모두 세자리수 이내로 나옴

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0) {
                break;
            }

            int[] used1 = new int[1000];
            int[] used2 = new int[1000];

            if (a == b) {
                sb.append(a).append(" ").append(b).append(" ").append(2).append("\n");
                continue;
            }

            int count = 1;
            int next = a;

            if (a >= 1000) {
                count++;
                next = digitPow(a);
            }

            while (used1[next] == 0) {
                used1[next] = count++;
                next = digitPow(next);
            }

            int min = Integer.MAX_VALUE;

            count = 1;
            next = b;

            if (b >= 1000) {
                count++;
                next = digitPow(b);
            }

            while (used2[next] == 0) {
                used2[next] = count++;

                if (used1[next] != 0) {
                    min = Math.min(min, used1[next] + used2[next]);
                }

                next = digitPow(next);
            }

            sb.append(a).append(" ").append(b).append(" ").append(min == Integer.MAX_VALUE ? 0 : min).append("\n");
        }

        System.out.println(sb);
    }

    public static int digitPow(int n) {
        int ret = 0;

        while (n > 0) {
            int k = n % 10;
            ret += k * k;
            n /= 10;
        }

        return ret;
    }
}
