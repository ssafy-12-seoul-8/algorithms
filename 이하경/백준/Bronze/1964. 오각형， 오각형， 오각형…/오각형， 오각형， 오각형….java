import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long div = 45678;

        long ans = ((3 * n * n + 5 * n) / 2 + 1) % div;
        System.out.println(ans);
    }
}
