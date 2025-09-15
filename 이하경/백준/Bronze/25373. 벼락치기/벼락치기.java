import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        if (n <= 28) {
            int i = 1;
            int add = 1;

            while (add < n) {
                i += 1;
                add += i;
            }

            System.out.println(i);
            return;
        }

        System.out.println((n - 29) / 7 + 8);
    }
}
