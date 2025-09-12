import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int mod = 1_000_000_007;

        if (n <= 1) {
            System.out.println(n);
            return;
        }

        long a = 0;
        long b = 1;
        long mask = Long.highestOneBit(n) >> 1;

        while (mask > 0) {
            long na = ((a * a) % mod + (b * b) % mod) % mod;
            long nb = b * ((b + (2 * a) % mod) % mod) % mod;
            a = na;
            b = nb;

            if ((n & mask) != 0) {
                long tmp = (a + b) % mod;
                a = b;
                b = tmp;
            }

            mask >>= 1;
        }

        System.out.println(b);
    }
}