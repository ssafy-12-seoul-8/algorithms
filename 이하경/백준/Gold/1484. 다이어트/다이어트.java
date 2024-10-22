import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int g = Integer.parseInt(br.readLine());

        long k = g; // 더해진 결과
        int a = 1; // 더해줄 숫자
        while (a < g) {
            k += a;
            double root = Math.sqrt(k);
            if (root - (int) root < 1e-9) {
                sb.append((int) root).append("\n");
            }
            a += 2;
        }

        System.out.println(sb.length() == 0 ? -1 : sb);
    }
}
