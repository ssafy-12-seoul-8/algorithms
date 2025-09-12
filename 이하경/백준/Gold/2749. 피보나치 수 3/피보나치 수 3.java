import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        int q = (int) (n % 1_500_000);

        int[] fivo = new int[q + 1];

        fivo[1] = 1;

        for (int i = 2; i <= q; i++) {
            fivo[i] = (fivo[i - 2] + fivo[i - 1]) % 1_000_000;
        }

        System.out.println(fivo[q]);
    }
}
