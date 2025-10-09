import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int sum = 0;

        int tmp = 1;
        for (int i = 0; i < x; i++) {
            sum += tmp;
            tmp *= 10;
        }

        tmp = 1;
        for (int i = 0; i < y; i++) {
            sum += tmp;
            tmp *= 10;
        }

        System.out.println(sum);
    }
}
