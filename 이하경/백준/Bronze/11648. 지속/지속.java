import java.io.BufferedReader;
import java.io.InputStreamReader;

// 곱한 숫자는 항상 점점 작아짐
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int step = 0;
        while (n > 9) {
            n = digitMul(n);
            step++;
        }

        System.out.println(step);
    }

    private static int digitMul(int n) {
        int ret = 1;

        while (n > 0) {
            ret *= (n % 10);
            n /= 10;
        }

        return ret;
    }
}
