import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int min = 50;
        int minIdx = 0;
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
            if (price[i] <= min) {
                minIdx = i;
                min = price[i];
            }
        }

        int m = Integer.parseInt(br.readLine());

        int digit = m / price[minIdx];
        int left = m - price[minIdx] * digit;

        if (minIdx == 0) {
            int nextMin = 50;
            for (int i = 1; i < n; i++) {
                nextMin = Math.min(nextMin, price[i]);
            }

            digit = 1 + (m - nextMin) / price[minIdx];
            left =  m - price[minIdx] * digit;
        }

        if (digit <= 0) {
            System.out.println(0);
            return;
        }

        int[] num = new int[digit];
        Arrays.fill(num, minIdx);

        int idx = 0;
        boolean stop = false;
        while (left > 0 && !stop && idx < digit) {
            stop = true;
            for (int i = n - 1; i >= 0; i--) {
                if (price[i] <= left + price[minIdx]) {
                    num[idx++] = i;
                    left -= (price[i] - min);
                    stop = false;
                    break;
                }
            }
        }

        for (int i = 0; i < digit; i++) {
            sb.append(num[i]);
        }

        System.out.println(sb);
    }
}
