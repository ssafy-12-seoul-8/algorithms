import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        boolean[] used = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int s = Integer.parseInt(br.readLine());

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int j = 0;
            int move = 0;
            int max = 0;
            while (j < n && move <= s) {
                if (used[j]) {
                    j++;
                    continue;
                }
                max = Math.max(max, arr[j]);
                j++;
                move++;
            }

            move = -1;
            for (int k = 0; k < n; k++) {
                if (used[k]) {
                    continue;
                }
                move++;
                if (max == arr[k]) {
                    ans[i] = arr[k];
                    used[k] = true;
                    break;
                }
            }
            s -= move;
        }

        for (int a:ans) {
            sb.append(a).append(" ");
        }

        System.out.println(sb);
    }
}
