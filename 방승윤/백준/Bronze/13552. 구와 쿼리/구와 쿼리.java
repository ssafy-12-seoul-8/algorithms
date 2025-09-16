import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] dots = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            dots[i][0] = x;
            dots[i][1] = y;
            dots[i][2] = z;
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int cnt = 0;

            for (int j = 0; j < N; j++) {
                long dx = dots[j][0] - x;
                long dy = dots[j][1] - y;
                long dz = dots[j][2] - z;
                long dSquare = dx * dx + dy * dy + dz * dz;
                long rSquare = (long) r * r;

                if (rSquare >= dSquare) {
                   cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}