import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[][] points = new long[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Long.parseLong(st.nextToken());
            points[i][1] = Long.parseLong(st.nextToken());
            points[i][2] = Long.parseLong(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long z = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            
            long rSquared = r * r; 
            int count = 0;

            for (int i = 0; i < N; i++) {
                long dx = x - points[i][0];
                long dy = y - points[i][1];
                long dz = z - points[i][2];

                if (dx * dx + dy * dy + dz * dz <= rSquared) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}