import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        int[][] buy = new int[n][2];

        for (int i = 0; i < n; i++) {
            int l = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long value = 0;
            long maxValue = -10000;
            int from = 0;
            for (int j = 0; j < l; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (value > 0) {
                    value += num;
                } else {
                    value = num;
                    from = j;
                }
                if (value > maxValue) {
                    maxValue = value;
                    buy[i][0] = from;
                    buy[i][1] = j;
                    continue;
                }
                if (value == maxValue && buy[i][1] - buy[i][0] > j - from) {
                    buy[i][0] = from;
                    buy[i][1] = j;
                }
            }
            sum += maxValue;

        }

        sb.append(sum).append("\n");
        for (int i = 0; i < n; i++) {
            sb.append(buy[i][0] + 1).append(" ").append(buy[i][1] + 1).append("\n");
        }

        System.out.println(sb);
    }
}
