import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        boolean[] use = new boolean[100_001];

        int start = 0;
        long count = 0;
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
            while (use[num]) {
                use[nums[start++]] = false;
            }
            use[num] = true;
            count += (i - start + 1);
        }

        System.out.println(count);
    }
}
