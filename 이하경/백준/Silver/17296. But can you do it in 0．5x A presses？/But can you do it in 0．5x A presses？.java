import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int count = 0;
        for (int i = 0; i < n; i++) {
            Double num = Double.parseDouble(st.nextToken());
            if (count == 0) {
                count += (int) Math.ceil(num);
                continue;
            }
            count += (int) Math.floor(num);
        }

        System.out.println(count);
    }
}
