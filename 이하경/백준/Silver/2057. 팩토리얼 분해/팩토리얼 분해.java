import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long[] factorial = {
                1L,
                1L,
                2L,
                6L,
                24L,
                120L,
                720L,
                5040L,
                40320L,
                362880L,
                3628800L,
                39916800L,
                479001600L,
                6227020800L,
                87178291200L,
                1307674368000L,
                20922789888000L,
                355687428096000L,
                6402373705728000L,
                121645100408832000L
        };

        if (n == 0) {
            System.out.println("NO");
            return;
        }

        boolean possible = false;
        for (int i = 19; i >= 0; i--) {
            if (n >= factorial[i]) {
                n -= factorial[i];
            }
            if (n == 0) {
                possible = true;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
    }
}