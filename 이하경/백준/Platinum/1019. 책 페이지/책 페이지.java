import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] count = new int[10];

        int digit = 0;
        int tmp = n;
        while (tmp > 0) {
            tmp /= 10;
            digit++;
        }

        int[] num = new int[digit];
        for (int i = 0; i < digit; i++) {
            num[i] = n % 10;
            n /= 10;
        }

        for (int i = 0; i < digit; i++) {
            int div = (int) Math.pow(10, i);
            int max = 0;
            for (int j = digit - 1; j >= 0; j--) {
                if (i == j) {
                    continue;
                }
                max *= 10;
                max += num[j];
            }
            if (num[i]!= 0) {
                count[0] += (max / div) * div;
                count[num[i]] += (max + 1);
            } else {
                count[0] += (max - div + 1);
            }
            for (int j = 1; j < num[i]; j++) {
                count[j] += (max / div + 1) * div;
            }
            for (int j = num[i] + 1; j <= 9; j++) {
                count[j] += (max / div) * div;
            }
        }

        for (int i = 0; i < 10; i++) {
            sb.append(count[i]).append(" ");
        }

        System.out.println(sb);
    }
}
