import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] snows = new int[n];
        for (int i = 0; i < n; i++) {
            snows[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snows);

        int minGap = 2_000_000_000;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int left = 0;
                int right = n - 1;
                while (left < right) {
                    if (left == i || left == j) {
                        left++;
                        continue;
                    }
                    if (right == i || right == j) {
                        right--;
                        continue;
                    }
                    minGap = Math.min(minGap, Math.abs(snows[i] + snows[j] - snows[left] - snows[right]));
                    if (minGap == 0) {
                        break;
                    }
                    if (snows[i] + snows[j] < snows[left] + snows[right]) {
                        right--;
                        continue;
                    }
                    left++;
                }
            }
        }

        System.out.println(minGap);

    }
}
