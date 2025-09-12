import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        BigInteger[] fivo = new BigInteger[n + 2];

        fivo[0] = BigInteger.ZERO;
        fivo[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            fivo[i] = fivo[i - 2].add(fivo[i - 1]);
        }

        System.out.println(fivo[n]);
    }
}
