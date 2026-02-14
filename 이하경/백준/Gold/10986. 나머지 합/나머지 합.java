import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] count = new int[m]; // 나머지가 i인 누적합 개수 담기
        count[0] = 1; // 아무것도 안 더했을떄

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            sum = (sum + k) % m;
            count[sum] += 1;
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            ans += ((long) count[i] * (count[i] - 1)) / 2;
        }

        System.out.println(ans);
    }
}
