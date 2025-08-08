import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long K = Long.parseLong(st.nextToken());

            long powK = 1L << K;

            if (N < powK || K > 63) {
                sb.append(0).append("\n");
            } else {
                long cnt = N / powK - N / (powK << 1);
                sb.append(cnt).append("\n");
            }
        }

        System.out.print(sb);
    }
}
