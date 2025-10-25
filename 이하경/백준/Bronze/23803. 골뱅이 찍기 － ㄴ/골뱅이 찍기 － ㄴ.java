import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    sb.append('@');
                }
                sb.append("\n");
            }
        }

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                sb.append("@@@@@");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
