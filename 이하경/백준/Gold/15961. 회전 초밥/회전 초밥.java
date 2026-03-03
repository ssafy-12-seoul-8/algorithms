import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] dishes = new int[n];
        int[] count = new int[d + 1];
        count[c] = 1;
        int kind = 1;
        int max = 1;

        for (int i = 0; i < n; i++) {
            dishes[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            int dish = dishes[i];
            if (count[dish] == 0) {
                kind++;
            }
            count[dish]++;
        }

        for (int i = 0; i < n; i++) {
            int prev = dishes[i];
            int next = dishes[(i + k) % n];
            count[prev]--;
            if (count[prev] == 0) {
                kind--;
            }
            if (count[next] == 0) {
                kind++;
            }
            count[next]++;
            max = Math.max(max, kind);
        }

        System.out.println(max);
    }
}
