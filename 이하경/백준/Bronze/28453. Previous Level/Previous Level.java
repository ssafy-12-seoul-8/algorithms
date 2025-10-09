import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] maxlev = { 300, 275, 250 };
        for (int i = 0; i < n; i++) {
            int level = Integer.parseInt(st.nextToken());
            int section = 4;
            for (int j = 0; j < 3; j++) {
                if (level >= maxlev[j]) {
                    section = j + 1;
                    break;
                }
            }
            sb.append(section).append(" ");
        }

        System.out.println(sb);
    }
}
