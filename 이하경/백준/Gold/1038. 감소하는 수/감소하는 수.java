import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n >= 1023) {
            System.out.println(-1);
            return;
        }

        if (n == 1022) {
            System.out.println(9876543210L);
            return;
        }

        if (n >= 1012) {
            int[] num = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
            int exclude = n - 1012;
            String ans = "";
            for (int i = 0; i < 10; i++) {
                if (i != exclude) {
                    ans += num[i];
                }
            }
            System.out.println(ans);
            return;
        }


        int cnt = -1;
        for (long i = 0; i < 1e10; i++) {
            if (isDecreasing(i)) {
                cnt++;
            }
            if (cnt == n) {
                System.out.println(i);
                break;
            }
        }

    }

    static boolean isDecreasing(long k) {
        int before = -1;
        while (k != 0){
            if ((int) (k % 10) > before) {
                before = (int) (k % 10);
                k /= 10;
            } else {
                return false;
            }
        }
        return true;
    }
}
