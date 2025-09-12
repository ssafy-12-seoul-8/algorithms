import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(solve(y - x)).append("\n");
        }

        System.out.println(sb);
    }

    private static int solve(int k) {
        int n = (int) Math.ceil(Math.pow(k, 0.5));

        if (k > n * n - n) {
            return 2 * n - 1;
        }

        return 2 * n - 2;
    }
}
