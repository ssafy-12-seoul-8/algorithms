import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int k = 1;
        for (int i = 0; i < n; i++) {
            sb.append(k).append(" ");
            k += 2;
        }

        System.out.println(sb);
    }
}
