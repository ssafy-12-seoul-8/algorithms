import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int bit = a + b <= n ? a + b : n * 2 - a - b;
        int ans = 0;
        for (int i = 0; i < bit; i++) {
            ans = (ans | (1 << i));
        }

        ans = (ans << (n - bit));
        System.out.println(ans);
    }
}
