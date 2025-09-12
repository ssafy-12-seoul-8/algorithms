import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int dist = -(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));
            int n = (int) Math.sqrt(dist);

            if (dist == n * n) {
                sb.append(n * 2 - 1).append("\n");
                continue;
            }

            sb.append(dist - n * n > n ? n * 2 + 1 : n * 2).append("\n");
        }

        System.out.println(sb);
    }
}