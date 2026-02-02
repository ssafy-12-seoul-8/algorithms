import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 합은 최대 10,000 * 10,000 = 100,000,000 < int
// 처음 x개를 합한 숫자가 가능한지
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int m = Integer.parseInt(br.readLine());
            int[] nums = new int[m];

            for (int i = 0; i < m / 10; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 10; j++) {
                    nums[i * 10 + j] = Integer.parseInt(st.nextToken());
                }
            }

            if (m % 10 != 0) {
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < m % 10; i++) {
                    nums[m - m % 10 + i] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += nums[i];
                max = Math.max(max, nums[i]);
            }

            int count = 1;
            while (count <= m) {
                int target = 0;

                for (int i = 0; i < count; i++) {
                    target += nums[i];
                }

                if (sum % target != 0 || target < max) {
                    count++;
                    continue;
                }

                if (sum / target == 1) {
                    sb.append(sum).append("\n");
                    break;
                }

                int tmp = 0;
                boolean flag = true;
                for (int i = count; i < m; i++) {
                    tmp += nums[i];
                    if (tmp == target) {
                        tmp = 0;
                        continue;
                    }
                    if (tmp > target) {
                        count++;
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    sb.append(target).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
