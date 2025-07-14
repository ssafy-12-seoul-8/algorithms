import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[31];
        int[] bit = new int[31];
        arr[0] = A;
        bit[0] = 1;

        for (int i = 1; i < 31; i++) {
            arr[i] = (int) ((long) arr[i - 1] * arr[i - 1] % C);
            bit[i] = bit[i - 1] * 2;
        }

        int res = 1;

        for (int i = 30; i >= 0; i--) {
            if (B >= bit[i]) {
                B -= bit[i];
                res = (int) ((long) res * arr[i] % C);
            }
        }

        System.out.println(res);
    }
}