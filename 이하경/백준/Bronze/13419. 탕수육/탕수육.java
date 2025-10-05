import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            if (s.length() == 1) {
                sb.append(s).append("\n").append(s).append("\n");
                continue;
            }

            if (s.length() == 2) {
                sb.append(s.charAt(0)).append("\n").append(s.charAt(1)).append("\n");
                continue;
            }

            for (int i = 0; i != s.length() - 2;) {
                sb.append(s.charAt(i));
                i = (i + 2) % s.length();
            }
            sb.append(s.charAt(s.length() - 2));
            sb.append("\n");

            for (int i = 1; i != s.length() - 1;) {
                sb.append(s.charAt(i));
                i = (i + 2) % s.length();
            }
            sb.append(s.charAt(s.length() - 1));
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
