import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                }
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        sb.append(dp[s1.length()][s2.length()]).append("\n");
        print(s1.length(), s2.length(), s1, s2, sb, dp);
        System.out.println(sb);
    }

    public static void print(int i, int j, String s1, String s2, StringBuilder sb, int[][] dp) {
        if (dp[i][j] == 0) {
            return;
        }
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            print(i - 1, j - 1, s1, s2, sb, dp);
            sb.append(s1.charAt(i - 1));
            return;
        }
        if (dp[i - 1][j] >= dp[i][j - 1]) {
            print(i - 1, j, s1, s2, sb, dp);
        } else {
            print(i, j - 1, s1, s2, sb, dp);
        }
    }
}
