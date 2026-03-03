import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int first = Integer.parseInt(st.nextToken());
        arr[0] = first;
        int ans = first;

        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = Math.max(num, arr[i - 1] + num);
            ans = Math.max(ans, arr[i]);
        }

        System.out.println(ans);
    }
}