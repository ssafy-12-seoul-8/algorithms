import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String isbn = br.readLine();
        int sum = 0;
        boolean odd = false;

        for (int i = 0; i < isbn.length(); i++) {
            char c = isbn.charAt(i);

            if (c == '*') {
                if (i % 2 != 0) {
                    odd = true;
                }
                continue;
            }

            if (i % 2 == 0) {
                sum += (c - '0');
                continue;
            }
            sum += 3 * (c - '0');
        }

        sum = sum % 10;
        int[] original = { 0, 3, 6, 9, 2, 5, 8, 1, 4, 7 };
        if (odd) {
            System.out.println(original[sum]);
        } else {
            System.out.println(sum == 0 ? 0 : 10 - sum);
        }
    }
}
