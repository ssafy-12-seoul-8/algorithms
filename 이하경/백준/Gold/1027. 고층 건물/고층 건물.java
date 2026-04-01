import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] buildings = new int[n];
        for (int i = 0; i < n; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            double m = 1_000_000_000;
            for (int j = i - 1; j >= 0; j--) {
                double tmp = (double) (buildings[i] - buildings[j]) / (i - j);
                if (tmp < m) {
                    count++;
                    m = tmp;
                }
            }

            m = -1_000_000_000;
            for (int j = i + 1; j < n; j++) {
                double tmp = (double) (buildings[i] - buildings[j]) / (i - j);
                if (tmp > m) {
                    count++;
                    m = tmp;
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}
