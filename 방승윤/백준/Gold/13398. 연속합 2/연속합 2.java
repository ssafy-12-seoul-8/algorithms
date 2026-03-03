import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] arr = new int[n][2];
        int first = Integer.parseInt(st.nextToken());
        arr[0][0] = first;
        arr[0][1] = first;
        int ans = first;

        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i][0] = Math.max(num, arr[i - 1][0] + num);
            arr[i][1] = Math.max(arr[i - 1][0], arr[i - 1][1] + num);
            ans = Math.max(ans, Math.max(arr[i][0], arr[i][1]));
        }

        System.out.println(ans);
    }
}