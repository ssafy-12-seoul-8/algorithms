import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[][] point = new long[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            point[i][0] = Long.parseLong(st.nextToken());
            point[i][1] = Long.parseLong(st.nextToken());
        }

        Long area = 0L;
        for (int i = 1; i < n - 1; i++) {
            area += (point[0][0] * point[i][1] + point[i][0] * point[i + 1][1] + point[i + 1][0] * point[0][1])
                    - (point[i][0] * point[0][1] + point[i + 1][0] * point[i][1] + point[0][0] * point[i + 1][1]);
        }

        System.out.printf("%.1f", Math.abs(area) / 2.0);
    }
}
