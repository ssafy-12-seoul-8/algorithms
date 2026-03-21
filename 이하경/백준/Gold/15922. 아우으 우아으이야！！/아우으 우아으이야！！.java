import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int len = 0;
        int start = -1_000_000_000;
        int end = -1_000_000_000;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x > end) {
                len += (end - start);
                start = x;
                end = y;
                continue;
            }

            end = Math.max(end, y);
        }

        len += (end - start);
        System.out.println(len);
    }
}
