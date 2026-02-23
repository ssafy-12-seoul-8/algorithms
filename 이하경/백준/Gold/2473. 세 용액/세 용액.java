import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] sol = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sol[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sol);
        long minMix = Long.MAX_VALUE;
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                long sum = (long) sol[i] + sol[l] + sol[r];
                if (Math.abs((long) sol[i] + sol[l] + sol[r]) < minMix) {
                    minMix = Math.abs((long) sol[i] + sol[l] + sol[r]);
                    a = sol[i];
                    b = sol[l];
                    c = sol[r];
                }
                if (sum > 0) {
                    r--;
                    continue;
                }
                if (sum < 0) {
                    l++;
                    continue;
                }
                break;
            }
        }

        sb.append(a).append(" ").append(b).append(" ").append(c);
        System.out.println(sb);
    }
}
