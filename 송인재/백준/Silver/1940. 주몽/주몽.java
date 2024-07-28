import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] materials = new int[n];

        br.close();

        for (int i = 0; i < n; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(materials);

        int count = 0;
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int sum = materials[start] + materials[end];
            if (sum < m) start++;
            else if (sum > m) end--;
            else {
                count++;
                start++;
                end--;
            }
        }

        System.out.println(count);
    }
}