import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 계획 120개, 각각 30시간 이내이므로 최대 38 * 120 - 8 = 4552
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int time = 0;
        for (int i = 0; i < n; i++) {
            time += Integer.parseInt(st.nextToken());
            time += 8;
        }

        time -= 8;

        sb.append(time / 24).append(" ").append(time % 24);
        System.out.println(sb);
    }
}
