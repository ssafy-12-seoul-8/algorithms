import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] height = new int[n];
        int[] diff = new int[n - 1];
        height[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
            diff[i - 1] = height[i] - height[i - 1];
        }

        Arrays.sort(diff);

        int sum = 0;
        for (int i = 0; i < n - k; i++) {
            sum += diff[i];
        }

        System.out.println(sum);
    }
}
