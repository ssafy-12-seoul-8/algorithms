import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String isbn = br.readLine();

        int sum = 0;
        boolean even = false;

        for (int i = 0; i < isbn.length(); i++) {
            int num = isbn.charAt(i) - '0';

            if (num < 0) {

                if (i % 2 == 1) {
                    even = true;
                }

                continue;
            }

            sum += num;

            if (i % 2 == 1) {
                sum += num * 2;
            }
        }

        int ans = 10 - sum % 10;

        if (even) {
            for (int i = 0; i < 10; i++) {
                if ((sum + i * 3) % 10 == 0) {
                    ans = i;
                }
            }
        }

        System.out.println(ans);
    }
}