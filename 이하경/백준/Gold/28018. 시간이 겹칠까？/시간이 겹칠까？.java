import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] diff = new int[1_000_002];
        int[] sum = new int[1_000_002];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            diff[start] += 1;
            diff[end + 1] -= 1;
        }

        for (int i = 1; i < diff.length; i++) {
            sum[i] = sum[i - 1] + diff[i];
        }

        int q = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int time = Integer.parseInt(st.nextToken());
            sb.append(sum[time]).append("\n");
        }

        System.out.println(sb);
    }
}
