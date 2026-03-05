import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][3];
        int price = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int min = Math.min(arr[i - 1][0], num);
            arr[i - 1][0] -= min;
            num -= min;
            arr[i][1] += min;

            min = Math.min(arr[i - 1][1], num);
            arr[i - 1][1] -= min;
            num -= min;
            arr[i][2] += min;

            arr[i][0] = num;

            price += 3 * arr[i - 1][0] + 5 * arr[i - 1][1] + 7 * arr[i - 1][2];
        }

        price += 3 * arr[n][0] + 5 * arr[n][1] + 7 * arr[n][2];

        System.out.println(price);
    }
}
