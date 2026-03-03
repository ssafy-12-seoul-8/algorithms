import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int highest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(st.nextToken());
            highest = Math.max(highest, sum);

            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.println(highest);
    }
}