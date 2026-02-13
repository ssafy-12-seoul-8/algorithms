import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] pow = new boolean[(int)(max - min +  1)];

        int m = (int) Math.sqrt(max);
        for (int i = 2; i <= m; i++) {
            long sqrt = (long) i * i;
            long start = ((min + sqrt - 1) / sqrt) * sqrt - min;
            for (int j = 0; start + sqrt * j < pow.length; j++) {
                pow[(int) (start + sqrt * j)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < pow.length; i++) {
            if (!pow[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
