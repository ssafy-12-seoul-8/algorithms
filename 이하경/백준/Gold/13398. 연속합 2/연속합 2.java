import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int sum = Integer.parseInt(st.nextToken());
        int exSum = sum;
        int max = sum;

        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 이걸 더했을때 sum보다 커진다면 더하고, sum보다 작아진다면 지운다
            if (exSum + num < sum) {
                exSum = sum;
            } else {
                exSum += num;
            }

            max = Math.max(max, exSum);

            if (sum < 0) {
                sum = num;
            } else {
                sum += num;
            }

            max = Math.max(max, sum);
        }

        System.out.println(max);

    }
}
