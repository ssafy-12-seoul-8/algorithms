import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sols = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int s1 = 0, s2 = sols[n - 1], s = 0, e = n - 1, ans = Integer.MAX_VALUE;

        while (s < e) {
            int tmp = sols[s] + sols[e];
            if (Math.abs(tmp) < ans) {
                s1 = s;
                s2 = e;
                ans = Math.abs(tmp);
            }
            if (tmp == 0){
                break;
            } else if (tmp > 0) {
                e--;
            } else {
                s++;
            }
        }

        System.out.println(sols[s1] + " " + sols[s2]);
    }
}
