import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        long[][] dot = new long[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            dot[i][0] = Long.parseLong(st.nextToken());
            dot[i][1] = Long.parseLong(st.nextToken());
            dot[i][2] = Long.parseLong(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long z = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());

            int count = 0;
            for (int j = 0; j < n; j++) {
                if ((dot[j][0]- x) * (dot[j][0] - x) + (dot[j][1] - y) * (dot[j][1] - y) + (dot[j][2] - z) * (dot[j][2] - z) <= r * r) {
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
