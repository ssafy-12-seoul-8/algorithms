import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n < 0) {
            n = Math.abs(n);
            System.out.println(n % 2 == 0 ? -1 : 1);
        } else if (n == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        } else {
            System.out.println(1);
        }

        int[] fibo = new int[n + 1];
        fibo[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1_000_000_000;
        }

        System.out.println(fibo[n]);
    }
}
