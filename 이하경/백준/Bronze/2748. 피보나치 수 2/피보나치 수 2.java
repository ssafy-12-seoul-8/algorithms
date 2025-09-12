import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] fivo = new long[n + 1];
        
        fivo[1] = 1;

        for (int i = 2; i <= n; i++) {
            fivo[i] = fivo[i - 2] + fivo[i - 1];
        }

        System.out.println(fivo[n]);
    }
}
