import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int k = 0;
        boolean[] p = new boolean[50001];

        for (int i = 2; i < p.length; i++) {
            if (!p[i]) {
                sb.append(i).append(" ");
                k += 1;

                if (k == n) {
                    break;
                }

                for (int j = i * 2; j < p.length; j += i) {
                    p[j] = true;
                }
            }
        }

        System.out.println(sb);
    }
}
