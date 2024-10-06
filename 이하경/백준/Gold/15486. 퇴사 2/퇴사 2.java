import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Counsel[] works = new Counsel[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int needDay = Integer.parseInt(st.nextToken());
            int income = Integer.parseInt(st.nextToken());

            works[i] = new Counsel(i, i + needDay, income); // startDay 미포함 endDay 포함
        }

        Arrays.sort(works, Comparator.comparingInt(o -> o.endDay)); // 끝나는 날 오름차순 정렬

        // 모든 상담을 다 한다면 1000*1,500,000 < int
        int[] dp = new int[n + 1]; // i일에 얻을 수 있는 최대수익
        int lastCheck = 0;
        for (Counsel c : works) {
            if (c.endDay > n) {
                break;
            }

            for (int i = lastCheck + 1; i <= c.endDay; i++) {
                dp[i] = dp[lastCheck]; // 마지막으로 구한 날짜 다음을 같은값으로 채워준다
            }

            dp[c.endDay] = Math.max(dp[c.endDay], dp[c.startDay] + c.income);
            lastCheck = c.endDay;
        }

        System.out.println(dp[lastCheck]);
    }

    static class Counsel {
        int startDay, endDay, income;

        public Counsel(int startDay, int endDay, int income) {
            this.startDay = startDay;
            this.endDay = endDay;
            this.income = income;
        }
    }
}
