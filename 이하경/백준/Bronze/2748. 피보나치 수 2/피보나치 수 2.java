import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

// 90번째 피보나치수의 크기
// 피보나치수는 2의 n제곱보다 작음 따라서 2의 90제곱 미만

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        BigInteger[] fivo = new BigInteger[n + 1];

        fivo[0] = BigInteger.ZERO;
        fivo[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            fivo[i] = fivo[i - 2].add(fivo[i - 1]);
        }

        System.out.println(fivo[n]);
    }
}
