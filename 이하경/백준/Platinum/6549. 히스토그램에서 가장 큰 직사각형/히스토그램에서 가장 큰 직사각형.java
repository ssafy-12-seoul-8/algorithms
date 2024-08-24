import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] rec;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        while (n != 0) {
            rec = new int[n];
            for (int i = 0; i < n; i++) {
                rec[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(findMax(0, n - 1));

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
        }
    }

    static long findMax(int left, int right) {
        if (left == right) {
            return rec[left];
        }
        int l = (left + right) / 2;
        int r = l + 1;
        long leftMax = findMax(left, l);
        long rightMax = findMax(r , right);

        long max = Math.max(rec[l], rec[r]);
        int minHeight = Math.min(rec[l], rec[r]);
        max = Math.max(max, (long) minHeight * (r - l + 1));

        while (l > left || r < right) {
            if (l == left || (r != right && rec[l - 1] <= rec[r + 1])) { // 오른쪽으로 확장시킬 경우
                minHeight = Math.min(minHeight, rec[++r]);
                while (r < right && rec[r + 1] >= minHeight) {
                    r++;
                }
            } else {
                minHeight = Math.min(minHeight, rec[--l]);
                while (l > left && rec[l - 1] >= minHeight) {
                    l--;
                }
            }
            max = Math.max(max, (long) minHeight * (r - l + 1));
        }

        max = Math.max(max, leftMax);
        max = Math.max(max, rightMax);
        return max;
    }
}

