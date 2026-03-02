import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] distSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            distSum[i] = distSum[i - 1] + Integer.parseInt(br.readLine());
        }

        int l = 0;
        int r = 0;
        int ans = 0;
        while (l <= r && r < n) {
            if (distSum[r] - distSum[l] < distSum[n] / 2) {
                r++;
            } else {
                l++;
            }
            ans = Math.max(ans, Math.min(distSum[n] - (distSum[r] - distSum[l]), distSum[r] - distSum[l]));
        }

        System.out.println(ans);
    }
}
