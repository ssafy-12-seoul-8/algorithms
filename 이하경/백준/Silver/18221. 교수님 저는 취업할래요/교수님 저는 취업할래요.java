import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] classroom = new int[n][n];

        int r1 = n, r2 = 0, c1 = n, c2 = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                classroom[i][j] = Integer.parseInt(st.nextToken());
                if (classroom[i][j] == 2 || classroom[i][j] == 5) {
                    r1 = Math.min(r1, i);
                    r2 = Math.max(r2, i);
                    c1 = Math.min(c1, j);
                    c2 = Math.max(c2, j);
                }
            }
        }

        if (((r2 - r1) * (r2 - r1) + (c2 - c1) * (c2 - c1)) < 25) {
            System.out.println(0);
            return;
        }

        int count = 0;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (classroom[i][j] == 1) {
                    count++;
                }
            }
        }

        if (count < 3) {
            System.out.println(0);
            return;
        }

        System.out.println(1);
    }
}
